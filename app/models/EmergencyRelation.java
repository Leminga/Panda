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
