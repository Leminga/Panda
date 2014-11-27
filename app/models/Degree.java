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
public class Degree {
	
	@Id
	@Required
	@GeneratedValue
	private Long ID;
	@Required
	private String degreeDE;
	@Required
	private String degreeEN;
	
	
	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public String getDegreeDE() {
		return degreeDE;
	}

	public void setDegreeDE(String degreeDE) {
		this.degreeDE = degreeDE;
	}

	public String getDegreeEN() {
		return degreeEN;
	}

	public void setDegreeEN(String degreeEN) {
		this.degreeEN = degreeEN;
	}
	
	
	

}