package models;

import play.data.validation.Constraints.Required;

public class Email {
	
	 @Required
	 private String address;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	 
	 

}
