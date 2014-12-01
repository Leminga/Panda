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
public class Athlete extends Human {
	
	
	@Required
	private List <Address>addresses;
	@Required
	private List <Identification>identifications;
	@Required
	private List <Languages>languages;
	@Required
	private List <Attachments>attachments;
	@Required
	private List <Arrival>arrivals;
	@Required
	private List <Departure>departures;
	@Required
	private List <Event>events;
	@Required
	private List <Organization>organizations;
	@Required
	private Role role;
	@Required
	private Sport sport;
	
	
	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	public List<Identification> getIdentifications() {
		return identifications;
	}
	public void setIdentifications(List<Identification> identifications) {
		this.identifications = identifications;
	}
	public List<Languages> getLanguages() {
		return languages;
	}
	public void setLanguages(List<Languages> languages) {
		this.languages = languages;
	}
	public List<Event> getEvents() {
		return events;
	}
	public void setEvents(List<Event> events) {
		this.events = events;
	}
	public List<Attachments> getAttachments() {
		return attachments;
	}
	public void setAttachments(List<Attachments> attachments) {
		this.attachments = attachments;
	}
	public List<Arrival> getArrivals() {
		return arrivals;
	}
	public void setArrivals(List<Arrival> arrivals) {
		this.arrivals = arrivals;
	}
	public List<Departure> getDepartures() {
		return departures;
	}
	public void setDepartures(List<Departure> departures) {
		this.departures = departures;
	}
	public List<Organization> getOrganizations() {
		return organizations;
	}
	public void setOrganizations(List<Organization> organizations) {
		this.organizations = organizations;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Sport getSport() {
		return sport;
	}
	public void setSport(Sport sport) {
		this.sport = sport;
	}
	
	
	
	
	
	

}
