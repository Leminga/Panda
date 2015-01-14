package models.human;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.OptimisticLockException;
import javax.persistence.Transient;
import models.fixed.Country;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.avaje.ebean.Ebean;
import javax.persistence.Entity;

import play.data.validation.Constraints.Required;

@Entity
public class EmergencyContact extends models.Entity {

    @Transient
    private static final long serialVersionUID = 1L;

    /**
     * A finder to query the database.
     */
    private static Finder<Long, Volunteer> FIND = new Finder<Long, Volunteer>(Long.class, Volunteer.class);

    /**
     * Logger to log SecurityController events.
     */
    private static Logger LOGGER = LoggerFactory.getLogger(EmergencyContact.class);

    @Id
    @Required
    @GeneratedValue
    private long id;

    @Required
    protected String surname;

    @Required
    protected String prename;

    @Required
    protected Country countryCode;

    @Required
    protected long phoneNumber;

    @Required
    protected String email;

    /**
     * Default constructor.
     *
     * @param prename The name of the human.
     * @param surname The surname of the human.
     */
    public EmergencyContact(String prename, String surname) {
        this.prename = prename;
        this.surname = surname;
    }

    /**
     * Getter for the database id.
     *
     * @return <b>long</b> The database id of the human.
     */
    public long getId() {
        return this.id;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getPrename() {
        return this.prename;
    }

    /**
     * Saves the current emergencycontact object to the database.
     */
    @Override
    public void save() throws OptimisticLockException {
        // Make sure the related objects are stored in the database already.

        try {
            Ebean.save(this);
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug(this.getClassName() + " " + this.surname + " stored/updated in database.");
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
