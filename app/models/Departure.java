package models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Departure extends Model {
	
	/** The serialization version identifier. */
	private static final long serialVersionUID = 1L;
	
	@Required
	private Date departureDate;
	@Required
	@Column(unique=true)
	private long departurePlaceTid;
	
	//OneToOneRelation to Translation
	@OneToOne
	@JoinColumn(name = "departurePlaceTid")
	private Translation translation;
	
//	@Required
	private String departureFlightNumber;
//	@Required
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
	public Translation getTranslation() {
		return translation;
	}
	public void setTranslation(Translation translation) {
		this.translation = translation;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
