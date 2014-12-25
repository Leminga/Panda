package models;


import javax.persistence.Entity;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Attachments extends Model{
	
	/** The serialization version identifier. */
	private static final long serialVersionUID = 1L;
	
	@Required
	private byte[] photo;
	@Required
	private byte[] copyPassport;
	@Required
	private byte[] waiver;
	
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public byte[] getCopyPassport() {
		return copyPassport;
	}
	public void setCopyPassport(byte[] copyPassport) {
		this.copyPassport = copyPassport;
	}
	public byte[] getWaiver() {
		return waiver;
	}
	public void setWaiver(byte[] waiver) {
		this.waiver = waiver;
	}
}
