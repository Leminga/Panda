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

import play.data.validation.Constraints.Required;

@Entity
public class Profession extends models.Entity {

    /**
     * The serialization version identifier.
     */
    @Transient
    private static final long serialVersionUID = 1L;
    /**
     * A finder to query the database.
     */
    private static Finder<Long, Profession> FIND = new Finder<Long, Profession>(Long.class, Profession.class);
    /**
     * Logger to log SecurityController events.
     */
    private static Logger LOGGER = LoggerFactory.getLogger(Profession.class);

    /**
     * The database id.
     */
    @Id
    @Required
    @GeneratedValue
    private long id;
    /**
     * The label string.
     */
    private String label;
    /**
     * The translation.
     */
    @OneToOne // Owning side.
    private Translation translation;

    /**
     * Generate the default professions to populate the database initially.
     */
    public static void generateDefault() {
        Translation trans_student = new Translation("SchuelerIn / StudentIN", "Pupil / Student");
        Translation trans_employed = new Translation("ArbeiterIN / Angestellte/r", "Employed");
        Translation trans_selfemployed = new Translation("Selbststaendig", "Self-employed");
        Translation trans_house = new Translation("Hausfrau/mann", "Housewife / Househusband");
        Translation trans_retired = new Translation("PensionistIN", "Retired");
        Translation trans_seeking = new Translation("Arbeitssuchend","Seeking work");
        Translation trans_other = new Translation("Sonstige","Other");

        trans_student.save();
        trans_employed.save();
        trans_selfemployed.save();
        trans_house.save();
        trans_retired.save();
        trans_seeking.save();
        trans_other.save();

        Profession student = new Profession("Pupil / Student");
        student.setTranslation(trans_student);
        Profession employed = new Profession("Employed");
        employed.setTranslation(trans_employed);
        Profession selfemployed = new Profession("Self-employed");
        selfemployed.setTranslation(trans_selfemployed);
        Profession house = new Profession("Housewife / Househusband");
        house.setTranslation(trans_house);
        Profession retired = new Profession("Retired");
        retired.setTranslation(trans_retired);
        Profession seeking = new Profession("Seeking work");
        seeking.setTranslation(trans_seeking);
        Profession other = new Profession("Other");
        retired.setTranslation(trans_other);

        student.save();
        employed.save();
        selfemployed.save();
        house.save();
        retired.save();
        seeking.save();
        other.save();
    }

    /**
     * Query the database for all label objects.
     *
     * @return <b>List of Profession</b>All label objects stored in the
 database.
     */
    public static List<Profession> findProfessions() {
        try {
            List<Profession> professions = FIND.all();
            if (LOGGER.isDebugEnabled() && (professions == null || professions.isEmpty())) {
                LOGGER.debug("No profession was found in the database.");
            }
            return professions;
        } catch (Exception e) {
            LOGGER.error("Unable to query the database for professions." + e.getMessage());
            return null;
        }
    }

    /**
     * Finds a label object by its name.
     *
     * @return <b>Profession</b> The label object.
     */
    public static Profession findProfessionByName(String professionName) {
        try {
            Profession profession = FIND.where().eq("profession", professionName.toLowerCase()).findUnique();
            if (LOGGER.isDebugEnabled() && profession == null) {
                LOGGER.debug("No profession was found in the database.");
            }
            return profession;
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("Unable to query the database for profession with name " + professionName.toLowerCase() + "\n" + e.getMessage());
            return null;
        }
    }

    /**
     * Default constructor.
     *
     * @param profession The label.
     */
    public Profession(String profession) {
        this.label = profession.toLowerCase();
    }

    /**
     * Getter for the database id.
     *
     * @return <b>long</b> The database id of the label.
     */
    public long getId() {
        return this.id;
    }

    /**
     * Getter for the Profession.
     *
     * @return <b>Profession</b> The label.
     */
    public String getLabel() {
        return this.label;
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
     * Saves the current label object to the database. The method also
 assures, that a label is stored only once.
     */
    @Override
    public void save() throws OptimisticLockException {

        // Make sure the translation is stored already.
        if (this.translation != null) {
            this.translation.save();
        }

        // Check if label is already in database.
        // Make sure a label is stored only once.
        Profession profession = Profession.findProfessionByName(this.label);
        if (profession != null) {
            this.id = profession.getId();
            return;
        }

        try {
            Ebean.save(this);
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Profession " + this.label + " stored/updated in database.");
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
