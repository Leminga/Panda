package models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import play.db.ebean.Model.Finder;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.libs.Json;
import play.data.validation.Constraints.Required;

import java.util.Date;

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
