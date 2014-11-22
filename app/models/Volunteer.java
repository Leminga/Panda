package models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

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
	private List <Phone>phone;
	@Required
	private List <Address>address;
	@Required
	private List <Contact>contact;

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
