package models;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Arrival extends Model{
	
	/** The serialization version identifier. */
	private static final long serialVersionUID = 1L;
	
//	@Required
	private Date arrivalDate;
	@Required
	@Column(unique=true)
	private long arrivalPlaceTid;
	
	//OneToOneRelation to Translation
	@OneToOne
	@JoinColumn(name = "arrivalPlaceTid")
	private Translation translation;
	
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
