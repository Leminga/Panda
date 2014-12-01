package models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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

import play.data.validation.Constraints.Required;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

public class PreferredCommunicationLanguage {
	
	@Id
	@Required
	@GeneratedValue
	private long id;
	@ManyToOne
	private long preferredCommunicationLanguageTId;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getPreferredCommunicationLanguageTId() {
		return preferredCommunicationLanguageTId;
	}
	public void setPreferredCommunicationLanguageTId(
			long preferredCommunicationLanguageTId) {
		this.preferredCommunicationLanguageTId = preferredCommunicationLanguageTId;
	}
	
	

}
