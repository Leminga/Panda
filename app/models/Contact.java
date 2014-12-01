package models;

import helper.ConnectionTypeDE;
import helper.ConnectionTypeEN;

import javax.persistence.Entity;
import play.data.validation.Constraints.Required;

@Entity
public class Contact{
	
	@Required
	private ConnectionTypeDE connectionTypeDE;
	@Required
	private ConnectionTypeEN connectionTypeEN;
}
