package models.fixed;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OptimisticLockException;
import javax.persistence.Transient;
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
     * The label string.
     */
    private float label;

    /**
     * Generate the default shoeSizes to populate the database initially.
     */
    public static void generateDefault() {
    	
        ShoeSize shoeSize_35 = new ShoeSize(35);
        ShoeSize shoeSize_36 = new ShoeSize(36);
        ShoeSize shoeSize_37 = new ShoeSize(37);
        ShoeSize shoeSize_38 = new ShoeSize(38);
        ShoeSize shoeSize_39 = new ShoeSize(39);
        ShoeSize shoeSize_40 = new ShoeSize(40);
        ShoeSize shoeSize_41 = new ShoeSize(41);
        ShoeSize shoeSize_42 = new ShoeSize(42);
        ShoeSize shoeSize_43 = new ShoeSize(43);
        ShoeSize shoeSize_44 = new ShoeSize(44);
        ShoeSize shoeSize_45 = new ShoeSize(45);
        ShoeSize shoeSize_46 = new ShoeSize(46);
        ShoeSize shoeSize_47 = new ShoeSize(47);
        ShoeSize shoeSize_48 = new ShoeSize(48);
        ShoeSize shoeSize_49 = new ShoeSize(49);
        ShoeSize shoeSize_50 = new ShoeSize(50);
        
        shoeSize_35.save();
        shoeSize_36.save();
        shoeSize_37.save();
        shoeSize_38.save();
        shoeSize_39.save();
        shoeSize_40.save();
        shoeSize_41.save();
        shoeSize_42.save();
        shoeSize_43.save();
        shoeSize_44.save();
        shoeSize_45.save();
        shoeSize_46.save();
        shoeSize_47.save();
        shoeSize_48.save();
        shoeSize_49.save();
        shoeSize_50.save();
        
    }

    /**
     * Query the database for all label objects.
     *
     * @return <b>List of Size</b>All label objects stored in the database.
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
     * Finds a label object by its name.
     *
     * @param shoeSizeName The label name, ie. "male" or "female".
     * @return <b>Size</b> The label object.
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
     * @param shoeSize The label.
     */
    public ShoeSize(int shoeSize) {
        this.label = shoeSize;
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
     * Getter for the Size.
     *
     * @return <b>Size</b> The label.
     */
    public float getSize() {
        return this.label;
    }

    /**
     * Saves the current label object to the database. The method also
 assures, that a label is stored only once.
     */
    @Override
    public void save() throws OptimisticLockException {
        // Check if label is already in database.
        // Make sure a label is stored only once.
        ShoeSize shoeSize = ShoeSize.findSizeByName(this.label);
        if (shoeSize != null) {
            this.id = shoeSize.getId();
            return;
        }

        try {
            Ebean.save(this);
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Size " + this.label + " stored/updated in database.");
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
