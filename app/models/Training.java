package models;

import javax.persistence.Id;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Training extends Model{
	
	/** The serialization version identifier. */
	private static final long serialVersionUID = 1L;
	
	//ManyToMany Relation to Volunteer
	@Id
	@ManyToMany(cascade = CascadeType.ALL, mappedBy="training")
	private String trainingName;
//	@Required
	private Date trainingdate;
//	@Required
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
