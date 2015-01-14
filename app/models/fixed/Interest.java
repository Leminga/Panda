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
public class Interest extends models.Entity {
	/** The serialization version identifier. */
	@Transient
	private static final long serialVersionUID = 1L;
	/** A finder to query the database. */
	private static Finder<Long, Interest> FIND = new Finder<Long, Interest>(Long.class, Interest.class);
	/** Logger to log SecurityController events. */
	private static Logger LOGGER = LoggerFactory.getLogger(Interest.class);
	
	/** The database id. */
	@Id
	@Required
	@GeneratedValue
	private long id;
	/** The interest string. */
	private String interest;
	/** The translation. */
	@OneToOne // Owning side.
	private Translation translation;
	
	/**
	 * Generate the default interests to
	 * populate the database initially.
	 */
	public static void generateDefault() {
		Translation trans_male = new Translation("männlich", "male");
		Translation trans_female = new Translation("weiblich", "female");
		trans_male.save();
		trans_female.save();
		
		Interest male = new Interest("male");
		male.setTranslation(trans_male);
		Interest female = new Interest("female");
		female.setTranslation(trans_female);
		
		male.save();
		female.save();
	}
	
	/**
	 * Query the database for all interest objects.
	 * 
	 * @return <b>List of Interest</b>All interest objects stored in the database.
	 */
	public static List<Interest> findInterests() {
		try  {
			List<Interest> interests = FIND.all();
			if (LOGGER.isDebugEnabled() && (interests == null || interests.isEmpty())) {
		    	LOGGER.debug("No interest was found in the database.");
	    	}
	        return interests;
		} catch (Exception e) {
	    	LOGGER.error("Unable to query the database for interests." + e.getMessage());
	        return null;
	    }
	}
	
	/**
	 * Finds a interest object by its name.
	 * 
	 * @param interestName The interest name, ie. "male" or "female".
	 * @return <b>Interest</b> The interest object.
	 */
	public static Interest findInterestByName(String interestName) {
		try  {
			Interest interest = FIND.where().eq("interest", interestName.toLowerCase()).findUnique();
			if (LOGGER.isDebugEnabled() && interest == null) {
		    	LOGGER.debug("No interest was found in the database.");
	    	}
	        return interest;
		} catch (Exception e) {
			e.printStackTrace();
	    	LOGGER.error("Unable to query the database for interest with name " + interestName.toLowerCase() + "\n" + e.getMessage());
	        return null;
	    }
	}
	
	/**
	 * Default constructor.
	 * 
	 * @param interest The interest.
	 */
	public Interest(String interest) {
		this.interest = interest.toLowerCase();
	}
	
	/**
	 * Getter for the database id.
	 * 
	 * @return <b>long</b> The database id of the interest.
	 */
	public long getId() {
		return this.id;
	}
	
	/**
	 * Getter for the Interest.
	 * 
	 * @return <b>Interest</b> The interest.
	 */
	public String getInterest() {
		return this.interest;
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
	 * Saves the current interest object to the database.
	 * The method also assures, that a interest is stored
	 * only once.
	 */
	@Override
	public void save() throws OptimisticLockException {
		
		// Make sure the translation is stored already.
		if (this.translation != null)
			this.translation.save();
		
		// Check if interest is already in database.
		// Make sure a interest is stored only once.
		Interest interest = Interest.findInterestByName(this.interest);
		if (interest != null) {
			this.id = interest.getId();
			return;
		}
		
		try {
			Ebean.save(this);
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Interest "+ this.interest + " stored/updated in database.");
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
