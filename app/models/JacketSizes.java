package models;

import javax.persistence.*;

import models.volunteer.Volunteer;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class JacketSizes extends Model{
	
	/** The serialization version identifier. */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Required
	@GeneratedValue
	private long jacketId;
	private String jacketSize;
	
	/*
	 * OneToOne Beziehung, owning side Volunteer
	 */
	@Required
	@OneToOne(mappedBy = "jacketId")
	protected Volunteer volunteer;
	
	/*
	 * Konstruktor der Klasse
	 */
	public JacketSizes(String jacketSize) {
		
		this.setJacketSize(jacketSize);
	}

	/*
	 * Getter und Setter
	 */
	public long getJacketId() {
		return jacketId;
	}

	public void setJacketId(long jacketId) {
		this.jacketId = jacketId;
	}
	
	public String getJacketSize() {
		return jacketSize;
	}

	public void setJacketSize(String jacketSize) {
		this.jacketSize = jacketSize;
	}

	public Volunteer getVolunteer() {
		return volunteer;
	}

	public void setVolunteer(Volunteer volunteer) {
		this.volunteer = volunteer;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
