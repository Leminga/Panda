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
	@GeneratedValue
	private Long ID;
	@Required
	private String countryCode;
	private String countryNameDE;
	private String countryNameEN;
	@Required
	private int countryCallingCode;
	
	
	public Long getID() {
		return ID;
	}
	public void setID(Long iD) {
		ID = iD;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getCountryNameDE() {
		return countryNameDE;
	}
	public void setCountryNameDE(String countryNameDE) {
		this.countryNameDE = countryNameDE;
	}
	public String getCountryNameEN() {
		return countryNameEN;
	}
	public void setCountryNameEN(String countryNameEN) {
		this.countryNameEN = countryNameEN;
	}
	public int getCountryCallingCode() {
		return countryCallingCode;
	}
	public void setCountryCallingCode(int countryCallingCode) {
		this.countryCallingCode = countryCallingCode;
	}
	
	
	
	
	

}
