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
public class AdditionalPacket extends Model{
	
	/** The serialization version identifier. */
	private static final long serialVersionUID = 1L;
	
	@Required
	private boolean packetBooked;
	@Required
	private boolean packetPaid;
	public boolean isPacketBooked() {
		return packetBooked;
	}
	public void setPacketBooked(boolean packetBooked) {
		this.packetBooked = packetBooked;
	}
	public boolean isPacketPaid() {
		return packetPaid;
	}
	public void setPacketPaid(boolean packetPaid) {
		this.packetPaid = packetPaid;
	}
	
	

}
