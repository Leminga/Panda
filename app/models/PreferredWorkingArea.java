package models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import models.volunteer.Volunteer;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.libs.Json;

@Entity
public class PreferredWorkingArea extends Model {
	
	/** The serialization version identifier. */
	private static final long serialVersionUID = 1L;

	@Id
	@Required
	@GeneratedValue
	private long id;
	
	//OneToOneRelation to Translation
	@OneToOne
	@JoinColumn(name = "preferredAreaTid")
	private Translation translation;
	
	/** OnetoOne Relation, Volunteer owning side */
	@Required
	@OneToOne(mappedBy = "preferredWorkingAreaId")
	protected Volunteer volunteer;
	
	/*
	 * 
	 * Konstruktor der Klasse 
	 */
	public PreferredWorkingArea(long tid) {
	}
	
	/*
	 * Getter und Setter
	 */
	
	public Volunteer getVolunteer() {
		return volunteer;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
	@JsonIgnore
	public String getClassName() {
		return this.getClass().getSimpleName().toLowerCase();
	}
	
	/**
	 * Converts the current volunteer object to e JSON node.
	 * 
	 * @return <b>JsonNode</b> A JSON node that contains this volunteer object.
	 */
	public JsonNode toJson() {
		ObjectNode result = Json.newObject();
		result.put(this.getClassName(), Json.toJson(this));
		return result;	
	}
}
