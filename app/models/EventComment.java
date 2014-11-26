package models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import net.sf.ehcache.util.PreferTCCLObjectInputStream;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import play.libs.Json;


public class EventComment {
	@Required
	@Id
	@GeneratedValue
	private long id;
	private String comment;

}
