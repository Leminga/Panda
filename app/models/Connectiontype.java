package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.libs.Json;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class Connectiontype {
	
	@Id
	@Required
	@GeneratedValue
	private Long id;
	@ManyToOne
	private String connectionTypeTId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getConnectionTypeTId() {
		return connectionTypeTId;
	}
	public void setConnectionTypeTId(String connectionTypeTId) {
		this.connectionTypeTId = connectionTypeTId;
	}
	
	
	
	
}
