package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Translation extends Model {
	
	/** The serialization version identifier. */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Required
	@GeneratedValue
	@OneToMany
	private long Tid;
	@Required
	private String german;
	@Required
	private String english;
	
	//OneToOne Relations (Translations)
	@OneToOne(mappedBy = "translation")
	private ActualJob actualJob;
	@OneToOne(mappedBy = "translation")
	private Arrival arrivalPlace;
	@OneToOne(mappedBy = "translation")
	private Contact contact;
	@OneToOne(mappedBy = "translation")
	private Departure departurePlace;
	@OneToOne(mappedBy = "translation")
	private Degree degree;
	@OneToOne(mappedBy = "translation")
	private EducationInstitute institute;
	@OneToOne(mappedBy = "translation")
	private Educationlevel educationslevel;
	@OneToOne(mappedBy = "translation")
	private EmergencyRelation emergencyRelation;
	@OneToOne(mappedBy = "translation")
	private Event eventdiscription;
	@OneToOne(mappedBy = "translation")
	private Faculty faculty;
	@OneToOne(mappedBy = "translation")
	private ItKnowledge itKnowledge;
	@OneToOne(mappedBy = "translation")
	private Language language;
	@OneToOne(mappedBy = "translation")
	private PreferredCommunicationLanguage preferredLanguage;
	@OneToOne(mappedBy = "translation")
	private PreferredWorkingArea preferredArea;
	@OneToOne(mappedBy = "translation")
	private Role role;
	@OneToOne(mappedBy = "translation")
	private Sex sex;
	@OneToOne(mappedBy = "translation")
	private Sport sport;
	@OneToOne(mappedBy = "translation")
	private SportInterest sportInterest;
	
	
	public long getTid() {
		return Tid;
	}
	public void setId(long Tid) {
		this.Tid = Tid;
	}
	public String getGerman() {
		return german;
	}
	public void setGerman(String german) {
		this.german = german;
	}
	public String getEnglish() {
		return english;
	}
	public void setEnglish(String english) {
		this.english = english;
	}
	
	

}
