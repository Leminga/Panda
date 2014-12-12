package controllers;

import models.User;

import com.fasterxml.jackson.databind.node.ObjectNode;

import play.Logger;
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
	/** The authentication token header for the Play framework. */
	public final static String AUTH_TOKEN_HEADER = "X-AUTH-TOKEN";
	/** The authentication token for the Play framework. */
    public static final String AUTH_TOKEN = "authToken";

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
    public static User getUser() {
        return (User) Http.Context.current().args.get("user");
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
    	Form<Login> loginForm = Form.form(Login.class).bindFromRequest();

    	// Check the form itself for errors.
        if (loginForm.hasErrors()) {
            return Results.badRequest(loginForm.errorsAsJson());
        }
        
        // Get the login information from the login form.
        Login login = loginForm.get();
        
        // Find the user in the database. Return null if the
        // user was not found or could not be verified.
        User user = User.findByEmailAddressAndPassword(login.email, login.password);
        
        if (user == null) {
        	Logger.debug("Unauthorized login attempt.");
            return Results.unauthorized();
        } else {
            String authToken = user.createToken();
            ObjectNode authTokenJson = Json.newObject();
            authTokenJson.put(AUTH_TOKEN, authToken);
            response().setCookie(AUTH_TOKEN, authToken);
            Logger.debug("Autherzided login attempt. User " + user.fullName + " logged in successfully.");
            return Results.ok(authTokenJson);
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
    public static Result registerNewUser() {
    	// The login form.
    	Form<Register> registerForm = Form.form(Register.class).bindFromRequest();
    	
    	// Check the form itself for errors.
        if (registerForm.hasErrors()) {
            return Results.badRequest(registerForm.errorsAsJson());
        }
        
        // Get the login information from the login form.
        Register register = registerForm.get();
        
        // Find the user in the database. Return null if the
        // user was not found.
        User user = User.findUserByEmailAddress(register.email);
        
        if (user == null) {
        	Logger.info("New user to register. " + register.email);
        	user = new User(register.email, register.password, register.name + " " + register.surname);
        	String authToken = user.createToken();
            ObjectNode authTokenJson = Json.newObject();
            authTokenJson.put(AUTH_TOKEN, authToken);
            response().setCookie(AUTH_TOKEN, authToken);
            return Results.ok("user registration ok");
        } else {
        	Logger.info("User already exists in database.");
        	return Results.ok("user exist alread");
        }
    }
    
    /**
     * Maps the login form fields to a
     * login object.
     * 
     * @author Michel Bredel <michael.bredel@fh-kufstein.ac.at>
     */
    public static class Login {
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
    public static class Register extends Login {
    	/** The name of the user. */
    	public String name;
    	/** The surname of the user. */
    	public String surname;
    }
}
