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
import javax.persistence.ManyToOne;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.libs.Json;

import play.data.validation.Constraints.Required;

@Entity
public class ActualJob {
	
	@Id
	@Required
	@GeneratedValue
	private long id;
	@ManyToOne
	private long actualJobTid;
	
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
