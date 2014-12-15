package models.humans;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OptimisticLockException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.avaje.ebean.Ebean;

import models.ActualJob;
import models.Address;
import models.Attachments;
import models.Contact;
import models.Educationlevel;
import models.EmailAddress;
import models.EmergencyContact;
import models.Identification;
import models.Interview;
import models.ItKnowledge;
import models.Languages;
import models.Phone;
import models.PreferredCommunicationLanguage;
import models.Role;
import models.Sizes;
import models.Sport;
import models.Training;
import models.UserLogin;
import play.data.validation.Constraints.Required;

@Entity
public class Volunteer extends Human {
	/** The serialization version identifier. */
	private static final long serialVersionUID = 1L;
	/** Logger to log SecurityController events. */
	protected static Logger LOGGER = LoggerFactory.getLogger(Volunteer.class);
	
//	@Required
	private List <Phone>phones;
//	@Required
	private List <Address>addresses;
//	@Required
	private List <Contact>contacts;
//	@Required
	private List <Identification>identifications;
//	@Required
	private List <EmergencyContact>emergencyContacts;
//	@Required
	private Sizes sizes;
//	@Required
	private Educationlevel highestEducationlevel;
//	@Required
	private PreferredCommunicationLanguage preferredCommunicationLanguage;
//	@Required
	private List<Languages> languages;
//	@Required
	private List<ItKnowledge> itKnowledges;
	private long idTextBoxes;
	private long idEventComment;
//	@Required
	private EmailAddress emailAddress;
//	@Required
	private List <ActualJob>actualJob;
//	@Required
	private String socialSecurityNumber;
//	@Required
	private List<Attachments>attachments;
//	@Required
	private byte[] volunteerAgreement;
//	@Required
	private List <Training>trainings;
//	@Required
	private List <Interview>interviews;
//	@Required
	private Role role;
//	@Required
	private Sport sport;
	/** Login data, if the user is allows to login. */
	@Required
	protected UserLogin loginData;
	
	/**
	 * Default constructor;
	 * 
	 * @param prename
	 * @param surname
	 */
	public Volunteer(String prename, String surname) {
		this.setName(prename);
		this.setSurname(surname);
	}
	
	public List<Phone> getPhones() {
		return phones;
	}
	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}
	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	public List<Contact> getContacts() {
		return contacts;
	}
	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
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
	public List<Languages> getLanguages() {
		return languages;
	}
	public void setLanguages(List<Languages> languages) {
		this.languages = languages;
	}
	public List<ItKnowledge> getItKnowledges() {
		return itKnowledges;
	}
	public void setItKnowledges(List<ItKnowledge> itKnowledges) {
		this.itKnowledges = itKnowledges;
	}
	public long getIdTextBoxes() {
		return idTextBoxes;
	}
	public void setIdTextBoxes(long idTextBoxes) {
		this.idTextBoxes = idTextBoxes;
	}
	public long getIdEventComment() {
		return idEventComment;
	}
	public void setIdEventComment(long idEventComment) {
		this.idEventComment = idEventComment;
	}
	public EmailAddress getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(EmailAddress emailAddress) {
		this.emailAddress = emailAddress;
	}
	public List<ActualJob> getActualJob() {
		return actualJob;
	}
	public void setActualJob(List<ActualJob> actualJob) {
		this.actualJob = actualJob;
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
	 * Saves the current volunteer object to the database.
	 */
	@Override
	public void save() throws OptimisticLockException {
		try {
			Ebean.save(this);
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Volunteer "+ this.getName() + " " + this.getSurname() + " stored/updated in database.");
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
	
	

}
