package models;

import play.Logger;
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
	private Date creationTime;
	private Date firstLogin;
	@Column(name = "LastLogin")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastLogin;
	private String authToken;
	@Constraints.Required
	@Constraints.MaxLength(32)
	private String MD5password;
	
	/**
	 * The default constructor.
	 * 
	 * @param username The user name.
	 * @param password The md5 password.
	 */
	public UserLogin(String username, String password) {
		super();
		this.username = username;
		this.password = password;
		this.creationTime = new Date();
	}
	
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
	public String getAuthToken() {
		return authToken;
	}
	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}
	public String getMD5password() {
		return MD5password;
	}
	public void setMD5password(String mD5password) {
		MD5password = mD5password;
	}
	public static Finder<Long, UserLogin> getFind() {
		return find;
	}
	public static void setFind(Finder<Long, UserLogin> find) {
		UserLogin.find = find;
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
	    Logger.info("FIND USER");
	    try  {
	        return find.where().eq("username", username).findUnique();
	    } catch (Exception e) {
	        return null;
	    }
	}
	public  UserLogin findByPassword(String password) {
	    // todo: verify this query is correct.  Does it need an "and" statement?
	    return find.where().eq(("MD5password"), getMD5password()).findUnique();
	}
	
    public static boolean registerUser(String username, String password) throws UserAlreadyExistsException {
		if (findByName(username) == null) {
			UserLogin user = new UserLogin(username, password);
			Ebean.save(user);
			Logger.info("User "+ username + " stored in database.");
			return true;
		} else  {
			throw new UserAlreadyExistsException();
		}
	}
	
	
}
