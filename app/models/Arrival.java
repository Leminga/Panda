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
public class Arrival {
	
	@Required
	private Date arrivalDate;
	@ManyToOne
	private long arrivalPlaceTid;
	@Required
	private String arrivalFlightNumber;
	@Required
	private String arrivalComment;
	
	public Date getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	public long getArrivalPlaceTid() {
		return arrivalPlaceTid;
	}
	public void setArrivalPlaceTid(long arrivalPlaceTid) {
		this.arrivalPlaceTid = arrivalPlaceTid;
	}
	public String getArrivalFlightNumber() {
		return arrivalFlightNumber;
	}
	public void setArrivalFlightNumber(String arrivalFlightNumber) {
		this.arrivalFlightNumber = arrivalFlightNumber;
	}
	public String getArrivalComment() {
		return arrivalComment;
	}
	public void setArrivalComment(String arrivalComment) {
		this.arrivalComment = arrivalComment;
	}
	
	
	

}
