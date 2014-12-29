package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import models.volunteer.Volunteer;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Sizes extends Model{
	
	/** The serialization version identifier. */
	private static final long serialVersionUID = 1L;
	
	@Required
	@GeneratedValue
	@Id
	private long id;
	
	@Required
	@Column(unique=true)
	private long Vid;
	
//	@Required
	private int jacketSize;
//	@Required
	private int trousersSize;
//	@Required
	private int shoeSize;
	
	//OneToOne Relation to Volunteer
	@OneToOne
	@JoinColumn(name = "Vid")
	private Volunteer volunteer;
	
	public int getJacketSize() {
		return jacketSize;
	}
	public void setJacketSize(int jacketSize) {
		this.jacketSize = jacketSize;
	}
	public int getTrousersSize() {
		return trousersSize;
	}
	public void setTrousersSize(int trousersSize) {
		this.trousersSize = trousersSize;
	}
	public int getShoeSize() {
		return shoeSize;
	}
	public void setShoeSize(int shoeSize) {
		this.shoeSize = shoeSize;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getVid() {
		return Vid;
	}
	public void setVid(long vid) {
		Vid = vid;
	}
	public Volunteer getVolunteer() {
		return volunteer;
	}
	public void setVolunteer(Volunteer volunteer) {
		this.volunteer = volunteer;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
