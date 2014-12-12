package models;

import java.util.Date;
import java.util.UUID;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import play.data.validation.Constraints;
import play.db.ebean.Model;

/**
 * The User class that represents a user that is able
 * to log in to the system. The user data is automatically
 * mapped to database entries using ebeans. The database
 * keeps a persistent model of the user.
 * 
 * @author Michael Bredel <michael.bredel@fh-kufstein.ac.at>S
 */
@Entity
public class User extends Model {
	/** Serial field for the serializable class User. */
	private static final long serialVersionUID = 1L;

	/** The ID to uniquely reference the user in the database. */
	@Id
    public Long id;
	
	/** The active authentication token when the user is log in.*/
	private String authToken;
	
    /** The email address of the user. */
	@Column(length = 256, unique = true, nullable = false)
    @Constraints.MaxLength(256)
    @Constraints.Required
    @Constraints.Email
    private String emailAddress;
	
	/** The password of the user. */
	@Transient
    @Constraints.Required
    @Constraints.MinLength(6)
    @Constraints.MaxLength(256)
    @JsonIgnore
    private String password;
	
	/** The full name of the user. */
	@Column(length = 256, nullable = false)
    @Constraints.Required
    @Constraints.MinLength(2)
    @Constraints.MaxLength(256)
    public String fullName;
	
	/** The date when the user was added to the database. */
	@Column(nullable = false)
    public Date creationDate;
	
	/** The finder that searches the database for a user. */
	//public static Finder<Long, User> find = new Finder<Long, User>(Long.class, User.class);
	public static controllers.Finder find = controllers.Finder.getInstance();
	
	/**
	 * Search the database for a user based on a given
	 * authentication token. The user (the client) should
	 * hold that token, when the user is logged in.
	 * 
	 * @param authToken The authentication token provided in the URL.
	 * @return <b>User</b> The user that belongs to the given token or null.
	 */
	public static User findByAuthToken(String authToken) {
		// Check if any token is provided at all.
	    if (authToken == null) {
	        return null;
	    }
	
	    // Search the database for the user.
	    try  {
	        //return find.where().eq("authToken", authToken).findUnique();
	    	return find.find(authToken);
	    } catch (Exception e) {
	        return null;
	    }
	}

	/**
	 * Search the database for a user based on its email address.
	 * The email address should be a unique identifier, similar
	 * to the username. Moreover, authenticate the user by
	 * its password.
	 * 
	 * @param emailAddress The email address of the user to verify.
	 * @param password The password of the user to verify.
	 * @return <b>User</b> The user that belongs to the given token or null.
	 */
	public static User findByEmailAddressAndPassword(String emailAddress, String password) {
	    // todo: verify this query is correct.  Does it need an "and" statement?
	    //return find.where().eq("emailAddress", emailAddress.toLowerCase()).eq("shaPassword", getSha512(password)).findUnique();
		return find.find(emailAddress, password);
	}
	
	
	public static User findUserByEmailAddress(String emailAddress) {
		return find.find(emailAddress);
	}

	/**
	 * The default constructor.
	 * 
	 * @param emailAddress The email address of the user.
	 * @param password The password of the user.
	 * @param fullName The full name of the user.
	 */
	public User(String emailAddress, String password, String fullName) {
        this.setEmailAddress(emailAddress);
        this.setPassword(password);
        this.fullName = fullName;
        this.creationDate = new Date();
    }
	
	/**
	 * Getter for the user's email address.
	 * 
	 * @return <b>String</b> The email address of the user.
	 */
	public String getEmailAddress() {
        return this.emailAddress;
    }

	/**
	 * Setter for the user's email address.
	 * 
	 * @param emailAddress The email address of the user.
	 */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress.toLowerCase();
    }
    
    /**
     * Setter for the user password.
     * 
     * @return <b>String</b> The password of the user.
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Getter for the user password.
     * 
     * @param password The password of the user.
     */
    public void setPassword(String password) {
        this.password = password;
        //shaPassword = getSha512(password);
    }
    
    /**
     * A helper method that provides readable access
     * to the private authentication token.
     * 
     * @return <b>String</b> The current authentication token of the user.
     */
    public String getToken() {
    	return this.authToken;
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
        //save(); // Update the user entry in the database.
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
        //save(); // Update the user entry in the database.
    }

}
