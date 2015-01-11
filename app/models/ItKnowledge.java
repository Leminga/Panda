package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import models.volunteer.Volunteer;


@Entity
public class ItKnowledge extends Model {
	
	/** The serialization version identifier. */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Required
	@GeneratedValue
	private long id;
	
	//ManyToOne Relation to Volunteer
	@ManyToOne // owning side
	private Volunteer volunteer;
	
	//OneToOne Relation to Translation
	@OneToOne
	@JoinColumn(name = "itKnowledgeTid")
	private Translation translation;
	
	/*
	 * Konstruktor der Klasse 
	 */
	public ItKnowledge(long tid) {
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
