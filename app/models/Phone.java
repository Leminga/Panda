package models;

import javax.persistence.Entity;

import play.data.validation.Constraints.Required;

/**
 * The Phone class represents the phone number that is
 * associated with an individual.
 * 
 * @author Michael Bredel <michael.bredel@fh-kufstein.ac.at>
 */
@Entity
public class Phone {
	
	/**
	 * An enum that specifies the type of the
	 * phone number.
	 * 
	 * @author Michael Bredel <michael.bredel@fh-kufstein.ac.at>
	 */
	public enum PhoneType {
		WORK("work"),
		MOBILE("mobile"),
		HOME("home");
		
		private String phoneType;
		
		private PhoneType(String pt) {
			this.phoneType = pt;
		}
		
		public String getValue() {
			return this.phoneType;
		}
		
		@Override
		public String toString() {
			return this.phoneType;
		}
	}
	
	/** The phone number. TODO Any convention? */
	@Required
	private int phoneNumber;
	
	/** The country calling code, e.g. 0049 for Germany. */
	// TODO: Why not only store the country calling code, but the nationality?
	@Required
	private Nationality callingCode;
	
	/** The phone type, ie. home, work, mobile. */
	private PhoneType phoneType;
	
	/**
	 * Getter for the phone number
	 * 
	 * @return <b>int</b> The phone number without the country calling code.
	 */
	public int getPhoneNumber() {
		return phoneNumber;
	}
	
	/**
	 * Setter for the phone number
	 * 
	 * @param phoneNumber The phone number without the country calling code.
	 */
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	/**
	 * Getter for the country calling code.
	 * 
	 * @return
	 */
	public Nationality getCountryCallingCode() {
		return callingCode;
	}
	
	public void setCountryCallingCode(Nationality countryCallingCode) {
		this.callingCode = countryCallingCode;
	}
	
	public PhoneType getPhoneType() {
		return this.phoneType;
	}
	
	public void setPhoneType(PhoneType pt) {
		this.phoneType = pt;
	}
	
	public void setPhoneType(String pt) {
		this.phoneType = PhoneType.valueOf(pt);
	}
	
	/**
	 * A nicely formated string representing the phone number.
	 * 
	 * @return <b>String<b> The phone number as formated string.
	 */
	@Override
	public String toString() {
		/* Just a local string builder. */
		StringBuilder sb = new StringBuilder();
		
		sb.append("(" + this.callingCode.getCallingCode() + ") ");
		sb.append(this.phoneNumber);
		
		return sb.toString();
	}

}
