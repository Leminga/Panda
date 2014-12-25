package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import models.volunteer.Volunteer;
import helper.IdentificationType;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Identification extends Model {
	
	/** The serialization version identifier. */
	private static final long serialVersionUID = 1L;
	
	@Required
	private String identificationNumber;
	@Required
	private IdentificationType identificationType;
	@Required
	private Date expiryDate;
	
	//ManyToOne Relation to Volunteer
	@ManyToOne // owning side
	private Volunteer volunteer;
	
	
	public String getIdentificationNumber() {
		return identificationNumber;
	}
	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}
	public IdentificationType getIdentificationType() {
		return identificationType;
	}
	public void setIdentificationType(IdentificationType identificationType) {
		this.identificationType = identificationType;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	
	
	

}
