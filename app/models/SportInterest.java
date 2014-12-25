package models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class SportInterest extends Model{
	
	/** The serialization version identifier. */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Required
	@GeneratedValue
	private long id;
	@Required
	@Column(unique=true)
	private long sportInterestTid;
	
	//OneToOneRelation to Translation
	@OneToOne
	@JoinColumn(name = "sportInterestTid")
	private Translation translation;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
}
