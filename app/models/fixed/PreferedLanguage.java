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
public class PreferedLanguage extends models.Entity {
	/** The serialization version identifier. */
	@Transient
	private static final long serialVersionUID = 1L;
	/** A finder to query the database. */
	private static Finder<Long, PreferedLanguage> FIND = new Finder<Long, PreferedLanguage>(Long.class, PreferedLanguage.class);
	/** Logger to log SecurityController events. */
	private static Logger LOGGER = LoggerFactory.getLogger(PreferedLanguage.class);
	
	/** The database id. */
	@Id
	@Required
	@GeneratedValue
	private long id;
	/** The preferedLanguage string. */
	private String preferedLanguage;
	/** The translation. */
	@OneToOne // Owning side.
	private Translation translation;
	
	/**
	 * Generate the default preferedLanguages to
	 * populate the database initially.
	 */
	public static void generateDefault() {
//		Translation trans_male = new Translation("männlich", "male");
//		Translation trans_female = new Translation("weiblich", "female");
//		trans_male.save();
//		trans_female.save();
//		
//		PreferedLanguage male = new PreferedLanguage("male");
//		male.setTranslation(trans_male);
//		PreferedLanguage female = new PreferedLanguage("female");
//		female.setTranslation(trans_female);
//		
//		male.save();
//		female.save();
	}
	
	/**
	 * Query the database for all preferedLanguage objects.
	 * 
	 * @return <b>List of PreferedLanguage</b>All preferedLanguage objects stored in the database.
	 */
	public static List<PreferedLanguage> findPreferedLanguages() {
		try  {
			List<PreferedLanguage> preferedLanguages = FIND.all();
			if (LOGGER.isDebugEnabled() && (preferedLanguages == null || preferedLanguages.isEmpty())) {
		    	LOGGER.debug("No preferedLanguage was found in the database.");
	    	}
	        return preferedLanguages;
		} catch (Exception e) {
	    	LOGGER.error("Unable to query the database for preferedLanguages." + e.getMessage());
	        return null;
	    }
	}
	
	/**
	 * Finds a preferedLanguage object by its name.
	 * 
	 * @param preferedLanguageName The preferedLanguage name, ie. "male" or "female".
	 * @return <b>PreferedLanguage</b> The preferedLanguage object.
	 */
	public static PreferedLanguage findPreferedLanguageByName(String preferedLanguageName) {
		try  {
			PreferedLanguage preferedLanguage = FIND.where().eq("preferedLanguage", preferedLanguageName.toLowerCase()).findUnique();
			if (LOGGER.isDebugEnabled() && preferedLanguage == null) {
		    	LOGGER.debug("No preferedLanguage was found in the database.");
	    	}
	        return preferedLanguage;
		} catch (Exception e) {
			e.printStackTrace();
	    	LOGGER.error("Unable to query the database for preferedLanguage with name " + preferedLanguageName.toLowerCase() + "\n" + e.getMessage());
	        return null;
	    }
	}
	
	/**
	 * Default constructor.
	 * 
	 * @param preferedLanguage The preferedLanguage.
	 */
	public PreferedLanguage(String preferedLanguage) {
		this.preferedLanguage = preferedLanguage.toLowerCase();
	}
	
	/**
	 * Getter for the database id.
	 * 
	 * @return <b>long</b> The database id of the preferedLanguage.
	 */
	public long getId() {
		return this.id;
	}
	
	/**
	 * Getter for the PreferedLanguage.
	 * 
	 * @return <b>PreferedLanguage</b> The preferedLanguage.
	 */
	public String getPreferedLanguage() {
		return this.preferedLanguage;
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
	 * Saves the current preferedLanguage object to the database.
	 * The method also assures, that a preferedLanguage is stored
	 * only once.
	 */
	@Override
	public void save() throws OptimisticLockException {
		
		// Make sure the translation is stored already.
		if (this.translation != null)
			this.translation.save();
		
		// Check if preferedLanguage is already in database.
		// Make sure a preferedLanguage is stored only once.
		PreferedLanguage preferedLanguage = PreferedLanguage.findPreferedLanguageByName(this.preferedLanguage);
		if (preferedLanguage != null) {
			this.id = preferedLanguage.getId();
			return;
		}
		
		try {
			Ebean.save(this);
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("PreferedLanguage "+ this.preferedLanguage + " stored/updated in database.");
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
