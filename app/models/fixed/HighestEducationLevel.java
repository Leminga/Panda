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
	/** The highestEducationLevel string. */
	private String highestEducationLevel;
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
	 * Query the database for all highestEducationLevel objects.
	 * 
	 * @return <b>List of HighestEducationLevel</b>All highestEducationLevel objects stored in the database.
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
	 * Finds a highestEducationLevel object by its name.
	 * 
	 * @param highestEducationLevelName The highestEducationLevel name, ie. "male" or "female".
	 * @return <b>HighestEducationLevel</b> The highestEducationLevel object.
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
	 * @param highestEducationLevel The highestEducationLevel.
	 */
	public HighestEducationLevel(String highestEducationLevel) {
		this.highestEducationLevel = highestEducationLevel.toLowerCase();
	}
	
	/**
	 * Getter for the database id.
	 * 
	 * @return <b>long</b> The database id of the highestEducationLevel.
	 */
	public long getId() {
		return this.id;
	}
	
	/**
	 * Getter for the HighestEducationLevel.
	 * 
	 * @return <b>HighestEducationLevel</b> The highestEducationLevel.
	 */
	public String getHighestEducationLevel() {
		return this.highestEducationLevel;
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
	 * Saves the current highestEducationLevel object to the database.
	 * The method also assures, that a highestEducationLevel is stored
	 * only once.
	 */
	@Override
	public void save() throws OptimisticLockException {
		
		// Make sure the translation is stored already.
		if (this.translation != null)
			this.translation.save();
		
		// Check if highestEducationLevel is already in database.
		// Make sure a highestEducationLevel is stored only once.
		HighestEducationLevel highestEducationLevel = HighestEducationLevel.findHighestEducationLevelByName(this.highestEducationLevel);
		if (highestEducationLevel != null) {
			this.id = highestEducationLevel.getId();
			return;
		}
		
		try {
			Ebean.save(this);
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("HighestEducationLevel "+ this.highestEducationLevel + " stored/updated in database.");
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
