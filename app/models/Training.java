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
import java.util.Date;

@Entity
public class Training extends Model{
	
	/** The serialization version identifier. */
	private static final long serialVersionUID = 1L;
	
	@Required
	private String trainingName;
	@Required
	private Date trainingdate;
	@Required
	private String trainingquota;
	public String getTrainingName() {
		return trainingName;
	}
	public void setTrainingName(String trainingName) {
		this.trainingName = trainingName;
	}
	public Date getTrainingdate() {
		return trainingdate;
	}
	public void setTrainingdate(Date trainingdate) {
		this.trainingdate = trainingdate;
	}
	public String getTrainingquota() {
		return trainingquota;
	}
	public void setTrainingquota(String trainingquota) {
		this.trainingquota = trainingquota;
	}
	
	

}
