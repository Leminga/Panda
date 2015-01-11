package models;

import javax.persistence.*;

import models.volunteer.Volunteer;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class TrousersSizes extends Model {
	
	/** The serialization version identifier. */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Required
	@GeneratedValue
	private long trousersId;
	private String trousersSize;
	
	/*
	 * OneToOne Beziehung, owning side Volunteer
	 */
	@Required
	@OneToOne(mappedBy = "trousersId")
	protected Volunteer volunteer;

	
	/*
	 * Konstruktor der Klasse
	 */
	public TrousersSizes(String trousersSize) {
		this.setTrousersSize(trousersSize);
	}

	/*
	 * Getter und Setter
	 */
	public long getTrousersId() {
		return trousersId;
	}

	public void setTrousersId(long trousersId) {
		this.trousersId = trousersId;
	}
	
	public String getTrousersSize() {
		return trousersSize;
	}

	public void setTrousersSize(String trousersSize) {
		this.trousersSize = trousersSize;
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
