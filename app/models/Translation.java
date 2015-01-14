package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OptimisticLockException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.avaje.ebean.Ebean;

import play.data.validation.Constraints.Required;

/**
 * The translation object stores translations
 * for names and values in different languages.
 * Right now, we support English and German.
 * 
 * @author Michael Bredel <michael.bredel@fh-kufstein.ac.at>
 */
@Entity
public class Translation extends models.Entity {
	/** The serialization version identifier. */
	private static final long serialVersionUID = 1L;
	/** A finder to query the database. */
	private static Finder<Long, Translation> FIND = new Finder<Long, Translation>(Long.class, Translation.class);
	/** Logger to log SecurityController events. */
	private static Logger LOGGER = LoggerFactory.getLogger(Translation.class);
	
	/**
	 * Finds a translation object by its name.
	 * 
	 * @param translation The translation in English.
	 * @return <b>Translation</b> The translation object.
	 */
	public static Translation findTranslationByName(String transName) {
		try  {
			Translation translation = FIND.where().eq("english", transName).findUnique();
			if (LOGGER.isDebugEnabled() && translation == null) {
		    	LOGGER.debug("No translation was found in the database.");
	    	}
	        return translation;
		} catch (Exception e) {
			e.printStackTrace();
	    	LOGGER.error("Unable to query the database for a translation of " + transName + "\n" + e.getMessage());
	        return null;
	    }
	}
	
	/** The translation database id. */
	@Id
	@Required
	@GeneratedValue
	private long TId;
	/** Translation in English. */
	@Required
	private String english;
	/** Translation in German. */
	@Required
	private String german;
	
	/**
	 * Default constructor.
	 * 
	 * @param german
	 * @param english
	 */
	public Translation(String german, String english) {
		this.setGerman(german);
		this.setEnglish(english);
	}
	
	public long getTId() {
		return this.TId;
	}
	
	public String getGerman() {
		return this.german;
	}
	
	public void setGerman(String german) {
		this.german = german;
	}
	
	public String getEnglish() {
		return this.english;
	}
	
	public void setEnglish(String english) {
		this.english = english;
	}
	
	/**
	 * Saves the current translation object to the database.
	 * The method also assures, that a gender is stored
	 * only once.
	 */
	@Override
	public void save() throws OptimisticLockException {
		// Check if gender is already in database.
		// Make sure a gender is stored only once.
		Translation translation = Translation.findTranslationByName(this.english);
		if (translation != null) {
			this.TId = translation.getTId();
			return;
		}
		
		try {
			Ebean.save(this);
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Translation "+ this.english + " stored/updated in database.");
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
