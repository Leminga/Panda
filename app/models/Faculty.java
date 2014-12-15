package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.libs.Json;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class Faculty extends Model{
	
	/** The serialization version identifier. */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Required
	@GeneratedValue
	private long id;	
	@ManyToOne
	private long facultyTId;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getFacultyTId() {
		return facultyTId;
	}
	public void setFacultyTId(long facultyTId) {
		this.facultyTId = facultyTId;
	}
	
}
