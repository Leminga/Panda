package models;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.OptimisticLockException;

import models.human.Volunteer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.avaje.ebean.Ebean;
import com.fasterxml.jackson.annotation.JsonIgnore;

import play.data.validation.Constraints.MaxLength;
import play.data.validation.Constraints.MinLength;
import play.data.validation.Constraints.Required;

@javax.persistence.Entity
public class User extends Entity {

    /**
     * The serialization version identifier.
     */
    private static final long serialVersionUID = 1L;
    /**
     * A finder to query the database.
     */
    private static Finder<Long, User> FIND = new Finder<Long, User>(Long.class, User.class);
    /**
     * Logger to log SecurityController events.
     */
    private static Logger LOGGER = LoggerFactory.getLogger(User.class);

    /**
     * The unique username, ie. the email address, of the user.
     */
    @Id
    @Required
    private String username;
    /**
     * The password, ie. the passwords md5 hash, of the user.
     */
    @Required
    @MinLength(6)
    @MaxLength(256)
    @JsonIgnore
    private String password;
    /**
     * The date that user was created, ie. registered, the first time.
     */
    @Required
    private Date creationTime;
    /**
     * States whether the user has been validated or not.
     */
    private Boolean validated;
    /**
     * The authentication token when the user is logged in.
     */
    private String authToken;
    /**
     * The date the user logged in the last time.
     */
    private Date lastLogin;
    /**
     * OneToOne Relation to Volunteer.
     */
    @OneToOne(optional = true, mappedBy = "user")
    private Volunteer volunteer;

    /**
     * Queries the database to find a user that is uniquely identified by its
     * authentication token. Returns the UserLogin object of the user or null,
     * if no user is logged in and identified by that token.
     *
     * @param authToken The current authentication token, when the user is
     * logged in.
     * @return <b>UserLogin</b>The user that is identified by a given
     * authentication token.
     */
    public static User findByAuthToken(String authToken) {
        if (authToken == null) {
            return null;
        }

        // Search the database for the user.
        try {
            User user = FIND.where().eq("authToken", authToken).findUnique();
            if (LOGGER.isDebugEnabled() && user == null) {
                LOGGER.debug("No user was found in the database for the token " + authToken);
            }
            return user;
        } catch (Exception e) {
            LOGGER.error("Unable to query the database.\n" + e.getMessage());
            return null;
        }
    }

    /**
     * Queries the database to find a user identified by its name. Returns the
     * UserLogin object or null of no user was found by that username.
     *
     * @param username The username, ie. the email address, of the user.
     * @return <b>UserLogin</b>The user that is identified by the username.
     */
    public static User findByName(String username) {
        if (username == null) {
            return null;
        }

        // Search the database for the user.
        try {
            User user = FIND.where().eq("username", username.toLowerCase()).findUnique();
            if (LOGGER.isDebugEnabled() && user == null) {
                LOGGER.debug("No user of username " + username + " was found in the database.");
            }
            return user;
        } catch (Exception e) {
            LOGGER.error("Unable to query the database.\n" + e.getMessage());
            return null;
        }
    }

    /**
     * Queries the database for a username and the corresponding password.
     * Hence, this method identifies the user and verifies her using the
     * password. It return the UserLogin object, if the user was verified
     * successfully. Otherwise it return null.
     *
     * @param username The username, ie. the email address, of the user.
     * @param password The user password.
     * @return @return <b>UserLogin</b>The user that is identified by the
     * username and verified by the password.
     */
    public static User findByNameAndPassword(String username, String password) {
        if (password == null) {
            return null;
        }

        // Search the database for the user.
        try {
            // TODO: Verify this query is correct. Does it need an "and" statement?
            User user = FIND.where().eq("username", username.toLowerCase()).eq("password", password).findUnique();
            if (LOGGER.isDebugEnabled() && user == null) {
                LOGGER.debug("No user of username " + username + " was found in the database.");
            }
            return user;
        } catch (Exception e) {
            LOGGER.error("Unable to query the database.\n" + e.getMessage());
            return null;
        }
    }

    /**
     * The default constructor.
     *
     * @param username The user name.
     * @param password The password.
     */
    public User(String username, String password) {
        this.username = username.toLowerCase().trim();
        this.password = password;
        this.creationTime = new Date();
        this.creationTime = new Date();
        this.validated = false;
    }

    public String getUserName() {
        return this.username;
    }

    @JsonIgnore
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Volunteer getVolunteer() {
        return this.volunteer;
    }

    @JsonIgnore
    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public boolean isValidated() {
        return validated;
    }

    public void setValidated(boolean v) {
        this.validated = v;
    }

    /**
     * Sets the last login date to the current date.
     */
    public void updateLastLogin() {
        this.lastLogin = new Date();
        this.save();
    }

    /**
     * Creates an authentication token for the user and stores it in the
     * database. The token is valid for some and. The user has to use this token
     * in order to access given methods. Thus, the token has to be part of the
     * URL.
     *
     * @return <b>String</b> The authentication token for the user.
     */
    public String createToken() {
        this.authToken = UUID.randomUUID().toString();
        this.save();
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Authentication token for user " + this.username + " created.");
        }
        return this.authToken;
    }

    /**
     * Deletes a user token, e.g. at logout or after a timeout. Without the
     * authentication token, the user is not able to access given secured
     * methods any more. He must log in again to access secured methods again.
     */
    public void deleteAuthToken() {
        this.authToken = null;
        this.save();
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Authentication token for user " + this.username + " deleted.");
        }
    }

    /**
     * Confirms an account.
     *
     * @return <b>boolean</b>True if confirmed, false otherwise.
     */
    public boolean confirm() {
        if (!this.validated) {
            this.validated = true;
            this.save();
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Account validated and confirmed.");
            }
            return true;
        } else {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Account hasl already been validated and confirmed.");
            }
            return false;
        }
    }

    /**
     * Saves the current user object to the database.
     */
    @Override
    public void save() throws OptimisticLockException {
        try {
            Ebean.save(this);
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("User " + username + " stored/updated in database.");
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

}
