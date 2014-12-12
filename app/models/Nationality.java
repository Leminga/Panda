package models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

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
	@ManyToMany(cascade = CascadeType.ALL, mappedBy="nationality")
	private int countryId;
	@Required
	private String iso2;
	@Required
	private String shortName;
	@Required
	private String longName;
	@Required
	private String iso3;
	@Required
	private String numcode;
	@Required
	private String unMember;
	@Required
	private String callingCode;
	@Required
	private String cctld;
	
	public int getCountryId() {
		return countryId;
	}
	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}
	public String getIso2() {
		return iso2;
	}
	public void setIso2(String iso2) {
		this.iso2 = iso2;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public String getLongName() {
		return longName;
	}
	public void setLongName(String longName) {
		this.longName = longName;
	}
	public String getIso3() {
		return iso3;
	}
	public void setIso3(String iso3) {
		this.iso3 = iso3;
	}
	public String getNumcode() {
		return numcode;
	}
	public void setNumcode(String numcode) {
		this.numcode = numcode;
	}
	public String getUnMember() {
		return unMember;
	}
	public void setUnMember(String unMember) {
		this.unMember = unMember;
	}
	public String getCallingCode() {
		return callingCode;
	}
	public void setCallingCode(String callingCode) {
		this.callingCode = callingCode;
	}
	public String getCctld() {
		return cctld;
	}
	public void setCctld(String cctld) {
		this.cctld = cctld;
	}
	
	
	
}
