package models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import play.data.validation.Constraints.Required;

public class ActualJob {
	
	@Id
	@Required
	@GeneratedValue
	private long id;
	@Required
	private String actualJobEN;
	@Required
	private String actualJobDE;
}
