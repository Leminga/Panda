package models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Degree extends Model {
	
	/** The serialization version identifier. */
	private static final long serialVersionUID = 1L;
	
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
