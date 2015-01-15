package controllers;

import com.avaje.ebean.Ebean;
import forms.LoginForm;
import forms.RegisterForm;
import models.human.Volunteer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Results;

import com.fasterxml.jackson.databind.node.ObjectNode;
import helper.CryptIt;
import java.math.BigDecimal;
import models.User;
import models.fixed.Country;
import models.fixed.Gender;
import org.apache.commons.mail.EmailException;

/**
 * The security controller allows for a secure login to the system. To this end,
 * it offers login and logout methods that verifies users based on their
 * username/mail address and password. It creates an authentication token
 * whenever the login was successful, ie. the user was already registered and
 * provided the correct password. The token is destroyed when the user logs out,
 * or after some idle timeout.
 *
 * @author Michael Bredel <michael.bredel@fh-kufstein.ac.at>
 *
 *
 * Folgende Funktionen sollen im SecurityController realisiert werden: - wie
 * bereits vorhanden : register, login, logout - logout momentan nocht nicht
 * geroutet - für Methoden auf die geroutet wird - mit Secured Annotation ?! -
 * passwort zurücksetzen -> bestätigungsmail
 *
 */
public class SecurityController extends Controller {

    /**
     * Logger to log SecurityController events.
     */
    private static Logger LOGGER = LoggerFactory.getLogger(SecurityController.class);
    /**
     * The authentication token header for the Play framework.
     */
    protected final static String AUTH_TOKEN_HEADER = "X-AUTH-TOKEN";
    /**
     * The authentication token for the Play framework.
     */
    protected static final String AUTH_TOKEN = "authToken";

    /**
     * Identifies a user based on ... ? TODO: What does Http.Context.current
     * .... actually do?
     *
     * @return <b>User</b> The user that was identified based in...?
     */
    //@Security.Authenticated(Secured.class)
    public static User getUser() {
        return (User) Http.Context.current().args.get("user");
    }

    /**
     * The login method reads all the relevant information, ie. the user mail
     * address and the password from the login form. It then tries to verify the
     * user in the database based in the user credentials. If the user is
     * verified successfully, the method returns an authentication token.
     *
     * @return <b>Result</b> A resulting JSON object containing the
     * authentication token or null.
     */
    public static Result login() {
        // The login form.
        Form<LoginForm> form = Form.form(LoginForm.class).bindFromRequest();

        // Check the form itself for errors.
        if (form.hasErrors()) {
            return Results.badRequest(form.errorsAsJson());
        }

        // Get the login information from the login form.
        LoginForm loginForm = form.get();

        // Find the user in the database. Return null if the
        // user was not found or could not be verified.
        User user = User.findByNameAndPassword(loginForm.mail, CryptIt.cleartextToHash(loginForm.password));

        if (user == null) {
            if (LOGGER.isInfoEnabled()) {
                LOGGER.info("Unauthorized login attempt for user " + loginForm.mail + " using password: " + loginForm.password);
            }
            return Results.unauthorized();
        } //if User has not confirmed the confirmation mail
        else if (!user.isMailConfirmed()) {
            if (LOGGER.isInfoEnabled()) {
                LOGGER.info("Unauthorized login attempt for user " + loginForm.mail + " using password: " + loginForm.password + " Confirmation Email not confirmed " + user.isMailConfirmed());
            }
            return Results.unauthorized("Please confirm your e-Mail address");
        } //User not null and mail confirmed
        else {
            user.updateLastLogin();
            String authToken = user.getAuthToken();

            if (authToken == null) {
                authToken = user.createToken();
            }

            ObjectNode loginJson = Json.newObject();
            loginJson.put(AUTH_TOKEN, authToken);
            response().setCookie(AUTH_TOKEN, authToken);
            // Add the user information to the result.
            //loginJson.put("UserLogin", user.toJson());
            // TODO: Search the corresponding volunteer and add its data to the JsonObject that is responded.

            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Authorized login attempt. User " + user.getUserName() + " logged in successfully.");
            }
            return Results.ok(loginJson);
        }

    }

    /**
     * The logout method that removes the authentication token of the user and
     * redirects to the default homepage.
     *
     * @return <b>Result</b> The redirect result.
     */
    public static Result logout() {
        response().discardCookie(AUTH_TOKEN);
        getUser().deleteAuthToken();
        return Results.redirect("/");
    }

    /**
     *
     * @return <b>Result</b> A resulting JSON object containing the
     * authentication token or null.
     */
    public static Result register() {
        // The register form.
        Form<RegisterForm> form = Form.form(RegisterForm.class).bindFromRequest();

        // Get the login information from the login form.
        RegisterForm registerForm = form.get();

        // Find the user in the database. Return null if the
        // user was not found.
        User user = User.findByName(registerForm.getMail());

        if (user == null) {
            user = new User(registerForm.getPassword(), CryptIt.cleartextToHash(registerForm.getPassword()));
            Volunteer v = new Volunteer(user, registerForm.getPrename(), registerForm.getPrename(), Ebean.find(Gender.class, registerForm.getGender()), Ebean.find(Country.class, registerForm.getNationality()), registerForm.getBirthdate());
            v.save();
            //verificationSend(volunteer);
            return ok();
        } else {
            LOGGER.info("User already exists in database.");
            return Results.badRequest("user exist already");
        }
    }

    // send a verification token to registered users
    public static void verificationSend(Volunteer volunteer) {

//        String authToken = volunteer.getUser().createToken();
//
//        String prename = volunteer.getPrename();
//        String surname = volunteer.getSurname();
//        String mailAddress = volunteer.getUser().getUserName();
//
//        try {
//            mailer.Mail.confirmationMail(prename, surname, mailAddress, authToken);
//            LOGGER.info("Confirmation Mail to User " + mailAddress + " sended");
//
//        } catch (EmailException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            LOGGER.debug("Confirmation for User " + mailAddress + " not successfully: " + e);
//        }
    }

    //checks if the sended verification token is already saved in DB - then redirects
    public static Result verificationGetter(String authToken) {
        User user = User.findByAuthToken(authToken);
        if (user == null) {
            if (LOGGER.isInfoEnabled()) {
                LOGGER.info("Verification not successful");
            }
            //return Results.unauthorized();   
            return Results.redirect("/");
        } else {
            // Zeit checken - creationTime zu  jetzt
            user.updateLastLogin();
            user.setMailConfirmed(true);
            LOGGER.debug("" + user.isMailConfirmed());
            ObjectNode loginJson = Json.newObject();

            loginJson.put(AUTH_TOKEN, authToken);
            response().setCookie(AUTH_TOKEN, authToken);
            // Add the user information to the result.

            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Verification attempt. User " + user.getUserName() + " logged in successfully.");
            }

            //return Results.ok(loginJson);
            return Results.redirect("/");
        }
    }

    //Method to reset the password - send a mail to confirm
    public static Result sendResetToken() {
        // The register form.
        Form<LoginForm> form = Form.form(LoginForm.class).bindFromRequest();

        // Check the form itself for errors.
        if (form.hasErrors()) {
            return Results.badRequest(form.errorsAsJson());
        }

        // Get the login information from the login form.
        LoginForm loginForm = form.get();

        // Find the user in the database. Return null if the
        // user was not found.
        User user = User.findByName(loginForm.mail);

        //Code for reseting the PW

        String authToken = user.createToken();
        Volunteer volunteer = Volunteer.findByUsername(user.getUserName());

        try {
            mailer.Mail.resetMail(volunteer.getPrename(), volunteer.getSurname(), user.getUserName(), authToken);
            LOGGER.info("Passwort Token für " + user.getUserName() + " sended");
        } catch (EmailException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            LOGGER.debug("ResetToken for User " + user.getUserName() + " not successfully sended: " + e);
        }

        return Results.ok("Reset confirmation mail sended");
    }

    public static Result getUserPasswordReset(String authToken) {

        User user = User.findByAuthToken(authToken);
        ObjectNode resetJson = Json.newObject();
        resetJson.put("user", helper.JSONHelper.objectToJsonAndPlot(user));

        return Results.ok(resetJson);

    }

    public static Result resetPassword() {

        // New Form -- e.g. ResetForm
        Form<LoginForm> form = Form.form(LoginForm.class).bindFromRequest();

        // Check the form itself for errors.
        if (form.hasErrors()) {
            return Results.badRequest(form.errorsAsJson());
        }

        // Get the login information from the login form.
        LoginForm loginForm = form.get();

        User user = User.findByName(loginForm.mail);

        if (user == null) {
            if (LOGGER.isInfoEnabled()) {
                LOGGER.info("Verification failed");
            }
            //return Results.unauthorized();   
            return Results.badRequest("User not found!");

        } else {

            user.setPassword(loginForm.password);

            // neuer Token wird erstellt - damit Mail ungülutig wird sobald Passwort geändert
            user.createToken();
            user.save();

            LOGGER.info("Password for User " + user.getUserName() + "reseted");

            ObjectNode tokenJson = Json.newObject();
            tokenJson.put("user", helper.JSONHelper.objectToJsonAndPlot(user));

            return Results.ok(tokenJson);

        }
    }
}
