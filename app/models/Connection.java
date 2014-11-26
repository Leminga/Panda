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

@Entity
public class Connection {
	
	@Id
	@Required
	@GeneratedValue
	private Long ID;
	private String connectionTypeDE;
	private String connectionTypeEN;
	
	public Long getID() {
		return ID;
	}
	public void setID(Long iD) {
		ID = iD;
	}
	public String getConnectionTypeDE() {
		return connectionTypeDE;
	}
	public void setConnectionTypeDE(String connectionTypeDE) {
		this.connectionTypeDE = connectionTypeDE;
	}
	public String getConnectionTypeEN() {
		return connectionTypeEN;
	}
	public void setConnectionTypeEN(String connectionTypeEN) {
		this.connectionTypeEN = connectionTypeEN;
	}
	
	
	
}
