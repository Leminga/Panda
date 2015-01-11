package models;

import javax.persistence.*;

import models.volunteer.Volunteer;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class ShoeSizes extends Model {
	
	/** The serialization version identifier. */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Required
	@GeneratedValue
	private long shoeId;
	private int shoeSize;
	
	/*
	 * OneToOne Beziehung, owning side Volunteer
	 */
	@Required
	@OneToOne(mappedBy = "shoeId")
	protected Volunteer volunteer;

	/*
	 *  Konstruktor der Klasse
	 */
	public ShoeSizes(int shoeSize) {
		this.setShoeSize(shoeSize);
	}

	/*
	 * Getter und Setter
	 */
	public long getShoeId() {
		return shoeId;
	}

	public void setShoeId(long shoeId) {
		this.shoeId = shoeId;
	}
	
	public int getShoeSize() {
		return shoeSize;
	}

	public void setShoeSize(int shoeSize) {
		this.shoeSize = shoeSize;
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
