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
     * The language string.
     */
    private String language;
    /**
     * The translation.
     */
    @OneToOne // Owning side.
    private Translation translation;

    /**
     * Generate the default languages to populate the database initially.
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
     * Query the database for all language objects.
     *
     * @return <b>List of Language</b>All language objects stored in the
     * database.
     */
    public static List<Language> findLanguages() {
        try {
            List<Language> languages = FIND.all();
            if (LOGGER.isDebugEnabled() && (languages == null || languages.isEmpty())) {
                LOGGER.debug("No language was found in the database.");
            }
            return languages;
        } catch (Exception e) {
            LOGGER.error("Unable to query the database for languages." + e.getMessage());
            return null;
        }
    }

    /**
     * Finds a language object by its name.
     *
     * @param languageName The language name, ie. "male" or "female".
     * @return <b>Language</b> The language object.
     */
    public static Language findLanguageByName(String languageName) {
        try {
            Language language = FIND.where().eq("language", languageName.toLowerCase()).findUnique();
            if (LOGGER.isDebugEnabled() && language == null) {
                LOGGER.debug("No language was found in the database.");
            }
            return language;
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("Unable to query the database for language with name " + languageName.toLowerCase() + "\n" + e.getMessage());
            return null;
        }
    }

    /**
     * Default constructor.
     *
     * @param language The language.
     */
    public Language(String language) {
        this.language = language.toLowerCase();
    }

    /**
     * Getter for the database id.
     *
     * @return <b>long</b> The database id of the language.
     */
    public long getId() {
        return this.id;
    }

    /**
     * Getter for the Language.
     *
     * @return <b>Language</b> The language.
     */
    public String getLanguage() {
        return this.language;
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
     * Saves the current language object to the database. The method also
     * assures, that a language is stored only once.
     */
    @Override
    public void save() throws OptimisticLockException {

        // Make sure the translation is stored already.
        if (this.translation != null) {
            this.translation.save();
        }

        // Check if language is already in database.
        // Make sure a language is stored only once.
        Language language = Language.findLanguageByName(this.language);
        if (language != null) {
            this.id = language.getId();
            return;
        }

        try {
            Ebean.save(this);
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Language " + this.language + " stored/updated in database.");
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
