package models;

import helper.GroupType;

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

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.libs.Json;
import play.data.validation.Constraints.Required;

import java.util.Date;

@Entity
public class LoginReceiver extends Human {
	
	@Required
	private String email;
	@Required
	private GroupType GroupT;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public GroupType getGroupT() {
		return GroupT;
	}

	public void setGroupT(GroupType groupT) {
		GroupT = groupT;
	}
	
	

}
