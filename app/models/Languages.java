package models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import play.data.validation.Constraints.Required;

public class Languages {

	@Id
	@Required
	@GeneratedValue
	private long id;
	@Id
	private String languageDe;
	@Id
	private String languageEn;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLanguageDe() {
		return languageDe;
	}
	public void setLanguageDe(String languageDe) {
		this.languageDe = languageDe;
	}
	public String getLanguageEn() {
		return languageEn;
	}
	public void setLanguageEn(String languageEn) {
		this.languageEn = languageEn;
	}
	
}
