package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import models.humans.Human;
import models.volunteer.Volunteer;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.libs.Json;

/**
 * Specifies possible gender attributes.
 * 
 * @author Michael Bredel <michael.bredel@fh-kufstein.ac.at>
 */
@Entity
public class Sex extends Model{
	/** The database id. */
	
	/** The serialization version identifier. */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Required
	@GeneratedValue
	private long id;
	/** The id in the translation table. */
	//@Required
	//@Column(unique=true)
	//private long sexTid;
	
	/** The gender. */
	@Required
	@OneToOne(mappedBy = "sex")
	protected Volunteer volunteer;
	
	//OneToOneRelation to Translation
	@OneToOne
	@JoinColumn(name = "sexTid")
	private Translation translation;
	
	/**
	 * Getter for the database id.
	 * 
	 * @return <b>long</b> The database id.
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * Getter for the id in the translation table.
	 * 
	 * @return <b>long</b> The id in the translation table.
	 */
	//public long getSexTid() {
	//	return sexTid;
	//}
	
	/**
	 * Setter for the id in the translation table.
	 * 
	 * @param sexTId The id in the tranlation table.
	 */
	//public void setSexTid(long sexTid) {
		//this.sexTid = sexTid;
	//}

	public Translation getTranslation() {
		return translation;
	}

	public void setTranslation(Translation translation) {
		this.translation = translation;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setId(long id) {
		this.id = id;
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
