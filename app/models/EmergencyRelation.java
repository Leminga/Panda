package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import play.data.validation.Constraints.Required;

@Entity
public class EmergencyRelation {
	
	@Id
	@Required
	@GeneratedValue
	private Long ID;
	@Required
	private String emergencyRelationDE;
	@Required
	private String emergencyRelationEN;
	public Long getID() {
		return ID;
	}
	public void setID(Long iD) {
		ID = iD;
	}
	public String getEmergencyRelationDE() {
		return emergencyRelationDE;
	}
	public void setEmergencyRelationDE(String emergencyRelationDE) {
		this.emergencyRelationDE = emergencyRelationDE;
	}
	public String getEmergencyRelationEN() {
		return emergencyRelationEN;
	}
	public void setEmergencyRelationEN(String emergencyRelationEN) {
		this.emergencyRelationEN = emergencyRelationEN;
	}
	
	

}
