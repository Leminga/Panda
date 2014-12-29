package models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class PreferredWorkingArea extends Model {
	
	/** The serialization version identifier. */
	private static final long serialVersionUID = 1L;

	@Id
	@Required
	@GeneratedValue
	private long id;
	@Required
	@Column(unique=true)
	private long preferredAreaTid;
	
	//OneToOneRelation to Translation
	@OneToOne
	@JoinColumn(name = "preferredAreaTid")
	private Translation translation;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getPreferredAreaTid() {
		return preferredAreaTid;
	}
	public void setPreferredAreaTid(long preferredAreaTid) {
		this.preferredAreaTid = preferredAreaTid;
	}
	public Translation getTranslation() {
		return translation;
	}
	public void setTranslation(Translation translation) {
		this.translation = translation;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
