package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class LanguagesTranslation extends Model{
	
	/** The serialization version identifier. */
	private static final long serialVersionUID = 1L;

	@Id
	@Required
	@GeneratedValue
	private long id;
	@ManyToOne
	private long languageTranslationTId;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getLanguageDe() {
		return languageTranslationTId;
	}
	public void setLanguageDe(long languageTranslationTId) {
		this.languageTranslationTId = languageTranslationTId;
	}
	
	
}
