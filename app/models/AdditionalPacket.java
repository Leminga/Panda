package models;

import javax.persistence.Entity;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

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
