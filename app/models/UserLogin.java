package models;

import play.db.ebean.Model.Finder;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import play.data.validation.Constraints;
import play.db.ebean.Model;
import play.libs.Json;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import models.exceptions.UserAlreadyExistsException;

import com.avaje.ebean.Ebean;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class UserLogin {
	
	@Id
	@Constraints.Required
	private String username;
	@Constraints.Required
	@Constraints.MinLength(6)
	@Constraints.MaxLength(256)
    @JsonIgnore
	private String password;
	@Constraints.Required
	private Date firstLogin;
	@Constraints.Required
	@Basic(optional = false)
	@Column(name = "LastLogin")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastLogin;
	private String authToken;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	
	public UserLogin(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public static Finder<Long, UserLogin> find = new Finder<Long, UserLogin>(Long.class, UserLogin.class);
	
	public static UserLogin findByAuthToken(String authToken) {
	    if (authToken == null) {
	        return null;
	    }
	
	    // Search the database for the user.
	    try  {
	        return find.where().eq("authToken", authToken).findUnique();
	    } catch (Exception e) {
	        return null;
	    }
	}
	public static UserLogin findByName(String username) {
		// Check if any username is provided at all.
	    if (username == null) {
	        return null;
	    }
	
	    // Search the database for the user.
	    try  {
	        return find.where().eq("username", username).findUnique();
	    } catch (Exception e) {
	        return null;
	    }
	}
	/*public static UserLogin findByPassword(String password) {
	    // todo: verify this query is correct.  Does it need an "and" statement?
	    return find.where().eq(("password", getMD5(password)).findUnique();
	}
	*/
	/*public String createToken() {
        this.authToken = UUID.randomUUID().toString();
        Ebean.save(); // Update the user entry in the database.
    }
    */
	/*public boolean registerUser(String name, String password)
	{
		if
	}
	
	*/
	
}
