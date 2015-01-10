package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
//import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import models.volunteer.Volunteer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.node.ObjectNode;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.libs.Json;

@Entity
public class Translation extends Model {
	
	/** The serialization version identifier. */
	private static final long serialVersionUID = 1L;
	/** Logger to log SecurityController events. */
	private static Logger LOGGER = LoggerFactory.getLogger(Translation.class);
	
	@Id
	@Required
	@GeneratedValue
	//@OneToMany // Not needed, as the relation is unidirectional.
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

	private Translation sex1;
	
	
	public long getTid() {
		return Tid;
	}
	public void setTid(long Tid) {
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
	
	public Translation(String german, String english) {
		this.setGerman(german);
		this.setEnglish(english);
	}
	public void setTranslation(Translation sex1) {
		this.sex1 = sex1;
		
	}

}
