package models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.libs.Json;

import play.data.validation.Constraints.Required;

public class Language {

	@Id
	@Required
	@GeneratedValue
	private long id;
	@Required
	private long languageId;
	@Required 
	private int[] levels;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getLanguageId() {
		return languageId;
	}
	public void setLanguageId(long languageId) {
		this.languageId = languageId;
	}
	public int[] getLevels() {
		return levels;
	}
	public void setLevels(int[] levels) {
		this.levels = levels;
	}
	
}
