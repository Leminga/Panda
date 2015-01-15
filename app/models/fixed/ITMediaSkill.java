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
public class ITMediaSkill extends models.Entity {
	/** The serialization version identifier. */
	@Transient
	private static final long serialVersionUID = 1L;
	/** A finder to query the database. */
	private static Finder<Long, ITMediaSkill> FIND = new Finder<Long, ITMediaSkill>(Long.class, ITMediaSkill.class);
	/** Logger to log SecurityController events. */
	private static Logger LOGGER = LoggerFactory.getLogger(ITMediaSkill.class);
	
	/** The database id. */
	@Id
	@Required
	@GeneratedValue
	private long id;
	/** The itMediaSkill string. */
	private String itMediaSkill;
	/** The translation. */
	@OneToOne // Owning side.
	private Translation translation;
	
	/**
	 * Generate the default itMediaSkills to
	 * populate the database initially.
	 */
	public static void generateDefault() {
		
		Translation trans_it1 = new Translation("MS Office","MS Office");
		Translation trans_it2 = new Translation("IT Netzwerke","IT Networks");
		Translation trans_it3 = new Translation("Daten-/Contentmanagement","Data-/Contentmanagement");
		Translation trans_it4 = new Translation("Grafik-/Bildbearbeitung","graphic design, layouting");
		
		trans_it1.save();
		trans_it2.save();
		trans_it3.save();
		trans_it4.save();
		
		ITMediaSkill it1 = new ITMediaSkill("MS Office");
		it1.setTranslation(trans_it1);
		ITMediaSkill it2 = new ITMediaSkill("IT Networks");
		it2.setTranslation(trans_it2);
		ITMediaSkill it3 = new ITMediaSkill("Data-/Contentmanagement");
		it3.setTranslation(trans_it3);
		ITMediaSkill it4 = new ITMediaSkill("graphic design, layouting");
		it4.setTranslation(trans_it4);
		
		it1.save();
		it2.save();
		it3.save();
		it4.save();
		
	}
	
	/**
	 * Query the database for all itMediaSkill objects.
	 * 
	 * @return <b>List of ITMediaSkill</b>All itMediaSkill objects stored in the database.
	 */
	public static List<ITMediaSkill> findITMediaSkills() {
		try  {
			List<ITMediaSkill> itMediaSkills = FIND.all();
			if (LOGGER.isDebugEnabled() && (itMediaSkills == null || itMediaSkills.isEmpty())) {
		    	LOGGER.debug("No itMediaSkill was found in the database.");
	    	}
	        return itMediaSkills;
		} catch (Exception e) {
	    	LOGGER.error("Unable to query the database for itMediaSkills." + e.getMessage());
	        return null;
	    }
	}
	
	/**
	 * Finds a itMediaSkill object by its name.
	 * 
	 * @param itMediaSkillName The itMediaSkill name, ie. "male" or "female".
	 * @return <b>ITMediaSkill</b> The itMediaSkill object.
	 */
	public static ITMediaSkill findITMediaSkillByName(String itMediaSkillName) {
		try  {
			ITMediaSkill itMediaSkill = FIND.where().eq("itMediaSkill", itMediaSkillName.toLowerCase()).findUnique();
			if (LOGGER.isDebugEnabled() && itMediaSkill == null) {
		    	LOGGER.debug("No itMediaSkill was found in the database.");
	    	}
	        return itMediaSkill;
		} catch (Exception e) {
			e.printStackTrace();
	    	LOGGER.error("Unable to query the database for itMediaSkill with name " + itMediaSkillName.toLowerCase() + "\n" + e.getMessage());
	        return null;
	    }
	}
	
	/**
	 * Default constructor.
	 * 
	 * @param itMediaSkill The itMediaSkill.
	 */
	public ITMediaSkill(String itMediaSkill) {
		this.itMediaSkill = itMediaSkill.toLowerCase();
	}
	
	/**
	 * Getter for the database id.
	 * 
	 * @return <b>long</b> The database id of the itMediaSkill.
	 */
	public long getId() {
		return this.id;
	}
	
	/**
	 * Getter for the ITMediaSkill.
	 * 
	 * @return <b>ITMediaSkill</b> The itMediaSkill.
	 */
	public String getITMediaSkill() {
		return this.itMediaSkill;
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
	 * Saves the current itMediaSkill object to the database.
	 * The method also assures, that a itMediaSkill is stored
	 * only once.
	 */
	@Override
	public void save() throws OptimisticLockException {
		
		// Make sure the translation is stored already.
		if (this.translation != null)
			this.translation.save();
		
		// Check if itMediaSkill is already in database.
		// Make sure a itMediaSkill is stored only once.
		ITMediaSkill itMediaSkill = ITMediaSkill.findITMediaSkillByName(this.itMediaSkill);
		if (itMediaSkill != null) {
			this.id = itMediaSkill.getId();
			return;
		}
		
		try {
			Ebean.save(this);
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("ITMediaSkill "+ this.itMediaSkill + " stored/updated in database.");
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
