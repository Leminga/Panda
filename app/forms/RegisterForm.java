package forms;

/**
 * Maps the register form fields to a
 * register object.
 * 
 * @author Michel Bredel <michael.bredel@fh-kufstein.ac.at>
 */
public class RegisterForm extends LoginForm {
	/** The name of the user. */
	public String prename;
	/** The surname of the user. */
	public String surname;
	/** The nationality of the user. */
	public String nationality;
}