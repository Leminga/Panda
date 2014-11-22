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

public class Phone {
	
	@Required
	private int phoneNumber;
	@Required
	private Nationality countryCallingCode;
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Nationality getCountryCallingCode() {
		return countryCallingCode;
	}
	public void setCountryCallingCode(Nationality countryCallingCode) {
		this.countryCallingCode = countryCallingCode;
	}
	
	
	
	

}
