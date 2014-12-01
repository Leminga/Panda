package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import play.data.validation.Constraints.Required;

@Entity
public class Faculty {
	
	@Id
	@Required
	@GeneratedValue
	private long id;	
	@Required
	private String facultyDE;
	@Required
	private String facultyEN;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFacultyDE() {
		return facultyDE;
	}
	public void setFacultyDE(String facultyDE) {
		this.facultyDE = facultyDE;
	}
	public String getFacultyEN() {
		return facultyEN;
	}
	public void setFacultyEN(String facultyEN) {
		this.facultyEN = facultyEN;
	}
}
