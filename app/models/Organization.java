package models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
import play.data.validation.Constraints.Required;

import java.util.Date;

@Entity
public class Organization extends Model{
	
	/** The serialization version identifier. */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Required
	@GeneratedValue
	private long id;
	@Required
	private String organizationType;
	@Required
	private String organizationName;
	@Required 
	private int organizationSize;
	@Required
	private boolean visibleFor;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getOrganizationType() {
		return organizationType;
	}
	public void setOrganizationType(String organizationType) {
		this.organizationType = organizationType;
	}
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	public int getOrganizationSize() {
		return organizationSize;
	}
	public void setOrganizationSize(int organizationSize) {
		this.organizationSize = organizationSize;
	}
	public boolean isVisibleFor() {
		return visibleFor;
	}
	public void setVisibleFor(boolean visibleFor) {
		this.visibleFor = visibleFor;
	}
	
	
}
