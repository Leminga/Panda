package models;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import models.humans.Human;
import models.volunteer.Volunteer;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Interview extends Model {
	
	/** The serialization version identifier. */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Required
	private long Id;
	private Date interviewDate;
	@Required
	@Column(unique=true)
	private long volunteerId;
	@Required
	private long interviewerId;
//	@Required
	private String interviewComment;
	
	//OneToOne Relation to Volunteer
	@OneToOne
	@JoinColumn(name = "volunteerId")
	private Volunteer volunteer;
	
	/*//ManyToOne Relation to Human
	@ManyToOne // owning side
	private Human human;*/
	
	public Date getInterviewDate() {
		return interviewDate;
	}
	public void setInterviewDate(Date interviewDate) {
		this.interviewDate = interviewDate;
	}
	public long getVolunteerId() {
		return volunteerId;
	}
	public void setVolunteerId(long volunteerId) {
		this.volunteerId = volunteerId;
	}
	public long getInterviewerId() {
		return interviewerId;
	}
	public void setInterviewerId(long interviewerId) {
		this.interviewerId = interviewerId;
	}
	public String getInterviewComment() {
		return interviewComment;
	}
	public void setInterviewComment(String interviewComment) {
		this.interviewComment = interviewComment;
	}
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
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
