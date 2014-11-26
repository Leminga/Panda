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

public class PreferredCommunicationLanguage {
	
	@Id
	@Required
	@GeneratedValue
	private long id;
	@Required
	private String preferredCommunicationLanguageDE;
	@Required
	private String PreferredCommunicationLanguageEN;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPreverredCommunicationLanguageDE() {
		return preferredCommunicationLanguageDE;
	}
	public void setPreferredCommunicationLanguageDE(
			String preferredCommunicationLanguageDE) {
		this.preferredCommunicationLanguageDE = preferredCommunicationLanguageDE;
	}
	public String getPreferredCommunicationLanguageEN() {
		return PreferredCommunicationLanguageEN;
	}
	public void setPreferredCommunicationLanguageEN(
			String preverredCommunicationLanguageEN) {
		PreferredCommunicationLanguageEN = preverredCommunicationLanguageEN;
	}
	

}
