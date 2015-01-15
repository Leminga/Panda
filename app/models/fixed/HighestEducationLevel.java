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
public class HighestEducationLevel extends models.Entity {
	/** The serialization version identifier. */
	@Transient
	private static final long serialVersionUID = 1L;
	/** A finder to query the database. */
	private static Finder<Long, HighestEducationLevel> FIND = new Finder<Long, HighestEducationLevel>(Long.class, HighestEducationLevel.class);
	/** Logger to log SecurityController events. */
	private static Logger LOGGER = LoggerFactory.getLogger(HighestEducationLevel.class);
	
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
	 * Generate the default highestEducationLevels to
	 * populate the database initially.
	 */
	public static void generateDefault() {
            //TODO
//		Translation trans_male = new Translation("männlich", "male");
//		Translation trans_female = new Translation("weiblich", "female");
//		trans_male.save();
//		trans_female.save();
//		
//		HighestEducationLevel male = new HighestEducationLevel("male");
//		male.setTranslation(trans_male);
//		HighestEducationLevel female = new HighestEducationLevel("female");
//		female.setTranslation(trans_female);
//		
//		male.save();
//		female.save();
	}
	
	/**
	 * Query the database for all label objects.
	 * 
	 * @return <b>List of HighestEducationLevel</b>All label objects stored in the database.
	 */
	public static List<HighestEducationLevel> findHighestEducationLevels() {
		try  {
			List<HighestEducationLevel> highestEducationLevels = FIND.all();
			if (LOGGER.isDebugEnabled() && (highestEducationLevels == null || highestEducationLevels.isEmpty())) {
		    	LOGGER.debug("No highestEducationLevel was found in the database.");
	    	}
	        return highestEducationLevels;
		} catch (Exception e) {
	    	LOGGER.error("Unable to query the database for highestEducationLevels." + e.getMessage());
	        return null;
	    }
	}
	
	/**
	 * Finds a label object by its name.
	 * 
	 * @param highestEducationLevelName The label name, ie. "male" or "female".
	 * @return <b>HighestEducationLevel</b> The label object.
	 */
	public static HighestEducationLevel findHighestEducationLevelByName(String highestEducationLevelName) {
		try  {
			HighestEducationLevel highestEducationLevel = FIND.where().eq("highestEducationLevel", highestEducationLevelName.toLowerCase()).findUnique();
			if (LOGGER.isDebugEnabled() && highestEducationLevel == null) {
		    	LOGGER.debug("No highestEducationLevel was found in the database.");
	    	}
	        return highestEducationLevel;
		} catch (Exception e) {
			e.printStackTrace();
	    	LOGGER.error("Unable to query the database for highestEducationLevel with name " + highestEducationLevelName.toLowerCase() + "\n" + e.getMessage());
	        return null;
	    }
	}
	
	/**
	 * Default constructor.
	 * 
	 * @param highestEducationLevel The label.
	 */
	public HighestEducationLevel(String highestEducationLevel) {
		this.label = highestEducationLevel.toLowerCase();
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
	 * Getter for the HighestEducationLevel.
	 * 
	 * @return <b>HighestEducationLevel</b> The label.
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
		HighestEducationLevel highestEducationLevel = HighestEducationLevel.findHighestEducationLevelByName(this.label);
		if (highestEducationLevel != null) {
			this.id = highestEducationLevel.getId();
			return;
		}
		
		try {
			Ebean.save(this);
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("HighestEducationLevel "+ this.label + " stored/updated in database.");
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
