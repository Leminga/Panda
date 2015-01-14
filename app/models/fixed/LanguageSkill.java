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
public class LanguageSkill extends models.Entity {
	/** The serialization version identifier. */
	@Transient
	private static final long serialVersionUID = 1L;
	/** A finder to query the database. */
	private static Finder<Long, LanguageSkill> FIND = new Finder<Long, LanguageSkill>(Long.class, LanguageSkill.class);
	/** Logger to log SecurityController events. */
	private static Logger LOGGER = LoggerFactory.getLogger(LanguageSkill.class);
	
	/** The database id. */
	@Id
	@Required
	@GeneratedValue
	private long id;
	/** The languageSkill string. */
	private String languageSkill;
	/** The translation. */
	@OneToOne // Owning side.
	private Translation translation;
	
	/**
	 * Generate the default languageSkills to
	 * populate the database initially.
	 */
	public static void generateDefault() {
		//TODO
	}
	
	/**
	 * Query the database for all languageSkill objects.
	 * 
	 * @return <b>List of LanguageSkill</b>All languageSkill objects stored in the database.
	 */
	public static List<LanguageSkill> findLanguageSkills() {
		try  {
			List<LanguageSkill> languageSkills = FIND.all();
			if (LOGGER.isDebugEnabled() && (languageSkills == null || languageSkills.isEmpty())) {
		    	LOGGER.debug("No languageSkill was found in the database.");
	    	}
	        return languageSkills;
		} catch (Exception e) {
	    	LOGGER.error("Unable to query the database for languageSkills." + e.getMessage());
	        return null;
	    }
	}
	
	/**
	 * Finds a languageSkill object by its name.
	 * 
	 * @param languageSkillName The languageSkill name, ie. "male" or "female".
	 * @return <b>LanguageSkill</b> The languageSkill object.
	 */
	public static LanguageSkill findLanguageSkillByName(String languageSkillName) {
		try  {
			LanguageSkill languageSkill = FIND.where().eq("languageSkill", languageSkillName.toLowerCase()).findUnique();
			if (LOGGER.isDebugEnabled() && languageSkill == null) {
		    	LOGGER.debug("No languageSkill was found in the database.");
	    	}
	        return languageSkill;
		} catch (Exception e) {
			e.printStackTrace();
	    	LOGGER.error("Unable to query the database for languageSkill with name " + languageSkillName.toLowerCase() + "\n" + e.getMessage());
	        return null;
	    }
	}
	
	/**
	 * Default constructor.
	 * 
	 * @param languageSkill The languageSkill.
	 */
	public LanguageSkill(String languageSkill) {
		this.languageSkill = languageSkill.toLowerCase();
	}
	
	/**
	 * Getter for the database id.
	 * 
	 * @return <b>long</b> The database id of the languageSkill.
	 */
	public long getId() {
		return this.id;
	}
	
	/**
	 * Getter for the LanguageSkill.
	 * 
	 * @return <b>LanguageSkill</b> The languageSkill.
	 */
	public String getLanguageSkill() {
		return this.languageSkill;
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
	 * Saves the current languageSkill object to the database.
	 * The method also assures, that a languageSkill is stored
	 * only once.
	 */
	@Override
	public void save() throws OptimisticLockException {
		
		// Make sure the translation is stored already.
		if (this.translation != null)
			this.translation.save();
		
		// Check if languageSkill is already in database.
		// Make sure a languageSkill is stored only once.
		LanguageSkill languageSkill = LanguageSkill.findLanguageSkillByName(this.languageSkill);
		if (languageSkill != null) {
			this.id = languageSkill.getId();
			return;
		}
		
		try {
			Ebean.save(this);
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("LanguageSkill "+ this.languageSkill + " stored/updated in database.");
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
