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
     * The profession string.
     */
    private String profession;
    /**
     * The translation.
     */
    @OneToOne // Owning side.
    private Translation translation;

    /**
     * Generate the default professions to populate the database initially.
     */
    public static void generateDefault() {
        Translation trans_na = new Translation("N/A", "N/A");
        Translation trans_apprenticeship = new Translation("Apprenticeship", "In Ausbildung");
        Translation trans_worker = new Translation("Worker", "Arbeiter/in");
        Translation trans_selfemployed = new Translation("Self-employed", "Selbstständig");
        Translation trans_retired = new Translation("Retired", "Pensioniert");

        trans_na.save();
        trans_apprenticeship.save();
        trans_worker.save();
        trans_selfemployed.save();
        trans_retired.save();

        Profession na = new Profession("N/A");
        na.setTranslation(trans_na);
        Profession apprenticeship = new Profession("Apprenticeship");
        apprenticeship.setTranslation(trans_apprenticeship);
        Profession worker = new Profession("Worker");
        worker.setTranslation(trans_worker);
        Profession selfemployed = new Profession("Self-employed");
        selfemployed.setTranslation(trans_selfemployed);
        Profession retired = new Profession("Retired");
        retired.setTranslation(trans_retired);

        na.save();
        apprenticeship.save();
        worker.save();
        selfemployed.save();
        retired.save();
    }

    /**
     * Query the database for all profession objects.
     *
     * @return <b>List of Profession</b>All profession objects stored in the
     * database.
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
     * Finds a profession object by its name.
     *
     * @return <b>Profession</b> The profession object.
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
     * @param profession The profession.
     */
    public Profession(String profession) {
        this.profession = profession.toLowerCase();
    }

    /**
     * Getter for the database id.
     *
     * @return <b>long</b> The database id of the profession.
     */
    public long getId() {
        return this.id;
    }

    /**
     * Getter for the Profession.
     *
     * @return <b>Profession</b> The profession.
     */
    public String getProfession() {
        return this.profession;
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
     * Saves the current profession object to the database. The method also
     * assures, that a profession is stored only once.
     */
    @Override
    public void save() throws OptimisticLockException {

        // Make sure the translation is stored already.
        if (this.translation != null) {
            this.translation.save();
        }

        // Check if profession is already in database.
        // Make sure a profession is stored only once.
        Profession profession = Profession.findProfessionByName(this.profession);
        if (profession != null) {
            this.id = profession.getId();
            return;
        }

        try {
            Ebean.save(this);
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Profession " + this.profession + " stored/updated in database.");
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