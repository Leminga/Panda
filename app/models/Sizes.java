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

@Entity
public class Sizes {
	
	@Required
	private int jacketSize;
	@Required
	private int trousersSize;
	@Required
	private int shoeSize;
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
	
	

}
