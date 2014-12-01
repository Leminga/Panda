package models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import play.data.validation.Constraints.Required;


public class EventComment {
	@Required
	@Id
	@GeneratedValue
	private long id;
	private String comment;

}
