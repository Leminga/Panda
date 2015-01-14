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
import play.db.ebean.Model;

@Entity
public class ShoeSize extends models.Entity {

    /**
     * The serialization version identifier.
     */
    @Transient
    private static final long serialVersionUID = 1L;
    /**
     * A finder to query the database.
     */
    private static Model.Finder<Long, ShoeSize> FIND = new Model.Finder<Long, ShoeSize>(Long.class, ShoeSize.class);
    /**
     * Logger to log SecurityController events.
     */
    private static Logger LOGGER = LoggerFactory.getLogger(ShoeSize.class);

    /**
     * The database id.
     */
    @Id
    @Required
    @GeneratedValue
    private long id;
    /**
     * The shoeSize string.
     */
    private float shoeSize;

    /**
     * Generate the default shoeSizes to populate the database initially.
     */
    public static void generateDefault() {
        ShoeSize shoeSize_30 = new ShoeSize(30);
        shoeSize_30.save();
        ShoeSize shoeSize_31 = new ShoeSize(31);
        shoeSize_31.save();
        ShoeSize shoeSize_32 = new ShoeSize(32);
        shoeSize_32.save();
    }

    /**
     * Query the database for all shoeSize objects.
     *
     * @return <b>List of Size</b>All shoeSize objects stored in the database.
     */
    public static List<ShoeSize> findSizes() {
        try {
            List<ShoeSize> shoeSizes = FIND.all();
            if (LOGGER.isDebugEnabled() && (shoeSizes == null || shoeSizes.isEmpty())) {
                LOGGER.debug("No shoeSize was found in the database.");
            }
            return shoeSizes;
        } catch (Exception e) {
            LOGGER.error("Unable to query the database for shoeSizes." + e.getMessage());
            return null;
        }
    }

    /**
     * Finds a shoeSize object by its name.
     *
     * @param shoeSizeName The shoeSize name, ie. "male" or "female".
     * @return <b>Size</b> The shoeSize object.
     */
    public static ShoeSize findSizeByName(float shoeSizeNumber) {
        try {
            ShoeSize shoeSize = FIND.where().eq("shoeSize", shoeSizeNumber).findUnique();
            if (LOGGER.isDebugEnabled() && shoeSize == null) {
                LOGGER.debug("No shoeSize was found in the database.");
            }
            return shoeSize;
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("Unable to query the database for shoeSize with name " + shoeSizeNumber + "\n" + e.getMessage());
            return null;
        }
    }

    /**
     * Default constructor.
     *
     * @param shoeSize The shoeSize.
     */
    public ShoeSize(int shoeSize) {
        this.shoeSize = shoeSize;
    }

    /**
     * Getter for the database id.
     *
     * @return <b>long</b> The database id of the shoeSize.
     */
    public long getId() {
        return this.id;
    }

    /**
     * Getter for the Size.
     *
     * @return <b>Size</b> The shoeSize.
     */
    public float getSize() {
        return this.shoeSize;
    }

    /**
     * Saves the current shoeSize object to the database. The method also
     * assures, that a shoeSize is stored only once.
     */
    @Override
    public void save() throws OptimisticLockException {
        // Check if shoeSize is already in database.
        // Make sure a shoeSize is stored only once.
        ShoeSize shoeSize = ShoeSize.findSizeByName(this.shoeSize);
        if (shoeSize != null) {
            this.id = shoeSize.getId();
            return;
        }

        try {
            Ebean.save(this);
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Size " + this.shoeSize + " stored/updated in database.");
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
