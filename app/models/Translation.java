package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import play.data.validation.Constraints.Required; 

@Entity
public class Translation {
	
	@Id
	@Required
	@GeneratedValue
	private long id;
	@Required
	private String german;
	@Required
	private String english;

}
