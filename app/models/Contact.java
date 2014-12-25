package models;

import javax.persistence.Entity;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import models.volunteer.Volunteer;


@Entity

public class Contact extends Model{
	
	/** The serialization version identifier. */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Required
	@GeneratedValue
	private long id;
	@Required
	@Column(unique=true)
	private long connectionTypeTid;
	
	//OneToOneRelation to Translation
	@OneToOne
	@JoinColumn(name = "connectionTypeTid")
	private Translation translation;
	
	//ManyToOne Relation to Volunteer
	@ManyToOne // owning side
	private Volunteer volunteer;

	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
	
}
