package models;

import java.util.Date;

import javax.persistence.Entity;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Availability extends Model {
	
	/** The serialization version identifier. */
	private static final long serialVersionUID = 1L;
	
	@Required
	private Date availabilityStart;
	@Required
	private Date availabilityEnd;
	@Required
	private boolean interestInAssistingBeforeEvent;
	
	public Date getAvailabilityStart() {
		return availabilityStart;
	}
	public void setAvailabilityStart(Date availabilityStart) {
		this.availabilityStart = availabilityStart;
	}
	public Date getAvailabilityEnd() {
		return availabilityEnd;
	}
	public void setAvailabilityEnd(Date availabilityEnd) {
		this.availabilityEnd = availabilityEnd;
	}
	public boolean isInterestInAssistingBeforeEvent() {
		return interestInAssistingBeforeEvent;
	}
	public void setInterestInAssistingBeforeEvent(
			boolean interestInAssistingBeforeEvent) {
		this.interestInAssistingBeforeEvent = interestInAssistingBeforeEvent;
	}
	
	

}
