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
public class Attachments {
	
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
