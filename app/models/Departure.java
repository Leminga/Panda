package models;

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
public class Departure extends Model {
	
	/** The serialization version identifier. */
	private static final long serialVersionUID = 1L;
	
	@Required
	private Date departureDate;
	@ManyToOne
	private long departurePlaceTid;
	@Required
	private String departureFlightNumber;
	@Required
	private String departureComment;
	
	public Date getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}
	public long getDeparturePlaceTid() {
		return departurePlaceTid;
	}
	public void setDeparturePlaceTid(long departurePlaceTid) {
		this.departurePlaceTid = departurePlaceTid;
	}
	public String getDepartureFlightNumber() {
		return departureFlightNumber;
	}
	public void setDepartureFlightNumber(String departureFlightNumber) {
		this.departureFlightNumber = departureFlightNumber;
	}
	public String getDepartureComment() {
		return departureComment;
	}
	public void setDepartureComment(String departureComment) {
		this.departureComment = departureComment;
	}
	
	
	

}
