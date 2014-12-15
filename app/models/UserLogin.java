package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import play.data.validation.Constraints.*;
import play.db.ebean.Model.Finder;

import models.exceptions.UserAlreadyExistsException;

import com.avaje.ebean.Ebean;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class UserLogin {
	/** A finder to query the database. */
	public static Finder<Long, UserLogin> FIND = new Finder<Long, UserLogin>(Long.class, UserLogin.class);
	/** Logger to log SecurityController events. */
	protected static Logger LOGGER = LoggerFactory.getLogger(UserLogin.class);
	
	/** The username, ie. the email address, of the user. */
	@Id
	@Required
	private String username;
	/** The password, ie. the passwords md5 hash, of the user. */
	@Required
	@MinLength(6)
	@MaxLength(256)
    @JsonIgnore
	private String password;
	/** The date that user was created, ie. registered, the first time. */
	@Required
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationTime;
	/** The date, the user logged in the first time. */
	@Temporal(TemporalType.TIMESTAMP)
	private Date firstLogin;
	/** The date the user logged in the last time. */
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastLogin;
	/** The authentication token when the user is logged in. */
	private String authToken;
	
	/**
	 * Queries the database to find a user that is
	 * uniquely identified by its authentication
	 * token. Returns the UserLogin object of the
	 * user or null, if no user is logged in and
	 * identified by that token.
	 * 
	 * @param authToken The current authentication token, when the user is logged in.
	 * @return <b>UserLogin</b>The user that is identified by a given authentication token.
	 */
	public static UserLogin findByAuthToken(String authToken) {
	    if (authToken == null) {
	        return null;
	    }
	
	    // Search the database for the user.
	    try  {
	    	UserLogin userLogin = FIND.where().eq("authToken", authToken).findUnique();
	    	if (LOGGER.isDebugEnabled() && userLogin == null) {
		    	LOGGER.debug("No user was found in the database for the token " + authToken);
	    	}
	        return userLogin;
	    } catch (Exception e) {
	    	LOGGER.error("Unable to query the database.");
	        return null;
	    }
	}
	
	/**
	 * Queries the database to find a user identified
	 * by its name. Returns the UserLogin object or
	 * null of no user was found by that username.
	 * 
	 * @param username The username, ie. the email address, of the user.
	 * @return <b>UserLogin</b>The user that is identified by the username.
	 */
	public static UserLogin findByName(String username) {
	    if (username == null) {
	        return null;
	    }
	
	    // Search the database for the user.
	    try  {
	    	UserLogin userLogin = FIND.where().eq("username", username.toLowerCase()).findUnique();
	    	if (LOGGER.isDebugEnabled() && userLogin == null) {
	    		LOGGER.debug("No user of username " + username + " was found in the database.");
	    	}
	        return userLogin;
	    } catch (Exception e) {
	    	LOGGER.error("Unable to query the database.");
	        return null;
	    }
	}
	
	/**
	 * Queries the database for a username and the corresponding
	 * password. Hence, this method identifies the user and
	 * verifies her using the password. It return the UserLogin
	 * object, if the user was verified successfully. Otherwise
	 * it return null.
	 * 
	 * @param username The username, ie. the email address, of the user.
	 * @param password The md5 hash of the user's password.
	 * @return @return <b>UserLogin</b>The user that is identified by the username and verified by the password.
	 */
	public static UserLogin findByNameAndPassword(String username, String password) {
		if (password == null) {
	        return null;
	    }
		
		// Search the database for the user.
	    try  {
	    	// TODO: Verify this query is correct. Does it need an "and" statement?
	    	UserLogin userLogin = FIND.where().eq("username", username.toLowerCase()).eq("password", password).findUnique();
	    	if (LOGGER.isDebugEnabled() && userLogin == null) {
	    		LOGGER.debug("No user of username " + username + " was found in the database.");
	    	}
	        return userLogin;
	    } catch (Exception e) {
	    	LOGGER.error("Unable to query the database.");
	        return null;
	    }
	}
	
	/**
	 * Registers a new user and stores him in the database initially.
	 * 
	 * @param username The username, ie. the email address, of the user.
	 * @param password The md5 hash of the user's password.
	 * @throws UserAlreadyExistsException
	 */
    public static void registerUser(String username, String password) throws UserAlreadyExistsException {
		if (findByName(username) == null) {
			UserLogin user = new UserLogin(username.toLowerCase().trim(), password);
			try {
				Ebean.save(user);
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug("User "+ username + " stored in database.");
				}
			} catch (Exception e) {
				if (LOGGER.isDebugEnabled()) {
					LOGGER.error("Unable to write to the database.");
				}
			}
		} else  {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Failed to register the new user " + username + ". The user exists already.");
			}
			throw new UserAlreadyExistsException();
		}
	}
	
	/**
	 * The default constructor.
	 * 
	 * @param username The user name.
	 * @param password The md5 password.
	 */
	public UserLogin(String username, String password) {
		this.username = username;
		this.password = password;
		this.creationTime = new Date();
	}
	
	///
	/// Getter and Setter for the private variables.
	///
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username.toLowerCase().trim();
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
	
	///
	/// All the other methods.
	///
	
	/**
	 * Saves the current user object to the database.
	 */
	public void save() {
		try {
			Ebean.save(this);
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("User "+ username + " stored in database.");
			}
		} catch (Exception e) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.error("Unable to write to the database.");
			}
		}
	}
}
