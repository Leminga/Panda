package models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import models.volunteer.Volunteer;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class ActualJob extends Model {
	
	/** The serialization version identifier. */
	private static final long serialVersionUID = 1L;
	@Id
	@Required
	@GeneratedValue
	private long id;
	@Required
	@Column(unique=true)
	private long actualJobTid;
	@Required
	@Column(unique=true)
	private long Vid;
	
	//OneToOne Relation to Volunteer
	@OneToOne
	@JoinColumn(name = "Vid")
	private Volunteer volunteer;
		
	//OneToOneRelation to Translation
	@OneToOne
	@JoinColumn(name = "actualJobTid")
	private Translation translation;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getActualJobTid() {
		return actualJobTid;
	}
	public void setActualJobTid(long actualJobTid) {
		this.actualJobTid = actualJobTid;
	}
	public long getVid() {
		return Vid;
	}
	public void setVid(long vid) {
		Vid = vid;
	}
	public Volunteer getVolunteer() {
		return volunteer;
	}
	public void setVolunteer(Volunteer volunteer) {
		this.volunteer = volunteer;
	}
	public Translation getTranslation() {
		return translation;
	}
	public void setTranslation(Translation translation) {
		this.translation = translation;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
