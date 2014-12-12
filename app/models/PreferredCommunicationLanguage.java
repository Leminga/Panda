package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import play.data.validation.Constraints.Required;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
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
