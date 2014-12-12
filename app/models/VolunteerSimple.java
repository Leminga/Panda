package models;

import javax.persistence.Entity;

import play.data.validation.Constraints.Required;

@Entity
public class VolunteerSimple extends Human {
	@Required
	private String socialSecurityNumber;
	
	public String getSocialSecurityNumber() {
		return this.socialSecurityNumber;
	}
	
	public void SetSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}

}
