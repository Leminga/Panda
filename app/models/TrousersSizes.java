package models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import models.volunteer.Volunteer;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.libs.Json;

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
