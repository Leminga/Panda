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
    	
    	Language l1 = new Language("Afar");
    	Language l2 = new Language("Afrikaans");
    	Language l3 = new Language("Aja-Gbe");
    	Language l4 = new Language("Akan");
    	Language l5 = new Language("Albanian");
    	Language l6 = new Language("Amharic");
    	Language l7 = new Language("Anii");
    	Language l8 = new Language("Arabic");
    	Language l9 = new Language("Armenian");
    	Language l10 = new Language("Aymara");
    	Language l11 = new Language("Azerbaijani");
    	Language l12 = new Language("Balanta");
    	Language l13 = new Language("Bambara");
    	Language l14 = new Language("Bariba");
    	Language l15 = new Language("Afar");
    	Language l16 = new Language("Afrikaans");
    	Language l17 = new Language("Aja-Gbe");
    	Language l18 = new Language("Akan");
    	Language l19 = new Language("Albanian");
    	Language l20 = new Language("Amharic");
    	Language l21 = new Language("Anii");
    	Language l22 = new Language("Arabic");
    	Language l23 = new Language("Armenian");
    	Language l24 = new Language("Aymara");
    	Language l25 = new Language("Azerbaijani");
    	Language l26 = new Language("Balanta");
    	Language l27 = new Language("Bambara");
    	Language l28 = new Language("Bariba");
    	Language l29 = new Language("Bassari");
    	Language l30 = new Language("Bedik");
    	
    	Language l31 = new Language("Belarusian");
    	Language l32 = new Language("Bengali");
    	Language l33 = new Language("Berber");
    	Language l34 = new Language("Biali");
    	Language l35 = new Language("Bislama");
    	Language l36 = new Language("Boko");
    	Language l37 = new Language("Bomu");
    	Language l38 = new Language("Bosnian");
    	Language l39 = new Language("Bozo");
    	Language l40 = new Language("Buduma");
    	Language l41 = new Language("Bulgarian");
    	Language l42 = new Language("Burmese");
    	Language l43 = new Language("Cantonese");
    	Language l44 = new Language("Catalan");
    	Language l45 = new Language("Chinese, Mandarin");
    	Language l46 = new Language("Chichewa");
    	Language l47 = new Language("Chirbawe");
    	Language l48 = new Language("Chokwe");
    	Language l49 = new Language("Croatian");
    	Language l50 = new Language("Czech");
    	
    	Language l51 = new Language("Dagaare");
    	Language l52 = new Language("Dagbani");
    	Language l53 = new Language("Dangme");
    	Language l54 = new Language("Danish");
    	Language l55 = new Language("Dari");
    	Language l56 = new Language("Dendi");
    	Language l57 = new Language("Dhivehi");
    	Language l58 = new Language("Dioula");
    	Language l59 = new Language("Dogon");
    	Language l60 = new Language("Dutch");
    	Language l61 = new Language("Dzongkha");
    	Language l62 = new Language("English");
    	Language l63 = new Language("Estonian");
    	Language l64 = new Language("Ewe-Gbe");
    	Language l65 = new Language("Fijian");
    	Language l66 = new Language("Filipino");
    	Language l67 = new Language("Finnish");
    	Language l68 = new Language("Fon-Gbe");
    	Language l69 = new Language("Foodo");
    	Language l70 = new Language("French");
    	
    	Language l71 = new Language("Fula");
    	Language l72 = new Language("Ga");
    	Language l73 = new Language("Gbe");
    	Language l74 = new Language("Gen-Gbe");
    	Language l75 = new Language("Georgian");
    	Language l76 = new Language("German");
    	Language l77 = new Language("Gonja");
    	Language l78 = new Language("Gourmanch");
    	Language l79 = new Language("Greek");
    	Language l80 = new Language("Guarani");
    	Language l81 = new Language("Gujarati");
    	Language l82 = new Language("Haitian Creole");
    	Language l83 = new Language("Hassaniya");
    	Language l84 = new Language("Hausa");
    	Language l85 = new Language("Hebrew");
    	Language l86 = new Language("Hindi");
    	Language l87 = new Language("Hiri Motu");
    	Language l88 = new Language("Hungarian");
    	Language l89 = new Language("Igbo");
    	Language l90 = new Language("Icelandic");
    	
    	Language l91 = new Language("Indonesian");
    	Language l92 = new Language("Irish");
    	Language l93 = new Language("Italian");
    	Language l94 = new Language("Japanese");
    	Language l95 = new Language("Jola");
    	Language l96 = new Language("Kabye");
    	Language l97 = new Language("Kalanga");
    	Language l98 = new Language("Kanuri");
    	Language l99 = new Language("Kasem");
    	Language l100 = new Language("Buduma");
    	Language l101 = new Language("Bulgarian");
    	Language l102 = new Language("Burmese");
    	Language l103 = new Language("Cantonese");
    	Language l104 = new Language("Catalan");
    	Language l105 = new Language("Chinese, Mandarin");
    	Language l106 = new Language("Chichewa");
    	Language l107 = new Language("Chirbawe");
    	Language l108 = new Language("Chokwe");
    	Language l109 = new Language("Croatian");
    	Language l110 = new Language("Czech");
    	
    	
    	
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
