package models;

//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
//import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Degree extends Model {
	
	/** The serialization version identifier. */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Required
	@GeneratedValue
	//@ManyToMany(cascade = CascadeType.ALL, mappedBy="degree") // Not needed, as the relation is unidirectional.
	private Long id;
	@Required
	@Column(unique=true)
	private long degreeTid;
	
	//OneToOneRelation to Translation
	@OneToOne
	@JoinColumn(name = "degreeTid")
	private Translation translation;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getDegreeTid() {
		return degreeTid;
	}

	public void setDegreeTid(long degreeTid) {
		this.degreeTid = degreeTid;
	}

	public Translation getTranslation() {
		return translation;
	}

	public void setTranslation(Translation translation) {
		this.translation = translation;
	}
}
