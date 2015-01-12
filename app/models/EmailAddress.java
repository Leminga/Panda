package models;

import javax.persistence.Entity;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

/*
 * speichert die EmailAdresse des Volunteers
 */
@Entity
public class EmailAddress extends Model{

	/** The serialization version identifier. */
	private static final long serialVersionUID = 1L;
	
	@Required
	private String emailAddress;

	/*
	 * Getter und Setter
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	/*
	 * Konstruktor der Klasse
	 */
	public EmailAddress(String emailAddress) {
		super();
		this.emailAddress = emailAddress;
	} 

}
