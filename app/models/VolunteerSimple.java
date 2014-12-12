package models;

import javax.persistence.Entity;

import play.data.validation.Constraints.Required;

@Entity
public class VolunteerSimple extends Human {
	@Required
	private String socialSecurityNumber;

}
