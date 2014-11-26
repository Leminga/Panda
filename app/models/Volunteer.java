package models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import net.sf.ehcache.util.PreferTCCLObjectInputStream;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import play.libs.Json;


@Entity
public class Volunteer extends Human {

	@Required
	@Id
	@GeneratedValue
	private long id;
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
	private List <EmergencyContact>emergencyContact;
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
	

	public Volunteer(String _username, String _password) {
		//Volunteer v = Json.fromJson(Json.parse(j), Volunteer.class);
		this.name = _username;
		this.password = _password;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public static Finder<Long, Volunteer> find = new Finder<>(Long.class,
			Volunteer.class);
}
