package models;

import models.human.*;
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
import javax.persistence.ManyToOne;
import models.fixed.Language;
import models.fixed.LanguageSkill;

import play.data.validation.Constraints.Required;

@Entity
public class VolunteerLanguageSkill extends models.Entity {

    @Transient
    private static final long serialVersionUID = 1L;

    /**
     * A finder to query the database.
     */
    private static Finder<Long, Volunteer> FIND = new Finder<Long, Volunteer>(Long.class, Volunteer.class);

    /**
     * Logger to log SecurityController events.
     */
    private static Logger LOGGER = LoggerFactory.getLogger(VolunteerLanguageSkill.class);

    @Id
    @Required
    @GeneratedValue
    private long id;

    @Required
    @ManyToOne
    protected Volunteer volunteerId;

    @Required
    @ManyToOne
    protected Language languageId;

    @Required
    @ManyToOne
    protected LanguageSkill languageSkill;

    /**
     * Default constructor.
     *
     * @param prename The name of the human.
     * @param surname The surname of the human.
     */
    public VolunteerLanguageSkill(String prename, String surname) {
    }

    /**
     * Getter for the database id.
     *
     * @return <b>long</b> The database id of the human.
     */
    public long getId() {
        return this.id;
    }

    @Override
    public void save() throws OptimisticLockException {
        // Make sure the related objects are stored in the database already.

        try {
            Ebean.save(this);
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug(this.getClassName() + " " + this.id + " stored/updated in database.");
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
