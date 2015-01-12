package models;

import javax.persistence.Id;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.libs.Json;

@Entity
public class Event extends Model{
	
	/** The serialization version identifier. */
	private static final long serialVersionUID = 1L;
	
	//ManyToMany relation to Volunteer
	@Id
	@Required
	@GeneratedValue
	private long eventId;
	@ManyToMany(cascade = CascadeType.ALL, mappedBy="event")
	private String eventname;
//	@Required
	private Date eventStart;
//	@Required
	private Date eventEnd;
//	@Required
//	@Column(unique=true)
//	private long eventDiscriptionTid;
	
	//OneToOneRelation to Translation
	@Required
	@OneToOne
	@JoinColumn(name = "eventDiscriptionTid")
	private Translation translation;
	
//	@Required
	private boolean volunteerOpen;
//	@Required
	private boolean dloOpen;
//	@Required
	private boolean icgMemberOpen;
//	@Required
	private boolean cloOpen;
//	@Required
	private boolean locOpen;
//	@Required
	private boolean mediaOpen;
	
	
	/*
	 * Konstruktor der Klasse
	 */
	public Event(String eventname) {
		
		this.setEventname(eventname);
	}

	public void Inotify(){
		
	}
	/*
	 * Getter und Setter 
	 */
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
	@JsonIgnore
	public String getClassName() {
		return this.getClass().getSimpleName().toLowerCase();
	}
	
	/**
	 * Converts the current volunteer object to e JSON node.
	 * 
	 * @return <b>JsonNode</b> A JSON node that contains this volunteer object.
	 */
	public JsonNode toJson() {
		ObjectNode result = Json.newObject();
		result.put(this.getClassName(), Json.toJson(this));
		return result;	
	}
}
