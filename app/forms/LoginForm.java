package forms;

import play.data.validation.Constraints;


public class LoginForm {
	 /**
 * Maps the login form fields to a
 * login object.
 * 
 * @author Michel Bredel <michael.bredel@fh-kufstein.ac.at>
	/** The email address of the user. */
    @Constraints.Required
    @Constraints.Email
    public String email;
    /** The password (as a MD5-Hash) of the user. */
    @Constraints.Required
    public String password;
}







