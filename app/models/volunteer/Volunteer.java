package models.volunteer;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OptimisticLockException;
import javax.persistence.PrimaryKeyJoinColumn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.avaje.ebean.Ebean;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.node.ObjectNode;

import models.ActualJob;
import models.Address;
import models.Attachments;
import models.Contact;
import models.Educationlevel;
import models.EmailAddress;
import models.EmergencyContact;
import models.Event;
import models.Identification;
import models.Interview;
import models.ItKnowledge;
import models.Language;
import models.LanguagesTranslation;
import models.Phone;
import models.PreferredCommunicationLanguage;
import models.Role;
import models.Sizes;
import models.Sport;
import models.TextBoxes;
import models.Training;
import models.UserLogin;
import models.humans.Human;
import play.data.validation.Constraints.Required;
import play.libs.Json;

@Entity
public class Volunteer extends Human {
	/** The serialization version identifier. */
	private static final long serialVersionUID = 1L;
	/** Logger to log SecurityController events. */
	private static Logger LOGGER = LoggerFactory.getLogger(Volunteer.class);
	
	@Id
	@Required
	private long id;
	@OneToMany(cascade = CascadeType.ALL)
	private List <Contact>contacts;
	@OneToMany(cascade = CascadeType.ALL)
	private List <Identification>identifications;
	@OneToMany(cascade = CascadeType.ALL)
	private List <EmergencyContact>emergencyContacts;
	
	@OneToOne(mappedBy = "volunteer")
	private Sizes sizes;
	
	@Required
	private EmailAddress emailAddress;
	
	private Educationlevel highestEducationlevel;

	private PreferredCommunicationLanguage preferredCommunicationLanguage;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Language> languages;

	@OneToMany(cascade = CascadeType.ALL)
	private List<ItKnowledge> itKnowledges;
	
	@OneToOne(mappedBy = "volunteer")
	private TextBoxes textBoxes;
	
	@OneToOne(mappedBy = "volunteer")
	private ActualJob actualJob;
	
	private String socialSecurityNumber;

	private List<Attachments>attachments;
//	@Required
	private byte[] volunteerAgreement;

	
//	@Required
	private List <Training>trainings;
//	@Required
	private List <Interview>interviews;
//	@Required
	private Role role;
	//TODO: Relevanz checken für sport
	//	@Required
	private Sport sport;
	/** Login data, if the user is allows to login. */
	@Required
	protected UserLogin loginData;
//	@Required
	private List <Event>events;
	
	/**
	 * Default constructor;
	 * 
	 * @param prename
	 * @param surname
	 */
	public Volunteer(String prename, String surname, String emailAddress) {
		this.setPrename(prename);
		this.setSurname(surname);
		EmailAddress address = new EmailAddress(emailAddress);
		this.setEmailAddress(address);
	}
	public static Logger getLOGGER() {
		return LOGGER;
	}

	public static void setLOGGER(Logger lOGGER) {
		LOGGER = lOGGER;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public UserLogin getLoginData() {
		return loginData;
	}

	public void setLoginData(UserLogin loginData) {
		this.loginData = loginData;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Contact> getContacts() {
		return contacts;
	}
	public void setContacts(Contact contact) {
		this.contacts.add(contact);
	}
	public EmailAddress getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(EmailAddress emailAddress) {
		this.emailAddress = emailAddress;
	}

	
//TODO: relevanz checken
//	public void removeContacts(Contact contact) {
//		if(this.contacts.contains(contact))
//		{
//			this.contacts.remove(contact);
//		}
//	}
	
	public List<Identification> getIdentifications() {
		return identifications;
	}
	public void setIdentifications(List<Identification> identifications) {
		this.identifications = identifications;
	}
	public List<EmergencyContact> getEmergencyContacts() {
		return emergencyContacts;
	}
	public void setEmergencyContacts(List<EmergencyContact> emergencyContacts) {
		this.emergencyContacts = emergencyContacts;
	}
	public Sizes getSizes() {
		return sizes;
	}
	public void setSizes(Sizes sizes) {
		this.sizes = sizes;
	}
	public Educationlevel getHighestEducationlevel() {
		return highestEducationlevel;
	}
	public void setHighestEducationlevel(Educationlevel highestEducationlevel) {
		this.highestEducationlevel = highestEducationlevel;
	}
	public PreferredCommunicationLanguage getPreferredCommunicationLanguage() {
		return preferredCommunicationLanguage;
	}
	public void setPreferredCommunicationLanguage(
			PreferredCommunicationLanguage preferredCommunicationLanguage) {
		this.preferredCommunicationLanguage = preferredCommunicationLanguage;
	}
	public List<Language> getLanguages() {
		return languages;
	}
	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}
	public List<ItKnowledge> getItKnowledges() {
		return itKnowledges;
	}
	public void setItKnowledges(List<ItKnowledge> itKnowledges) {
		this.itKnowledges = itKnowledges;
	}
	
	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}
	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}
	public List<Attachments> getAttachments() {
		return attachments;
	}
	public void setAttachments(List<Attachments> attachments) {
		this.attachments = attachments;
	}
	public byte[] getVolunteerAgreement() {
		return volunteerAgreement;
	}
	public void setVolunteerAgreement(byte[] volunteerAgreement) {
		this.volunteerAgreement = volunteerAgreement;
	}
	public List<Training> getTrainings() {
		return trainings;
	}
	public void setTrainings(List<Training> trainings) {
		this.trainings = trainings;
	}
	public List<Interview> getInterviews() {
		return interviews;
	}
	public void setInterviews(List<Interview> interviews) {
		this.interviews = interviews;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Sport getSport() {
		return sport;
	}
	public void setSport(Sport sport) {
		this.sport = sport;
	}
	
	public UserLogin getUserLogin() {
		return this.loginData;
	}
	
	public void setUserLogin(UserLogin loginData) {
		this.loginData = loginData;
	}
	
	/**
	 * Returns the simple name of the class.
	 * 
	 * @return <b>String</b> The simple name of the current class.
	 */
	@JsonIgnore
	public String getClassName() {
		return this.getClass().getSimpleName().toLowerCase();
	}
	
	/**
	 * Converts the current volunteer object to e JSON node.
	 * 
	 * @return <b>JsonNode</b> A JSON node that contains this volunteer object.
	 */
	public JsonNode toJson() {
		ObjectNode result = Json.newObject();
		result.put(this.getClassName(), Json.toJson(this));
		return result;	
	}
	
	/**
	 * Saves the current volunteer object to the database.
	 */
	@Override
	public void save() throws OptimisticLockException {
		try {
			Ebean.save(this);
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Volunteer "+ this.getPrename() + " " + this.getSurname() + " stored/updated in database.");
			}
		} catch (OptimisticLockException e) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.error("Unable to write to the database.");
			}
			throw new OptimisticLockException();
		} catch (Exception e) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.error("Unable to write to the database. \n" + e.getMessage());
			}
		}
	}
	
	@Override
	public String toString() {
		ObjectMapper mapper = new ObjectMapper();
		ObjectWriter writer = mapper.writer().withDefaultPrettyPrinter();
		try {
			return writer.writeValueAsString(this.toJson());
		} catch (JsonProcessingException e) {
			LOGGER.debug("Processing Json object failed.");
			return getPrename() + " " + this.getSurname();
		}
	}

}
