package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.libs.Json;

import javax.persistence.ManyToOne;


@Entity
public class ItKnowledge extends Model {
	
	/** The serialization version identifier. */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Required
	@GeneratedValue
	private long id;
	@ManyToOne
	private long itKnowledgeTId;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getItKnowledgeTId() {
		return itKnowledgeTId;
	}
	public void setItKnowledgeTId(long itKnowledgeTId) {
		this.itKnowledgeTId = itKnowledgeTId;
	}
	
	
	
}
