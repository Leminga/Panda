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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


public class Nationality {
	@Id
	@Required
	@GeneratedValue
	private long id;
	@Required
	private String countryCode;
	@ManyToOne
	private long countryNameTId;
	@Required
	private int countryCallingCode;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public long getCountryNameTId() {
		return countryNameTId;
	}
	public void setCountryNameTId(long countryNameTId) {
		this.countryNameTId = countryNameTId;
	}
	public int getCountryCallingCode() {
		return countryCallingCode;
	}
	public void setCountryCallingCode(int countryCallingCode) {
		this.countryCallingCode = countryCallingCode;
	}
	
	
	
	
	

}
