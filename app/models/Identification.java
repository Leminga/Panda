package models;

import helper.IdentificationType;

import play.data.validation.Constraints.Required;


public class Identification {
	
	@Required
	private String identificationNumber;
	@Required
	private IdentificationType identificationType;
	
	

}
