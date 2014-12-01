package models;

import play.data.validation.Constraints.Required;

public class Phone {
	
	@Required
	private int phoneNumber;
	@Required
	private Nationality countryCallingCode;
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Nationality getCountryCallingCode() {
		return countryCallingCode;
	}
	public void setCountryCallingCode(Nationality countryCallingCode) {
		this.countryCallingCode = countryCallingCode;
	}
	
	
	
	

}
