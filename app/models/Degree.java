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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Degree {
	
	@Id
	@Required
	@GeneratedValue
	private Long id;
	@ManyToOne
	private long degreeTId;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getDegreeTId() {
		return degreeTId;
	}

	public void setDegreeTId(long degreeTId) {
		this.degreeTId = degreeTId;
	}

	
	
	
	

}
