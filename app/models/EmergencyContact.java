package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import models.volunteer.Volunteer;
import play.db.ebean.Model;

/*
 * Notfallkontaktdaten des Volunteers
 */
@Entity
public class EmergencyContact extends Model{
	
	/** The serialization version identifier. */
	private static final long serialVersionUID = 1L;
	
	private String emergencySurname;
	private String emergencyName;
	private EmergencyRelation emergencyRelation;
	private List <Contact>emergencyContacts;
	
	//ManyToOne Relation to Volunteer
	@ManyToOne // owning side
	private Volunteer volunteer;
	
	/*
	 * Getter und Setter
	 */
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
	public List<Contact> getEmergencyContacts() {
		return emergencyContacts;
	}
	public void setEmergencyContacts(List<Contact> emergencyContacts) {
		this.emergencyContacts = emergencyContacts;
	}
	public Volunteer getVolunteer() {
		return volunteer;
	}
	public void setVolunteer(Volunteer volunteer) {
		this.volunteer = volunteer;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
