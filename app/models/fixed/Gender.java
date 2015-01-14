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
import models.human.Volunteer;

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
	/** The gender string. */
	private String gender;
	/** The translation. */
	@OneToOne // Owning side.
	private Translation translation;
	
	/**
	 * Generate the default genders to
	 * populate the database initially.
	 */
	public static void generateDefault() {
		Translation trans_male = new Translation("männlich", "male");
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
	 * Query the database for all gender objects.
	 * 
	 * @return <b>List of Gender</b>All gender objects stored in the database.
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
	 * Finds a gender object by its name.
	 * 
	 * @param genderName The gender name, ie. "male" or "female".
	 * @return <b>Gender</b> The gender object.
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
	 * @param gender The gender.
	 */
	public Gender(String gender) {
		this.gender = gender.toLowerCase();
	}
	
	/**
	 * Getter for the database id.
	 * 
	 * @return <b>long</b> The database id of the gender.
	 */
	public long getId() {
		return this.id;
	}
	
	/**
	 * Getter for the Gender.
	 * 
	 * @return <b>Gender</b> The gender.
	 */
	public String getGender() {
		return this.gender;
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
	 * Saves the current gender object to the database.
	 * The method also assures, that a gender is stored
	 * only once.
	 */
	@Override
	public void save() throws OptimisticLockException {
		
		// Make sure the translation is stored already.
		if (this.translation != null)
			this.translation.save();
		
		// Check if gender is already in database.
		// Make sure a gender is stored only once.
		Gender gender = Gender.findGenderByName(this.gender);
		if (gender != null) {
			this.id = gender.getId();
			return;
		}
		
		try {
			Ebean.save(this);
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Gender "+ this.gender + " stored/updated in database.");
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
