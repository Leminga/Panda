package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import net.sf.ehcache.util.PreferTCCLObjectInputStream;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import play.libs.Json; 


@Entity
public class Translation {
	
	@Id
	@Required
	@GeneratedValue
	@OneToMany
	private long id;
	@Required
	private String german;
	@Required
	private String english;

}
