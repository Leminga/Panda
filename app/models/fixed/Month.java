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
public class Month extends models.Entity {

    /**
     * The serialization version identifier.
     */
    @Transient
    private static final long serialVersionUID = 1L;
    /**
     * A finder to query the database.
     */
    private static Finder<Long, Month> FIND = new Finder<Long, Month>(Long.class, Month.class);
    /**
     * Logger to log SecurityController events.
     */
    private static Logger LOGGER = LoggerFactory.getLogger(Month.class);

    /**
     * The database id.
     */
    @Id
    @Required
    @GeneratedValue
    private long id;
    /**
     * The month string.
     */
    private String month;
    /**
     * The translation.
     */
    @OneToOne // Owning side.
    private Translation translation;

    /**
     * Generate the default months to populate the database initially.
     */
    public static void generateDefault() {
        Translation trans_january = new Translation("Jänner", "January");
        Translation trans_february = new Translation("Februar", "February");
        Translation trans_march = new Translation("März", "March");
        Translation trans_april = new Translation("April", "April");
        Translation trans_may = new Translation("Mai", "May");
        Translation trans_june = new Translation("Juni", "June");
        Translation trans_july = new Translation("Juli", "July");
        Translation trans_august = new Translation("August", "August");
        Translation trans_september = new Translation("September", "September");
        Translation trans_october = new Translation("October", "Oktober");
        Translation trans_november = new Translation("November", "November");
        Translation trans_december = new Translation("December", "Dezember");

        trans_january.save();
        trans_february.save();
        trans_march.save();
        trans_april.save();
        trans_may.save();
        trans_june.save();
        trans_july.save();
        trans_august.save();
        trans_september.save();
        trans_october.save();
        trans_november.save();
        trans_december.save();

        Month january = new Month("January");
        january.setTranslation(trans_january);
        Month february = new Month("February");
        february.setTranslation(trans_february);
        Month march = new Month("March");
        march.setTranslation(trans_march);
        Month april = new Month("April");
        april.setTranslation(trans_april);
        Month may = new Month("May");
        may.setTranslation(trans_may);
        Month june = new Month("June");
        june.setTranslation(trans_june);
        Month july = new Month("July");
        july.setTranslation(trans_july);
        Month august = new Month("August");
        august.setTranslation(trans_august);
        Month september = new Month("September");
        september.setTranslation(trans_september);
        Month october = new Month("October");
        october.setTranslation(trans_october);
        Month november = new Month("November");
        november.setTranslation(trans_november);
        Month december = new Month("December");
        december.setTranslation(trans_december);

        january.save();
        february.save();
        march.save();
        april.save();
        may.save();
        june.save();
        july.save();
        august.save();
        september.save();
        october.save();
        november.save();
        december.save();
    }

    /**
     * Query the database for all month objects.
     *
     * @return <b>List of Month</b>All month objects stored in the database.
     */
    public static List<Month> findMonths() {
        try {
            List<Month> months = FIND.all();
            if (LOGGER.isDebugEnabled() && (months == null || months.isEmpty())) {
                LOGGER.debug("No month was found in the database.");
            }
            return months;
        } catch (Exception e) {
            LOGGER.error("Unable to query the database for months." + e.getMessage());
            return null;
        }
    }

    /**
     * Finds a months object by its name.
     *
     * @return <b>Month</b> The Month object.
     */
    public static Month findMonthByName(String monthName) {
        try {
            Month gender = FIND.where().eq("gender", monthName.toLowerCase()).findUnique();
            if (LOGGER.isDebugEnabled() && gender == null) {
                LOGGER.debug("No month was found in the database.");
            }
            return gender;
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("Unable to query the database for month with name " + monthName.toLowerCase() + "\n" + e.getMessage());
            return null;
        }
    }

    /**
     * Default constructor.
     *
     * @param month The Month.
     */
    public Month(String month) {
        this.month = month.toLowerCase();
    }

    /**
     * Getter for the database id.
     *
     * @return <b>long</b> The database id of the month.
     */
    public long getId() {
        return this.id;
    }

    /**
     * Getter for the Month.
     *
     * @return <b>Month</b> The Month.
     */
    public String getMonth() {
        return this.month;
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
     * Saves the current month object to the database. The method also assures,
     * that a month is stored only once.
     */
    @Override
    public void save() throws OptimisticLockException {

        // Make sure the translation is stored already.
        if (this.translation != null) {
            this.translation.save();
        }

        // Check if month is already in database.
        // Make sure a month is stored only once.
        Month month = Month.findMonthByName(this.month);
        if (month != null) {
            this.id = month.getId();
            return;
        }

        try {
            Ebean.save(this);
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Month " + this.month + " stored/updated in database.");
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
