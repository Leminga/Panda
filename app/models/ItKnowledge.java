package models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import play.data.validation.Constraints.Required;

public class ItKnowledge {
	
	@Id
	@Required
	@GeneratedValue
	private long id;
	@Required
	private String itKnowledgeDE;
	@Required
	private String itKnowledgeEN;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getItKnowledgeDE() {
		return itKnowledgeDE;
	}
	public void setItKnowledgeDE(String itKnowledgeDE) {
		this.itKnowledgeDE = itKnowledgeDE;
	}
	public String getItKnowledgeEN() {
		return itKnowledgeEN;
	}
	public void setItKnowledgeEN(String itKnowledgeEN) {
		this.itKnowledgeEN = itKnowledgeEN;
	}
	
}
