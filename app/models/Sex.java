package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

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
	@Required
	@Column(unique=true)
	private long sexTid;
	
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
	public long getSexTid() {
		return sexTid;
	}
	
	/**
	 * Setter for the id in the translation table.
	 * 
	 * @param sexTId The id in the tranlation table.
	 */
	public void setSexTid(long sexTid) {
		this.sexTid = sexTid;
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

	public void setId(long id) {
		this.id = id;
	}
	
}
