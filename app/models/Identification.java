package models;

import play.db.ebean.Model.Finder;
import helper.IdentificationType;

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
