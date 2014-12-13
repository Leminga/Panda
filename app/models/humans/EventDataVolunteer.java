package models.humans;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import models.Address;
import models.Availability;
import models.Contact;
import models.Educationlevel;
import models.EmailAddress;
import models.EmergencyContact;
import models.Event;
import models.Identification;
import models.Interview;
import models.ItKnowledge;
import models.Languages;
import models.Organization;
import models.Phone;
import models.PreferredCommunicationLanguage;
import models.Sizes;
import net.sf.ehcache.util.PreferTCCLObjectInputStream;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import play.libs.Json;


@Entity
public class EventDataVolunteer extends Human {

	
	@Required
	private String name;
	@Required
	private String password;
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
	private List <Event>events;
	@Required
	private List <Availability>availability;
	@Required
	private List <Organization>organizations;
	@Required
	private String socialSecurityNumber;
	@Required
	private List <Interview>interviews;
	

	public EventDataVolunteer(String _username, String _password) {
		//Volunteer v = Json.fromJson(Json.parse(j), Volunteer.class);
		this.name = _username;
		this.password = _password;
	}

	

	public String getUsername() {
		return name;
	}

	public void setUsername(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
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



	public List<Event> getEvents() {
		return events;
	}



	public void setEvents(List<Event> events) {
		this.events = events;
	}



	public List<Availability> getAvailability() {
		return availability;
	}



	public void setAvailability(List<Availability> availability) {
		this.availability = availability;
	}



	public List<Organization> getOrganizations() {
		return organizations;
	}



	public void setOrganizations(List<Organization> organizations) {
		this.organizations = organizations;
	}



	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}



	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}
	
	public List<Interview> getInterviews() {
		return interviews;
	}



	public void setInterviews(List<Interview> interviews) {
		this.interviews = interviews;
	}



	public static Finder<Long, EventDataVolunteer> getFind() {
		return find;
	}



	public static void setFind(Finder<Long, EventDataVolunteer> find) {
		EventDataVolunteer.find = find;
	}


	public static Finder<Long, EventDataVolunteer> find = new Finder<>(Long.class,
			EventDataVolunteer.class);
	
}
