package forms;

import play.data.validation.Constraints;
/*
 **
 * Maps the coredata form fields to a register object.
 * 
 * @author Manuel Dorfer
 */

public class VolunteerForm extends RegisterForm {

    @Constraints.Required
    public String socialSecurityNumber;
    @Constraints.Required
    public String city;
    @Constraints.Required
    public String address;
    @Constraints.Required
    public String plz;
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
    public String preferredCommunicationLanguage;
}
