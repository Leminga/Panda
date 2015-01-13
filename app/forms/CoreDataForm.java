package forms;

import play.data.validation.Constraints;
/*
**
* Maps the coredata form fields to a register object.
* 
* @author Manuel Dorfer
*/
public class CoreDataForm extends RegisterForm {
	/**
	 * Core Data inherit from RegisterForm - prename, surname, password and
	 * e-mail.
	 */

	/**
	 * The gender. AngularJS calls Form gender - not sex
	 */
	@Constraints.Required
	public String gender;
	/** The date of birth of the person. */
	@Constraints.Required
	public String dateOfBirth;
	/** The (multiple) nationalities of the person. */
	@Constraints.Required
	// @ManyToMany(cascade = CascadeType.ALL)
	public String nationality;
	@Constraints.Required
	public String socialSecurityNumber;
	@Constraints.Required
	public String city;
	@Constraints.Required
	public String country;
	@Constraints.Required
	public String houseNumber;
	@Constraints.Required
	public String street;
	@Constraints.Required
	public String zip;
	@Constraints.Required
	public String phoneNumber;
	@Constraints.Required
	public String emailAddress;
	@Constraints.Required
	public String preferredCommunicationLanguage;

	@Constraints.Required
	public String em_email;
	@Constraints.Required
	public String em_phonenumber;
	@Constraints.Required
	public String em_prename;
	@Constraints.Required
	public String em_relation;
	@Constraints.Required
	public String em_surname;
	
	public String profilePicture;

}