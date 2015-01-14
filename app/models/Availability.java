package models;

import java.util.Date;

import javax.persistence.Entity;

import play.db.ebean.Model;

@Entity
public class Availability extends Model {
	
	/*
	 * Klasse enthält die Einsatzzeiten eines Volunteers. Anfang, Ende und ob er bei den Vorbereitungen
	 * des Events helfen möchte
	 */
	
	/** The serialization version identifier. */
	private static final long serialVersionUID = 1L;
	
	private Date availabilityStart;
	private Date availabilityEnd;
	private boolean interestInAssistingBeforeEvent;
	
	/*
	 * Getter und Setter
	 */
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
