package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

import models.volunteer.Volunteer;

@Entity
public class Role extends Model{
	
	/** The serialization version identifier. */
	private static final long serialVersionUID = 1L;

	@Id
	@Required
	@GeneratedValue
	private long id;
	@Required
	@Column(unique=true)
	private long roleTid;
	
	//OneToOneRelation to Translation
	@OneToOne
	@JoinColumn(name = "roleTid")
	private Translation translation;
	
	@Required
	private boolean visibleFor;
	@Required
	@Column(unique=true)
	private long Vid;
	
	//OneToOne Relation to Volunteer
	@OneToOne
	@JoinColumn(name = "Vid")
	private Volunteer volunteer;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public boolean isVisibleFor() {
		return visibleFor;
	}
	public void setVisibleFor(boolean visibleFor) {
		this.visibleFor = visibleFor;
	}
	
	
}
