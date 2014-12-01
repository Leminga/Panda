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
import javax.persistence.ManyToOne;

public class Language {

	@Id
	@Required
	@GeneratedValue
	private long id;
	@ManyToOne
	private long languageTId;
	@Required 
	private int[] levels;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getLanguageTId() {
		return languageTId;
	}
	public void setLanguageTId(long languageTId) {
		this.languageTId = languageTId;
	}
	public int[] getLevels() {
		return levels;
	}
	public void setLevels(int[] levels) {
		this.levels = levels;
	}
	
}
