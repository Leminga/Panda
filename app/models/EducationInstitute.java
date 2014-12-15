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

@Entity
public class EducationInstitute extends Model {
	
	/** The serialization version identifier. */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Required
	@GeneratedValue
	private long id;
	@ManyToOne
	private long educationInstituteTId;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getEducationInstituteTId() {
		return educationInstituteTId;
	}
	public void setEducationInstituteTId(long educationInstituteTId) {
		this.educationInstituteTId = educationInstituteTId;
	}
	
	

}
