package models.humans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import play.db.ebean.Model.Finder;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import models.AdditionalPacket;
import models.Address;
import models.Arrival;
import models.Attachments;
import models.Departure;
import models.EmailAddress;
import models.Event;
import models.Identification;
import models.Languages;
import models.Organization;
import models.Phone;
import models.Role;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.libs.Json;
import play.data.validation.Constraints.Required;

import java.util.Date;

// TODO: Why don't derive from CityRepresentative?

@Entity
public class CityRepGuest extends CityRepresentative {

	@Required
	private List <AdditionalPacket>additionalPacket;

	public List<AdditionalPacket> getAdditionalPacket() {
		return additionalPacket;
	}

	public void setAdditionalPacket(List<AdditionalPacket> additionalPacket) {
		this.additionalPacket = additionalPacket;
	};

}
