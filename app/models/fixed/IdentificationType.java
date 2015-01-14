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
public class IdentificationType extends models.Entity {

    /**
     * The serialization version identifier.
     */
    @Transient
    private static final long serialVersionUID = 1L;
    /**
     * A finder to query the database.
     */
    private static Finder<Long, IdentificationType> FIND = new Finder<Long, IdentificationType>(Long.class, IdentificationType.class);
    /**
     * Logger to log SecurityController events.
     */
    private static Logger LOGGER = LoggerFactory.getLogger(IdentificationType.class);

    /**
     * The database id.
     */
    @Id
    @Required
    @GeneratedValue
    private long id;
    /**
     * The type string.
     */
    private String type;
    /**
     * The translation.
     */
    @OneToOne // Owning side.
    private Translation translation;

    /**
     * Generate the default types to populate the database initially.
     */
    public static void generateDefault() {
        Translation trans_passport = new Translation("Reisepass", "Passport");
        Translation trans_idcard = new Translation("ID Card", "ID Karte");
        trans_passport.save();
        trans_idcard.save();

        IdentificationType passport = new IdentificationType("Passport");
        passport.setTranslation(trans_passport);
        IdentificationType idCard = new IdentificationType("ID Card");
        idCard.setTranslation(trans_idcard);

        passport.save();
        idCard.save();
    }

    /**
     * Query the database for all type objects.
     *
     * @return <b>List of Type</b>All type objects stored in the database.
     */
    public static List<IdentificationType> findIdentificationTypes() {
        try {
            List<IdentificationType> types = FIND.all();
            if (LOGGER.isDebugEnabled() && (types == null || types.isEmpty())) {
                LOGGER.debug("No type was found in the database.");
            }
            return types;
        } catch (Exception e) {
            LOGGER.error("Unable to query the database for types." + e.getMessage());
            return null;
        }
    }

    /**
     * Finds a type object by its name.
     *
     * @param typeName The type name, ie. "male" or "female".
     * @return <b>Type</b> The type object.
     */
    public static IdentificationType findIdentificationTypeByName(String typeName) {
        try {
            IdentificationType type = FIND.where().eq("type", typeName.toLowerCase()).findUnique();
            if (LOGGER.isDebugEnabled() && type == null) {
                LOGGER.debug("No type was found in the database.");
            }
            return type;
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("Unable to query the database for type with name " + typeName.toLowerCase() + "\n" + e.getMessage());
            return null;
        }
    }

    /**
     * Default constructor.
     *
     * @param type The type.
     */
    public IdentificationType(String type) {
        this.type = type.toLowerCase();
    }

    /**
     * Getter for the database id.
     *
     * @return <b>long</b> The database id of the type.
     */
    public long getId() {
        return this.id;
    }

    /**
     * Getter for the Type.
     *
     * @return <b>Type</b> The type.
     */
    public String getType() {
        return this.type;
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
     * Saves the current type object to the database. The method also assures,
     * that a type is stored only once.
     */
    @Override
    public void save() throws OptimisticLockException {

        // Make sure the translation is stored already.
        if (this.translation != null) {
            this.translation.save();
        }

        // Check if type is already in database.
        // Make sure a type is stored only once.
        IdentificationType type = IdentificationType.findIdentificationTypeByName(this.type);
        if (type != null) {
            this.id = type.getId();
            return;
        }

        try {
            Ebean.save(this);
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Type " + this.type + " stored/updated in database.");
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
