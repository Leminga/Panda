package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;


@Entity
public class EmergencyRelation extends Model{
	
	/** The serialization version identifier. */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Required
	@GeneratedValue
	private long id;
	@Required
	@Column(unique=true)
	private long emergencyRelationTid;
	
	//OneToOneRelation to Translation
	@OneToOne
	@JoinColumn(name = "emergencyRelationTid")
	private Translation translation;
	
	public Long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getEmergencyRelationTid() {
		return emergencyRelationTid;
	}
	public void setEmergencyRelationTid(long emergencyRelationTid) {
		this.emergencyRelationTid = emergencyRelationTid;
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
