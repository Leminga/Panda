package models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import play.data.validation.Constraints.Required;

@Entity
public class Degree {
	
	@Id
	@Required
	@GeneratedValue
	@ManyToMany(cascade = CascadeType.ALL, mappedBy="degree")
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
