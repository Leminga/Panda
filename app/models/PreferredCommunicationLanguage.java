package models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
