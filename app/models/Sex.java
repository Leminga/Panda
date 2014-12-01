package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import play.data.validation.Constraints.Required;

@Entity
public class Sex {
	
	@Id
	@Required
	@GeneratedValue
	private Long Id;
	private String sexDE;
	private String sexEN;
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getSexDE() {
		return sexDE;
	}
	public void setSexDE(String sexDE) {
		this.sexDE = sexDE;
	}
	public String getSexEN() {
		return sexEN;
	}
	public void setSexEN(String sexEN) {
		this.sexEN = sexEN;
	}
	
	

}
