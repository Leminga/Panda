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
public class ClothingSize extends models.Entity {

    /**
     * The serialization version identifier.
     */
    @Transient
    private static final long serialVersionUID = 1L;
    /**
     * A finder to query the database.
     */
    private static Finder<Long, ClothingSize> FIND = new Finder<Long, ClothingSize>(Long.class, ClothingSize.class);
    /**
     * Logger to log SecurityController events.
     */
    private static Logger LOGGER = LoggerFactory.getLogger(ClothingSize.class);

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
     * Generate the default sizes to populate the database initially.
     */
    public static void generateDefault() {
        ClothingSize xs = new ClothingSize("XS");
        ClothingSize s = new ClothingSize("S");
        ClothingSize m = new ClothingSize("M");
        ClothingSize l = new ClothingSize("L");
        ClothingSize xl = new ClothingSize("XL");
        ClothingSize xxl = new ClothingSize("XXL");

        xs.save();
        s.save();
        m.save();
        l.save();
        xl.save();
        xxl.save();
    }

    /**
     * Query the database for all label objects.
     *
     * @return <b>List of Size</b>All label objects stored in the database.
     */
    public static List<ClothingSize> findSizes() {
        try {
            List<ClothingSize> sizes = FIND.all();
            if (LOGGER.isDebugEnabled() && (sizes == null || sizes.isEmpty())) {
                LOGGER.debug("No size was found in the database.");
            }
            return sizes;
        } catch (Exception e) {
            LOGGER.error("Unable to query the database for sizes." + e.getMessage());
            return null;
        }
    }

    /**
     * Finds a label object by its name.
     *
     * @param sizeName The label name, ie. "male" or "female".
     * @return <b>Size</b> The label object.
     */
    public static ClothingSize findSizeByName(String sizeName) {
        try {
            ClothingSize size = FIND.where().eq("size", sizeName.toLowerCase()).findUnique();
            if (LOGGER.isDebugEnabled() && size == null) {
                LOGGER.debug("No size was found in the database.");
            }
            return size;
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("Unable to query the database for size with name " + sizeName.toLowerCase() + "\n" + e.getMessage());
            return null;
        }
    }

    /**
     * Default constructor.
     *
     * @param size The label.
     */
    public ClothingSize(String size) {
        this.label = size.toLowerCase();
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
    public String getLabel() {
        return this.label;
    }

    /**
     * Saves the current label object to the database. The method also assures,
 that a label is stored only once.
     */
    @Override
    public void save() throws OptimisticLockException {
        // Check if label is already in database.
        // Make sure a label is stored only once.
        ClothingSize size = ClothingSize.findSizeByName(this.label);
        if (size != null) {
            this.id = size.getId();
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
