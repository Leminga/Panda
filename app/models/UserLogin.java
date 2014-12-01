package models;

import play.db.ebean.Model.Finder;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.libs.Json;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class UserLogin {
	
	@Required
	private String name;
	@Required
	private String password;
	@Required
	private Date firstLogin;
	@OneToMany
	private Date lastLogin;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getFirstLogin() {
		return firstLogin;
	}
	public void setFirstLogin(Date firstLogin) {
		this.firstLogin = firstLogin;
	}
	public Date getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	
	
}
