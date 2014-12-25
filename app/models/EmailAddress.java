package models;

import javax.persistence.Entity;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class EmailAddress extends Model{
	
	public EmailAddress(String emailAddress) {
		super();
		this.emailAddress = emailAddress;
	}

	/** The serialization version identifier. */
	private static final long serialVersionUID = 1L;
	
	 @Required
	 private String emailAddress;

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	 
	 

}
