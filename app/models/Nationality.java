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


public class Nationality {
	@Id
	@Required
	private String countryCode;
	@Required
	private String countryName;
	@Required
	private int countryCallingCode;
	
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public int getCountryCallingCode() {
		return countryCallingCode;
	}
	public void setCountryCallingCode(int countryCallingCode) {
		this.countryCallingCode = countryCallingCode;
	}
	
	
	
	

}
