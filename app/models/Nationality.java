package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import play.data.validation.Constraints.Required;

/**
 * The nationality and all related information.
 * 
 * @author Michael Bredel <michael.bredel@fh-kufstein.ac.at>
 */
@Entity
public class Nationality {
	/** The unique country code. */
	@Id
	@Required
	private String countryCode;
	/** The id in the translation table. */
	@ManyToOne
	private long countryNameTId;
	/** The country calling code for the teleophone system. */
	@Required
	private String countryCallingCode;
	
	/**
	 * Getter for the unique country code.
	 * 
	 * @return <b>String</b>The unique country code.
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * Getter for the id in the translation table.
	 * 
	 * @return <b>long</b>The id in the translation table.
	 */
	public long getCountryNameTId() {
		return countryNameTId;
	}
	
	/**
	 * Setter for the id in the translation table.
	 * 
	 * @param countryNameTId The id in the translation table.
	 */
	public void setCountryNameTId(long countryNameTId) {
		this.countryNameTId = countryNameTId;
	}
	
	/**
	 * Getter for the country calling code.
	 * 
	 * @return <b>String</b>The country calling code.
	 */
	public String getCountryCallingCode() {
		return countryCallingCode;
	}
	
	/**
	 * Setter for the country calling code.
	 * 
	 * @param countryCallingCode The country calling code.
	 */
	public void setCountryCallingCode(String countryCallingCode) {
		this.countryCallingCode = countryCallingCode;
	}
}
