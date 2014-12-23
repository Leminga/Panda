package models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;




import play.db.ebean.Model.Finder;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import models.volunteer.Volunteer;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.libs.Json;
import play.data.validation.Constraints.Required;

@Entity
public class ActualJob extends Model {
	
	/** The serialization version identifier. */
	private static final long serialVersionUID = 1L;
	@Id
	@Required
	@GeneratedValue
	private long id;
	
	@ManyToOne
	private long actualJobTid;
	
	@Required
	@Column(unique=true)
	private long Vid;
	
	@OneToOne
	@JoinColumn(name = "Vid")
	private Volunteer volunteer;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getActualJobTid() {
		return actualJobTid;
	}
	public void setActualJobTid(long actualJobTid) {
		this.actualJobTid = actualJobTid;
	}
	
	
}
