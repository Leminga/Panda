package models.fixed;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.OptimisticLockException;
import javax.persistence.Transient;

import models.Translation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.avaje.ebean.Ebean;
import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import models.human.Volunteer;

import play.data.validation.Constraints.Required;

@Entity
public class Language extends models.Entity {

    /**
     * The serialization version identifier.
     */
    @Transient
    private static final long serialVersionUID = 1L;
    /**
     * A finder to query the database.
     */
    private static Finder<Long, Language> FIND = new Finder<Long, Language>(Long.class, Language.class);
    /**
     * Logger to log SecurityController events.
     */
    private static Logger LOGGER = LoggerFactory.getLogger(Language.class);

    /**
     * The database id.
     */
    @Id
    @Required
    @GeneratedValue
    private long id;
    /**
     * The motherTongue string.
     */
    private String motherTongue;
    /**
     * The translation.
     */
    @OneToOne // Owning side.
    private Translation translation;

    @ManyToMany(mappedBy = "additionalLanguages", cascade = CascadeType.ALL)
    private List<Volunteer> volunteers;

    /**
     * Generate the default motherTongues to populate the database initially.
     */
    public static void generateDefault() {
//		Translation trans_male = new Translation("männlich", "male");
//		Translation trans_female = new Translation("weiblich", "female");
//		trans_male.save();
//		trans_female.save();
//		
//		Language male = new Language("male");
//		male.setTranslation(trans_male);
//		Language female = new Language("female");
//		female.setTranslation(trans_female);
//		
//		male.save();
//		female.save();
    }

    /**
     * Query the database for all motherTongue objects.
     *
     * @return <b>List of Language</b>All motherTongue objects stored in the
     * database.
     */
    public static List<Language> findMotherTongues() {
        try {
            List<Language> motherTongues = FIND.all();
            if (LOGGER.isDebugEnabled() && (motherTongues == null || motherTongues.isEmpty())) {
                LOGGER.debug("No motherTongue was found in the database.");
            }
            return motherTongues;
        } catch (Exception e) {
            LOGGER.error("Unable to query the database for motherTongues." + e.getMessage());
            return null;
        }
    }

    /**
     * Finds a motherTongue object by its name.
     *
     * @param motherTongueName The motherTongue name, ie. "male" or "female".
     * @return <b>Language</b> The motherTongue object.
     */
    public static Language findMotherTongueByName(String motherTongueName) {
        try {
            Language motherTongue = FIND.where().eq("motherTongue", motherTongueName.toLowerCase()).findUnique();
            if (LOGGER.isDebugEnabled() && motherTongue == null) {
                LOGGER.debug("No motherTongue was found in the database.");
            }
            return motherTongue;
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("Unable to query the database for motherTongue with name " + motherTongueName.toLowerCase() + "\n" + e.getMessage());
            return null;
        }
    }

    /**
     * Default constructor.
     *
     * @param motherTongue The motherTongue.
     */
    public Language(String motherTongue) {
        this.motherTongue = motherTongue.toLowerCase();
    }

    /**
     * Getter for the database id.
     *
     * @return <b>long</b> The database id of the motherTongue.
     */
    public long getId() {
        return this.id;
    }

    /**
     * Getter for the Language.
     *
     * @return <b>Language</b> The motherTongue.
     */
    public String getMotherTongue() {
        return this.motherTongue;
    }

    /**
     * Getter for the Translation.
     *
     * @return <b>Translation</b> The translataion.
     */
    public Translation getTranslation() {
        return this.translation;
    }

    /**
     * Setter for the Translation.
     *
     * @param translation The translation.
     */
    public void setTranslation(Translation translation) {
        this.translation = translation;
    }

    /**
     * Saves the current motherTongue object to the database. The method also
     * assures, that a motherTongue is stored only once.
     */
    @Override
    public void save() throws OptimisticLockException {

        // Make sure the translation is stored already.
        if (this.translation != null) {
            this.translation.save();
        }

        // Check if motherTongue is already in database.
        // Make sure a motherTongue is stored only once.
        Language motherTongue = Language.findMotherTongueByName(this.motherTongue);
        if (motherTongue != null) {
            this.id = motherTongue.getId();
            return;
        }

        try {
            Ebean.save(this);
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("MotherTongue " + this.motherTongue + " stored/updated in database.");
            }
        } catch (OptimisticLockException e) {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.error("Unable to write to the database.");
            }
            throw new OptimisticLockException();
        } catch (Exception e) {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.error("Unable to write to the database.\n" + e.getMessage());
            }
        }
    }

}
