package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OptimisticLockException;

import models.human.Volunteer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.common.BeanList;
import com.fasterxml.jackson.annotation.JsonIgnore;

import play.data.validation.Constraints.Required;

@javax.persistence.Entity
public class Event extends Entity {
	/** The serialization version identifier. */
	private static final long serialVersionUID = 1L;
	/** A finder to query the database. */
	private static Finder<Long, Event> FIND = new Finder<Long, Event>(Long.class, Event.class);
	/** Logger to log SecurityController events. */
	private static Logger LOGGER = LoggerFactory.getLogger(Event.class);
	
	/** The unique event name. */
	@Id
	@Required
	protected String eventname;
	/** A list of all volunteers of the event. */
	@ManyToMany(mappedBy = "events")
	protected List<Volunteer> volunteers;
	/** The start date of the event. */
	protected Date eventStart;
	/** The end date of the event. */
	protected Date eventEnd;
	
	/**
	 * Query the database for all event objects.
	 * 
	 * @return <b>List of Event</b>All event objects stored in the database.
	 */
	public static List<Event> findEvents() {
		try  {
			List<Event> events = FIND.all();
			if (LOGGER.isDebugEnabled() && (events == null || events.isEmpty())) {
		    	LOGGER.debug("No events was found in the database.");
	    	}
	        return events;
		} catch (Exception e) {
	    	LOGGER.error("Unable to query the database for events.\n" + e.getMessage());
	        return null;
	    }
	}
	
	/**
	 * Finds an event object by its name.
	 * 
	 * @param eventName The name of the event
	 * @return <b>Event</b> The event object.
	 */
	public static Event findEvent(String eventName) {
		try  {
			Event event = FIND.where().eq("eventname", eventName.toLowerCase()).findUnique();
			if (LOGGER.isDebugEnabled() && event == null) {
		    	LOGGER.debug("No event was found in the database.");
	    	}
	        return event;
		} catch (Exception e) {
			e.printStackTrace();
	    	LOGGER.error("Unable to query the database for event with name " + eventName.toLowerCase() + "\n" + e.getMessage());
	        return null;
	    }
	}
	
	/**
	 * Finds an event object by its name. If no event
	 * of that name is in the database already, it
	 * will be created.
	 * 
	 * @param eventName The name of the event
	 * @return <b>Event</b> The event object.
	 */
	public static Event findOrCreateEvent(String eventName) {
		try  {
			Event event = FIND.where().eq("eventname", eventName.toLowerCase()).findUnique();
			if (event == null) {
				event = new Event(eventName);
				event.save();
				if (LOGGER.isDebugEnabled()) {
			    	LOGGER.debug("No event was found in the database. Created a new one.");
		    	}
				return event;
			} else {
				if (LOGGER.isDebugEnabled()) {
			    	LOGGER.debug("Found event in the database.");
		    	}
				return event;
			}
		} catch (Exception e) {
			e.printStackTrace();
	    	LOGGER.error("Unable to query the database for event with name " + eventName.toLowerCase() + "\n" + e.getMessage());
	        return null;
	    }
	}
	
	/**
	 * Default constructor.
	 * 
	 * @param eventname The name of the event.
	 */
	public Event(String eventname) {
		this.eventname = eventname;
		this.volunteers = new BeanList<Volunteer>();
	}
	
	/**
	 * Getter for the unique name of the event.
	 * 
	 * @return <b>String</b> The name of the event.
	 */
	public String getEventName() {
		return this.eventname;
	}
	
	public Date getStartDate() {
		return this.eventStart;
	}
	
	public void setStartDate(Date startDate) {
		this.eventStart = startDate;
	}
	
	public Date getEndDate() {
		return this.eventEnd;
	}
	
	public void setEndDate(Date endDate) {
		this.eventEnd = endDate;
	}
	
	/**
	 * Getter for all volunteers of the event.
	 * 
	 * @return <b>List of Volunteer</b> All volunteers of the event.
	 */
	@JsonIgnore
	public List<Volunteer> getVolunteers() {
		return this.volunteers;
	}
	
	public void addVolunteer(Volunteer volunteer) {
		if (!this.volunteers.contains(volunteer))
			this.volunteers.add(volunteer);
	}
	
	public void removeVolunteer(Volunteer volunteer) {
		this.volunteers.remove(volunteer);
	}
	
	/**
	 * Saves the current event object to the database.
	 */
	@Override
	public void save() throws OptimisticLockException {
		
		// Check if gender is already in database.
		Event event = Event.findEvent(this.eventname);

		try {
			if (event != null) {
				// Update the old event, ie. update all its fields.
				this.saveManyToManyAssociations("volunteers");
				
				Ebean.update(event);
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug("Event "+ this.eventname + " updated in database.");
				}
			} else {
				Ebean.save(this);
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug("Event "+ this.eventname + " stored in database.");
				}
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
