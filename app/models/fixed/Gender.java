package models.fixed;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.OptimisticLockException;
import javax.persistence.Transient;

import models.Translation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.avaje.ebean.Ebean;

import play.data.validation.Constraints.Required;

@Entity
public class Gender extends models.Entity {
	/** The serialization version identifier. */
	@Transient
	private static final long serialVersionUID = 1L;
	/** A finder to query the database. */
	private static Finder<Long, Gender> FIND = new Finder<Long, Gender>(Long.class, Gender.class);
	/** Logger to log SecurityController events. */
	private static Logger LOGGER = LoggerFactory.getLogger(Gender.class);
	
	/** The database id. */
	@Id
	@Required
	@GeneratedValue
	private long id;
	/** The label string. */
	private String label;
	/** The translation. */
	@OneToOne // Owning side.
	private Translation translation;
	
	/**
	 * Generate the default genders to
	 * populate the database initially.
	 */
	public static void generateDefault() {
		Translation trans_male = new Translation("maennlich", "male");
		Translation trans_female = new Translation("weiblich", "female");
		trans_male.save();
		trans_female.save();
		
		Gender male = new Gender("male");
		male.setTranslation(trans_male);
		Gender female = new Gender("female");
		female.setTranslation(trans_female);
		
		male.save();
		female.save();
	}
	
	/**
	 * Query the database for all label objects.
	 * 
	 * @return <b>List of Gender</b>All label objects stored in the database.
	 */
	public static List<Gender> findGenders() {
		try  {
			List<Gender> genders = FIND.all();
			if (LOGGER.isDebugEnabled() && (genders == null || genders.isEmpty())) {
		    	LOGGER.debug("No gender was found in the database.");
	    	}
	        return genders;
		} catch (Exception e) {
	    	LOGGER.error("Unable to query the database for genders." + e.getMessage());
	        return null;
	    }
	}
	
	/**
	 * Finds a label object by its name.
	 * 
	 * @param genderName The label name, ie. "male" or "female".
	 * @return <b>Gender</b> The label object.
	 */
	public static Gender findGenderByName(String genderName) {
		try  {
			Gender gender = FIND.where().eq("gender", genderName.toLowerCase()).findUnique();
			if (LOGGER.isDebugEnabled() && gender == null) {
		    	LOGGER.debug("No gender was found in the database.");
	    	}
	        return gender;
		} catch (Exception e) {
			e.printStackTrace();
	    	LOGGER.error("Unable to query the database for gender with name " + genderName.toLowerCase() + "\n" + e.getMessage());
	        return null;
	    }
	}
	
	/**
	 * Default constructor.
	 * 
	 * @param gender The label.
	 */
	public Gender(String gender) {
		this.label = gender.toLowerCase();
	}
	
	/**
	 * Getter for the database id.
	 * 
	 * @return <b>long</b> The database id of the label.
	 */
	public long getId() {
		return this.id;
	}
	
	/**
	 * Getter for the Gender.
	 * 
	 * @return <b>Gender</b> The label.
	 */
	public String getLabel() {
		return this.label;
	}
	
	/**
	 * Getter for the Translation.
	 * 
	 * @return <b>Translation</b> The translataion.
	 */
	public Translation getTranslation() {
		return this.translation;
	}
	
	/**
	 * Setter for the Translation.
	 * 
	 * @param translation The translation.
	 */
	public void setTranslation(Translation translation) {
		this.translation = translation;
	}
	
	/**
	 * Saves the current label object to the database.
	 * The method also assures, that a label is stored
 only once.
	 */
	@Override
	public void save() throws OptimisticLockException {
		
		// Make sure the translation is stored already.
		if (this.translation != null)
			this.translation.save();
		
		// Check if label is already in database.
		// Make sure a label is stored only once.
		Gender gender = Gender.findGenderByName(this.label);
		if (gender != null) {
			this.id = gender.getId();
			return;
		}
		
		try {
			Ebean.save(this);
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Gender "+ this.label + " stored/updated in database.");
			}
		} catch (OptimisticLockException e) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.error("Unable to write to the database.");
			}
			throw new OptimisticLockException();
		} catch (Exception e) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.error("Unable to write to the database.\n" + e.getMessage());
			}
		}
	}

}
