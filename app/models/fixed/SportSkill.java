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
public class SportSkill extends models.Entity {
	/** The serialization version identifier. */
	@Transient
	private static final long serialVersionUID = 1L;
	/** A finder to query the database. */
	private static Finder<Long, SportSkill> FIND = new Finder<Long, SportSkill>(Long.class, SportSkill.class);
	/** Logger to log SecurityController events. */
	private static Logger LOGGER = LoggerFactory.getLogger(SportSkill.class);
	
	/** The database id. */
	@Id
	@Required
	@GeneratedValue
	private long id;
	/** The sportSkill string. */
	private String sportSkill;
	/** The translation. */
	@OneToOne // Owning side.
	private Translation translation;
	
	/**
	 * Generate the default sportSkills to
	 * populate the database initially.
	 */
	public static void generateDefault() {
		//TODO
	}
	
	/**
	 * Query the database for all sportSkill objects.
	 * 
	 * @return <b>List of SportSkill</b>All sportSkill objects stored in the database.
	 */
	public static List<SportSkill> findSportSkills() {
		try  {
			List<SportSkill> sportSkills = FIND.all();
			if (LOGGER.isDebugEnabled() && (sportSkills == null || sportSkills.isEmpty())) {
		    	LOGGER.debug("No sportSkill was found in the database.");
	    	}
	        return sportSkills;
		} catch (Exception e) {
	    	LOGGER.error("Unable to query the database for sportSkills." + e.getMessage());
	        return null;
	    }
	}
	
	/**
	 * Finds a sportSkill object by its name.
	 * 
	 * @param sportSkillName The sportSkill name, ie. "male" or "female".
	 * @return <b>SportSkill</b> The sportSkill object.
	 */
	public static SportSkill findSportSkillByName(String sportSkillName) {
		try  {
			SportSkill sportSkill = FIND.where().eq("sportSkill", sportSkillName.toLowerCase()).findUnique();
			if (LOGGER.isDebugEnabled() && sportSkill == null) {
		    	LOGGER.debug("No sportSkill was found in the database.");
	    	}
	        return sportSkill;
		} catch (Exception e) {
			e.printStackTrace();
	    	LOGGER.error("Unable to query the database for sportSkill with name " + sportSkillName.toLowerCase() + "\n" + e.getMessage());
	        return null;
	    }
	}
	
	/**
	 * Default constructor.
	 * 
	 * @param sportSkill The sportSkill.
	 */
	public SportSkill(String sportSkill) {
		this.sportSkill = sportSkill.toLowerCase();
	}
	
	/**
	 * Getter for the database id.
	 * 
	 * @return <b>long</b> The database id of the sportSkill.
	 */
	public long getId() {
		return this.id;
	}
	
	/**
	 * Getter for the SportSkill.
	 * 
	 * @return <b>SportSkill</b> The sportSkill.
	 */
	public String getSportSkill() {
		return this.sportSkill;
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
	 * Saves the current sportSkill object to the database.
	 * The method also assures, that a sportSkill is stored
	 * only once.
	 */
	@Override
	public void save() throws OptimisticLockException {
		
		// Make sure the translation is stored already.
		if (this.translation != null)
			this.translation.save();
		
		// Check if sportSkill is already in database.
		// Make sure a sportSkill is stored only once.
		SportSkill sportSkill = SportSkill.findSportSkillByName(this.sportSkill);
		if (sportSkill != null) {
			this.id = sportSkill.getId();
			return;
		}
		
		try {
			Ebean.save(this);
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("SportSkill "+ this.sportSkill + " stored/updated in database.");
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
