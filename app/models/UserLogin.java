package models;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OptimisticLockException;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import play.data.validation.Constraints.*;
import play.db.ebean.Model;
import models.exceptions.UserAlreadyExistsException;

import com.avaje.ebean.Ebean;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class UserLogin extends Model {
	/** The serialization version identifier. */
	private static final long serialVersionUID = 1L;
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
	/** Tracks whether their have been changes on the model. */
	@Transient
	private boolean hasChanged;
	
	
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
		this.username = username.toLowerCase().trim();
		this.password = password;
		this.creationTime = new Date();
		this.hasChanged = true;
	}
	
	///
	/// Getter and Setter for the private variables.
	///
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username.toLowerCase().trim();
		this.hasChanged = true;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
		this.hasChanged = true;
	}
	
	public Date getFirstLogin() {
		return firstLogin;
	}
	
	public void setFirstLogin(Date firstLogin) {
		this.firstLogin = firstLogin;
		this.hasChanged = true;
	}
	
	public Date getLastLogin() {
		return lastLogin;
	}
	
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
		this.hasChanged = true;
	}
	
	public String getAuthToken() {
		return authToken;
	}
	
	public void setAuthToken(String authToken) {
		this.authToken = authToken;
		this.hasChanged = true;
	}
	
	///
	/// All the other methods.
	///
	
	/**
	 * Sets the last login date to the current
	 * date.
	 */
	public void updateLastLogin() {
		this.lastLogin = new Date();
		this.hasChanged = true;
		this.save();
	}
	
	/**
	 * Saves the current user object to the database.
	 */
	@Override
	public void save() throws OptimisticLockException {
		// If the entity was not changed, just return.
		if (!this.hasChanged) {
			return;
		}
		
		try {
			Ebean.save(this);
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("User "+ username + " stored/updated in database.");
			}
		} catch (OptimisticLockException e) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.error("Unable to write to the database.");
			}
			throw new OptimisticLockException();
		} catch (Exception e) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.error("Unable to write to the database. \n" + e.getMessage());
			}
		}
	}
	
	/**
     * Creates an authentication token for the user
     * and stores it in the database. The token is valid for
     * some and. The user has to use this token in order to 
     * access given methods. Thus, the token has to be part
     * of the URL.
     * 
     * @return <b>String</b> The authentication token for the user.
     */
    public String createToken() {
        this.authToken = UUID.randomUUID().toString();
        this.hasChanged = true;
        this.save();
        if (LOGGER.isDebugEnabled()) {
        	LOGGER.debug("Authentication token for user " + this.username + " created.");
        }
        return this.authToken;
    }
    
    /**
     * Deletes a user token, e.g. at logout or after a timeout.
     * Without the authentication token, the user is not able
     * to access given secured methods any more. He must log in
     * again to access secured methods again.
     */
    public void deleteAuthToken() {
        this.authToken = null;
        this.hasChanged = true;
        this.save();
        if (LOGGER.isDebugEnabled()) {
        	LOGGER.debug("Authentication token for user " + this.username + " deleted.");
        }
    }

}
