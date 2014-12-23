package controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import models.UserLogin;
import models.volunteer.Volunteer;

import com.fasterxml.jackson.databind.node.ObjectNode;

import play.libs.Json;
import play.mvc.*;
import play.data.Form;
import play.data.validation.Constraints;

/**
 * The security controller allows for a secure
 * login to the system. To this end, it offers
 * login and logout methods that verifies users
 * based on their username/email address and 
 * password. It creates an authentication token
 * whenever the login was successful, ie. the 
 * user was already registered and provided the
 * correct password. The token is destroyed when
 * the user logs out, or after some idle timeout.
 * 
 * @author Michael Bredel <michael.bredel@fh-kufstein.ac.at>
 */
public class SecurityController extends Controller {
	/** Logger to log SecurityController events. */
	private static Logger LOGGER = LoggerFactory.getLogger(SecurityController.class);
	/** The authentication token header for the Play framework. */
	protected final static String AUTH_TOKEN_HEADER = "X-AUTH-TOKEN";
	/** The authentication token for the Play framework. */
    protected static final String AUTH_TOKEN = "authToken";

    /** 
     * This should somehow present the login screen.
     * However, I copied that piece of code from the
     * Application.java ... and I have not really an
     * understanding of what it does ...
     */
    public static Result index() {
    	//Ok(Json.toJson(names)).as(JSON)
        //return Results.ok(index.render(".ady"));
    	return ok("test");
    }
    
    /**
     * Identifies a user based on ... ?
     * TODO: What does Http.Context.current .... actually do?
     * 
     * @return <b>User</b> The user that was identified based in...?
     */
    public static UserLogin getUser() {
        return (UserLogin) Http.Context.current().args.get("user");
    }
    
    /**
     * The login method reads all the relevant information, ie.
     * the user email address and the password from the login
     * form. It then tries to verify the user in the database
     * based in the user credentials. If the user is verified
     * successfully, the method returns an authentication token.
     * 
     * @return <b>Result</b> A resulting JSON object containing the authentication token or null.
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
        UserLogin user = UserLogin.findByNameAndPassword(loginForm.email, loginForm.password);
        
        if (user == null) {
        	if (LOGGER.isInfoEnabled()) {
        		LOGGER.info("Unauthorized login attempt for user " + loginForm.email);
        	}
            return Results.unauthorized();
        } else {
        	user.updateLastLogin();
            String authToken = user.createToken();
            ObjectNode loginJson = Json.newObject();
            loginJson.put(AUTH_TOKEN, authToken);
            response().setCookie(AUTH_TOKEN, authToken);
            // Add the user information to the result.
            loginJson.put("UserLogin", user.toJson());
            // TODO: Search the corresponding volunteer and add its data to the JsonObject that is responded.
            
            if (LOGGER.isDebugEnabled()) {
            	LOGGER.debug("Authorized login attempt. User " + user.getUsername() + " logged in successfully.");
            }
            return Results.ok(loginJson);
        }
    }
    
    /**
     * The logout method that removes the authentication
     * token of the user and redirects to the default
     * homepage.
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
     * @return <b>Result</b> A resulting JSON object containing the authentication token or null.
     */
    public static Result register() {
    	// The register form.
    	Form<RegisterForm> form = Form.form(RegisterForm.class).bindFromRequest();
    	
    	// Check the form itself for errors.
        if (form.hasErrors()) {
            return Results.badRequest(form.errorsAsJson());
        }
        
        // Get the login information from the login form.
        RegisterForm registerForm = form.get();
        
        // Find the user in the database. Return null if the
        // user was not found.
        UserLogin user = UserLogin.findByName(registerForm.email);
        
        if (user == null) {
        	LOGGER.info("New user to register: " + registerForm.email);
        	user = new UserLogin(registerForm.email, registerForm.password);
        	Volunteer volunteer = new Volunteer(registerForm.prename, registerForm.surname, registerForm.email);
        	volunteer.setUserLogin(user);
        	try {
        		volunteer.save();
        		user.save();
        		// START TESTING : Activity service to send an email.
        		//ServicesTimer.startProcess();
        		// END TESTING
        		return Results.ok(volunteer.toJson());
        	} catch (Exception e) {
        		// Make sure to clean up the database if something went wrong.
        		volunteer.delete();
        		user.delete();
        		return Results.ok("user registration failed");
        	}
        } else {
        	LOGGER.info("User already exists in database.");
        	return Results.ok("user exist already");
        }
    }
    
    /**
     * Maps the login form fields to a
     * login object.
     * 
     * @author Michel Bredel <michael.bredel@fh-kufstein.ac.at>
     */
    public static class LoginForm {
    	/** The email address of the user. */
        @Constraints.Required
        @Constraints.Email
        public String email;
        /** The password (as a MD5-Hash) of the user. */
        @Constraints.Required
        public String password;
    }
    
    /**
     * Maps the register form fields to a
     * register object.
     * 
     * @author Michel Bredel <michael.bredel@fh-kufstein.ac.at>
     */
    public static class RegisterForm extends LoginForm {
    	/** The name of the user. */
    	public String prename;
    	/** The surname of the user. */
    	public String surname;
    }
}
