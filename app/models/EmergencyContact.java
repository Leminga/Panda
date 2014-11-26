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
public class EmergencyContact {
	
	@Required
	private String emergencySurname;
	@Required
	private String emergencyName;
	@Required
	private EmergencyRelation emergencyRelation;
	@Required
	private List <Contact>emergencyContacts;
	
	public String getEmergencySurname() {
		return emergencySurname;
	}
	public void setEmergencySurname(String emergencySurname) {
		this.emergencySurname = emergencySurname;
	}
	public String getEmergencyName() {
		return emergencyName;
	}
	public void setEmergencyName(String emergencyName) {
		this.emergencyName = emergencyName;
	}
	public EmergencyRelation getEmergencyRelation() {
		return emergencyRelation;
	}
	public void setEmergencyRelation(EmergencyRelation emergencyRelation) {
		this.emergencyRelation = emergencyRelation;
	}

	
}
