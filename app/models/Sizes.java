package models;

import javax.persistence.Entity;
import play.data.validation.Constraints.Required;

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
