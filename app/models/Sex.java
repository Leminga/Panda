package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

import javax.persistence.ManyToOne;

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
	@ManyToOne
	private long sexTId;
	
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
	public long getSexTId() {
		return sexTId;
	}
	
	/**
	 * Setter for the id in the translation table.
	 * 
	 * @param sexTId The id in the tranlation table.
	 */
	public void setSexTId(long sexTId) {
		this.sexTId = sexTId;
	}
}
