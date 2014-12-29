package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import models.volunteer.Volunteer;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class TextBoxes extends Model {
	
	/** The serialization version identifier. */
	private static final long serialVersionUID = 1L;
	
	@Required
	@Id
	@GeneratedValue
	private long id;
	private String career;
	private String otherQualification;
	
	@Required
	@Column(unique=true)
	private long Vid;
	
	//OneToOne Relation to Volunteer
	@OneToOne
	@JoinColumn(name = "Vid")
	private Volunteer volunteer;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCareer() {
		return career;
	}
	public void setCareer(String career) {
		this.career = career;
	}
	public String getOtherQualification() {
		return otherQualification;
	}
	public void setOtherQualification(String otherQualification) {
		this.otherQualification = otherQualification;
	}
	public long getVid() {
		return Vid;
	}
	public void setVid(long vid) {
		Vid = vid;
	}
	public Volunteer getVolunteer() {
		return volunteer;
	}
	public void setVolunteer(Volunteer volunteer) {
		this.volunteer = volunteer;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
		
}
