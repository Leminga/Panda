package models;

import javax.persistence.MappedSuperclass;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.node.ObjectNode;

import play.db.ebean.Model;
import play.libs.Json;

@MappedSuperclass
public abstract class Entity extends Model {
	/** The serialization version identifier. */
	private static final long serialVersionUID = 1L;
	/** Logger to log SecurityController events. */
	private static Logger LOGGER = LoggerFactory.getLogger(Entity.class);
	
	@Override
	public String toString() {
		ObjectMapper mapper = new ObjectMapper();
		ObjectWriter writer = mapper.writer().withDefaultPrettyPrinter();
		try {
			return writer.writeValueAsString(this.toJson());
		} catch (JsonProcessingException e) {
			LOGGER.debug("Processing Json object failed.");
			return Integer.toHexString(System.identityHashCode(this));
		}
	}
	
	/**
	 * Get the class name of the current class
	 * in lower cases.
	 * 
	 * @return <b>String</b>The simple name of that class in lower cases.
	 */
	@JsonIgnore
	public String getClassName() {
		return this.getClass().getSimpleName().toLowerCase();
	}
	
	/**
	 * Converts the current gender object to e JSON node.
	 * 
	 * @return <b>JsonNode</b> A JSON node that contains this gender object.
	 */
	public JsonNode toJson() {
		ObjectNode result = Json.newObject();
		result.put(this.getClassName(), Json.toJson(this));
		return result;	
	}

}
