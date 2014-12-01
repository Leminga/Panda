package models;

import play.db.ebean.Model.Finder;
import helper.ConnectionType;

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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Contact{
	
	@Id
	@Required
	@GeneratedValue
	private long id;
	@Required
	private ConnectionType connectionType;
	@ManyToOne
	private long connectionTypeTId;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public ConnectionType getConnectionType() {
		return connectionType;
	}
	public void setConnectionType(ConnectionType connectionType) {
		this.connectionType = connectionType;
	}
	public long getConnectionTypeTId() {
		return connectionTypeTId;
	}
	public void setConnectionTypeTId(long connectionTypeTId) {
		this.connectionTypeTId = connectionTypeTId;
	}
	
	
	
}
