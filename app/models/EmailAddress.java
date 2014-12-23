package models;

import play.db.ebean.Model.Finder;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.libs.Json;

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
