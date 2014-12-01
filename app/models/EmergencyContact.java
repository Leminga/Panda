package models;

import java.util.List;

import javax.persistence.Entity;
import play.data.validation.Constraints.Required;

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
