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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Event extends Model{
	
	/** The serialization version identifier. */
	private static final long serialVersionUID = 1L;
	
	@Required
	private String eventname;
	@Required
	private Date eventStart;
	@Required
	private Date eventEnd;
	@ManyToOne
	private String eventDiscriptionTId;
	@Required
	private boolean volunteerOpen;
	@Required
	private boolean dloOpen;
	@Required
	private boolean icgMemberOpen;
	@Required
	private boolean cloOpen;
	@Required
	private boolean locOpen;
	@Required
	private boolean mediaOpen;
	
	public void Inotify(){
		
	}
	
	public String getEventname() {
		return eventname;
	}
	public void setEventname(String eventname) {
		this.eventname = eventname;
	}
	public Date getEventStart() {
		return eventStart;
	}
	public void setEventStart(Date eventStart) {
		this.eventStart = eventStart;
	}
	public Date getEventEnd() {
		return eventEnd;
	}
	public void setEventEnd(Date eventEnd) {
		this.eventEnd = eventEnd;
	}
	public String getEventDiscriptionTId() {
		return eventDiscriptionTId;
	}
	public void setEventDiscriptionTId(String eventDiscription) {
		this.eventDiscriptionTId = eventDiscription;
	}

	public boolean isVolunteerOpen() {
		return volunteerOpen;
	}

	public void setVolunteerOpen(boolean volunteerOpen) {
		this.volunteerOpen = volunteerOpen;
	}

	public boolean isDloOpen() {
		return dloOpen;
	}

	public void setDloOpen(boolean dloOpen) {
		this.dloOpen = dloOpen;
	}

	public boolean isIcgMemberOpen() {
		return icgMemberOpen;
	}

	public void setIcgMemberOpen(boolean icgMemberOpen) {
		this.icgMemberOpen = icgMemberOpen;
	}

	public boolean isCloOpen() {
		return cloOpen;
	}

	public void setCloOpen(boolean cloOpen) {
		this.cloOpen = cloOpen;
	}

	public boolean isLocOpen() {
		return locOpen;
	}

	public void setLocOpen(boolean locOpen) {
		this.locOpen = locOpen;
	}

	public boolean isMediaOpen() {
		return mediaOpen;
	}

	public void setMediaOpen(boolean mediaOpen) {
		this.mediaOpen = mediaOpen;
	}
	
	
	

}
