package models;

import play.db.ebean.Model.Finder;
import helper.ConnectionTypeDE;
import helper.ConnectionTypeEN;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.libs.Json;

@Entity
public class Contact{
	
	@Required
	private ConnectionTypeDE connectionTypeDE;
	@Required
	private ConnectionTypeEN connectionTypeEN;
}
