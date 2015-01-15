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
public class AreaOfInterest extends models.Entity {
	/** The serialization version identifier. */
	@Transient
	private static final long serialVersionUID = 1L;
	/** A finder to query the database. */
	private static Finder<Long, AreaOfInterest> FIND = new Finder<Long, AreaOfInterest>(Long.class, AreaOfInterest.class);
	/** Logger to log SecurityController events. */
	private static Logger LOGGER = LoggerFactory.getLogger(AreaOfInterest.class);
	
	/** The database id. */
	@Id
	@Required
	@GeneratedValue
	private long id;
	/** The label string. */
	private String label;
	
	public static void generateDefault() {
            AreaOfInterest a1 = new AreaOfInterest("Accommodation");
            AreaOfInterest a2 = new AreaOfInterest("Accreditation");
            AreaOfInterest a3 = new AreaOfInterest("Administration & Project Management");
            AreaOfInterest a4 = new AreaOfInterest("Ceremonies");
            AreaOfInterest a5 = new AreaOfInterest("Communications");
            AreaOfInterest a6 = new AreaOfInterest("Delegation Services");
            AreaOfInterest a7 = new AreaOfInterest("Event Services");
            AreaOfInterest a8 = new AreaOfInterest("Food & Beverage Services");
            AreaOfInterest a9 = new AreaOfInterest("Logistics");
            AreaOfInterest a10 = new AreaOfInterest("Marketing");
            AreaOfInterest a11 = new AreaOfInterest("Tiroler-Schulsport Winterspiele");
            AreaOfInterest a12 = new AreaOfInterest("Spiel- und Unterhaltungs");
            AreaOfInterest a13 = new AreaOfInterest("Sport");
            AreaOfInterest a14 = new AreaOfInterest("Technology");
            AreaOfInterest a15 = new AreaOfInterest("Transport");
            AreaOfInterest a16 = new AreaOfInterest("Venue Management");
            AreaOfInterest a17 = new AreaOfInterest("VIP Services & Protocol");
            AreaOfInterest a18 = new AreaOfInterest("Volunteer Management");
            
            a1.save();
            a2.save();
            a3.save();
            a4.save();
            a5.save();
            a6.save();
            a7.save();
            a8.save();
            a9.save();
            a10.save();
            a11.save();
            a12.save();
            a13.save();
            a14.save();
            a15.save();
            a16.save();
            a17.save();
            a18.save();
            
	}
	
	/**
	 * Query the database for all label objects.
	 * 
	 * @return <b>List of AreaOfInterest</b>All label objects stored in the database.
	 */
	public static List<AreaOfInterest> findInterests() {
		try  {
			List<AreaOfInterest> interests = FIND.all();
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
	 * Finds a label object by its name.
	 * 
	 * @param interestName The label name, ie. "male" or "female".
	 * @return <b>AreaOfInterest</b> The label object.
	 */
	public static AreaOfInterest findInterestByName(String interestName) {
		try  {
			AreaOfInterest interest = FIND.where().eq("interest", interestName.toLowerCase()).findUnique();
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
	 * @param interest The label.
	 */
	public AreaOfInterest(String interest) {
		this.label = interest.toLowerCase();
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
	 * Getter for the AreaOfInterest.
	 * 
	 * @return <b>AreaOfInterest</b> The label.
	 */
	public String getLabel() {
		return this.label;
	}
	
	/**
	 * Saves the current label object to the database.
	 * The method also assures, that a label is stored
 only once.
	 */
	@Override
	public void save() throws OptimisticLockException {
		
		// Check if label is already in database.
		// Make sure a label is stored only once.
		AreaOfInterest interest = AreaOfInterest.findInterestByName(this.label);
		if (interest != null) {
			this.id = interest.getId();
			return;
		}
		
		try {
			Ebean.save(this);
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Interest "+ this.label + " stored/updated in database.");
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
