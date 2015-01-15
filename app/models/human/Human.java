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
import models.fixed.Gender;
import models.fixed.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.avaje.ebean.Ebean;
import java.util.Date;
import java.util.Date;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import play.data.validation.Constraints;
import play.data.validation.Constraints.Required;

@MappedSuperclass
public abstract class Human extends models.Entity {

    /**
     * The serialization version identifier.
     */
    @Transient
    private static final long serialVersionUID = 1L;
    /**
     * Logger to log SecurityController events.
     */
    private static Logger LOGGER = LoggerFactory.getLogger(Human.class);

    /**
     * The database id.
     */
    @Id
    @Required
    @GeneratedValue
    private long id;
    /**
     * The surname of the person.
     */
    @Required
    protected String surname;
    /**
     * The name of the person.
     */
    @Required
    protected String prename;

    @Required
    @ManyToOne
    protected Gender sex;

    @Required
    @ManyToOne
    protected Country nationality;

    @Required
    protected Date birthday;

//    public Human(String prename, String surname, Gender gender, List<Country> nationalities, Date birthday) {
//        this.prename = prename;
//        this.surname = surname;
//        this.nationalities = nationalities;
//        this.birthday = birthday;
//    }
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

    public Gender getGender() {
        return this.sex;
    }

    public void setGender(Gender sex) {
        this.sex = sex;
    }

    /**
     * Saves the current human object to the database.
     */
    @Override
    public void save() throws OptimisticLockException {
        try {
            Ebean.save(this);
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug(this.getClassName() + " " + this.surname + " stored/updated in database.");
            }
        } catch (OptimisticLockException e) {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.error("Unable to write to the database." + e.getMessage());
            }
            throw new OptimisticLockException();
        } catch (Exception e) {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.error("Unable to write to the database. \n" + e.getMessage());
            }
        }
    }
}
