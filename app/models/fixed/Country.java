package models.fixed;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.validation.Constraints.Required;

/**
 * The nationality and all related information.
 * 
 * @author Michael Bredel <michael.bredel@fh-kufstein.ac.at>
 */
@Entity
public class Country extends models.Entity {
	/** The serialization version identifier. */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Required
	long id;
	@Required
	String iso2;
	@Required
	String shortName;
	@Required
	String longName;
	@Required
	String iso3;
	@Required
	String numcode;
	@Required
	String unMember;
	@Required
	String callingCode;
	@Required
	String cctld;
	
	/** Constructor for Nationality */
	public Country(String nationality) {
		this.longName = nationality;
	}
}
