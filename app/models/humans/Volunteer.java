package models.humans;

import play.db.ebean.Model.Finder;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

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
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.libs.Json;
import play.db.ebean.Model.Finder;

import java.util.Date;

@Entity
public class Volunteer extends Human {
	
	
	@Required
	private List <Phone>phones;
	@Required
	private List <Address>addresses;
	@Required
	private List <Contact>contacts;
	@Required
	private List <Identification>identifications;
	@Required
	private List <EmergencyContact>emergencyContacts;
	@Required
	private Sizes sizes;
	@Required
	private Educationlevel highestEducationlevel;
	@Required
	private PreferredCommunicationLanguage preferredCommunicationLanguage;
	@Required
	private List<Languages> languages;
	@Required
	private List<ItKnowledge> itKnowledges;
	private long idTextBoxes;
	private long idEventComment;
	@Required
	private EmailAddress emailAddress;
	@Required
	private List <ActualJob>actualJob;
	@Required
	private String socialSecurityNumber;
	@Required
	private List<Attachments>attachments;
	@Required
	private byte[] volunteerAgreement;
	@Required
	private List <Training>trainings;
	@Required
	private List <Interview>interviews;
	@Required
	private Role role;
	@Required
	private Sport sport;
	
	public Volunteer(String string, String string2) {
		
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
	
	
	
	
	

}
