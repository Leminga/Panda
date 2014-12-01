package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import play.data.validation.Constraints.Required;

@Entity
public class Educationlevel {
	
	@Id
	@Required
	@GeneratedValue
	private Long ID;
	@Required
	private String education;

}
