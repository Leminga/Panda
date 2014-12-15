package models;

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
public class Interview extends Model {
	
	/** The serialization version identifier. */
	private static final long serialVersionUID = 1L;

	@Required
	private Date interviewDate;
	@Required
	private long volunteerId;
	@Required
	private long interviewerId;
	@Required
	private String interviewComment;
	
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
	
	
	
	
}
