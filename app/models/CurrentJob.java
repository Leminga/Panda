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
public class CurrentJob extends Model {
	
	/** The serialization version identifier. */
	private static final long serialVersionUID = 1L;
	@Id
	@Required
	@GeneratedValue
	private long currentJobid;
	
	/*
	 * OneToOne Beziehung, owning side Volunteer
	 */
	@Required
	@OneToOne(mappedBy = "currentJobid")
	protected Volunteer volunteer;
		
	/*
	 * OneToOneRelation to Translation
	 */
	@OneToOne
	@JoinColumn(name = "currentJobTid")
	private Translation translation;
	
	/*
	 * Konstruktor der Klasse
	 */
	public CurrentJob(long tid) {
	}
	/*
	 * Getter und Setter
	 */
	public long getCurrentJobid() {
		return currentJobid;
	}
	public void setCurrentJobid(long currentJobid) {
		this.currentJobid = currentJobid;
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
