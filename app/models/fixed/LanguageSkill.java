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
	/** The label string. */
	private String label;
	/** The translation. */
	@OneToOne // Owning side.
	private Translation translation;
	
	/**
	 * Generate the default languageSkills to
	 * populate the database initially.
	 */
	public static void generateDefault() {
		
		Translation trans_basic = new Translation("Basiskenntnisse","Basic knowledge");
		Translation trans_good = new Translation("Gute Kenntnisse","Good speaking skills");
		Translation trans_great = new Translation("Sehr gute Kenntnisse in Wort & Schrift","Great knowledge spoken & written");
		
		trans_basic.save();
		trans_good.save();
		trans_great.save();
		
		LanguageSkill basic = new LanguageSkill("Basis knowledge");
		basic.setTranslation(trans_basic);
		LanguageSkill good = new LanguageSkill("Good speaking skills");
		good.setTranslation(trans_good);
		LanguageSkill great = new LanguageSkill("Great knowledge spoken & written");
		great.setTranslation(trans_great);
		
		basic.save();
		good.save();
		great.save();
		
	}
	
	/**
	 * Query the database for all label objects.
	 * 
	 * @return <b>List of LanguageSkill</b>All label objects stored in the database.
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
	 * Finds a label object by its name.
	 * 
	 * @param languageSkillName The label name, ie. "male" or "female".
	 * @return <b>LanguageSkill</b> The label object.
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
	 * @param languageSkill The label.
	 */
	public LanguageSkill(String languageSkill) {
		this.label = languageSkill.toLowerCase();
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
	 * Getter for the LanguageSkill.
	 * 
	 * @return <b>LanguageSkill</b> The label.
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
		LanguageSkill languageSkill = LanguageSkill.findLanguageSkillByName(this.label);
		if (languageSkill != null) {
			this.id = languageSkill.getId();
			return;
		}
		
		try {
			Ebean.save(this);
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("LanguageSkill "+ this.label + " stored/updated in database.");
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
