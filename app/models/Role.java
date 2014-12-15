package models;

import play.db.ebean.Model.Finder;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.libs.Json;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Role extends Model{
	
	/** The serialization version identifier. */
	private static final long serialVersionUID = 1L;

	@Id
	@Required
	@GeneratedValue
	private long id;
	@ManyToOne
	private long roleTId;
	@Required
	private boolean visibleFor;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getRoleTId() {
		return roleTId;
	}
	public void setRoleTId(long roleTId) {
		this.roleTId = roleTId;
	}
	public boolean isVisibleFor() {
		return visibleFor;
	}
	public void setVisibleFor(boolean visibleFor) {
		this.visibleFor = visibleFor;
	}
	
	
}
