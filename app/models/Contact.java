package models;


import play.db.ebean.Model.Finder;
import helper.ConnectionType;

import javax.persistence.Entity;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.libs.Json;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import models.volunteer.Volunteer;


@Entity

public class Contact extends Model{
	
	/** The serialization version identifier. */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Required
	@GeneratedValue
	private long id;
	@ManyToOne
	private long connectionTypeTId;
	@ManyToOne // owning side
	private Volunteer volunteer;

	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public long getConnectionTypeTId() {
		return connectionTypeTId;
	}
	public void setConnectionTypeTId(long connectionTypeTId) {
		this.connectionTypeTId = connectionTypeTId;
	}
	
	
	
}
