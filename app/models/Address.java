package models;

import play.data.validation.Constraints.Required;

public class Address {
	
	@Required
	private String street;
	@Required
	private String housenumber;
	@Required
	private String zip;
	@Required
	private String city;
	@Required
	private Nationality country;
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getHousenumber() {
		return housenumber;
	}
	public void setHousenumber(String housenumber) {
		this.housenumber = housenumber;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Nationality getCountry() {
		return country;
	}
	public void setCountry(Nationality country) {
		this.country = country;
	}
	
	
	

}
