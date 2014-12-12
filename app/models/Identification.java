package models;

import java.util.Date;

import javax.persistence.Entity;

import helper.IdentificationType;
import play.data.validation.Constraints.Required;

@Entity
public class Identification {
	
	@Required
	private String identificationNumber;
	@Required
	private IdentificationType identificationType;
	@Required
	private Date expiryDate;
	
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
