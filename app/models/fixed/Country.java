package models.fixed;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import models.Translation;

import play.data.validation.Constraints.Required;

/**
 * The nationality and all related information.
 *
 * @author Michael Bredel <michael.bredel@fh-kufstein.ac.at>
 */
@Entity
public class Country extends models.Entity {

    /**
     * The serialization version identifier.
     */
    private static final long serialVersionUID = 1L;

    @Id
    @Required
    @GeneratedValue
    long id;

    @Required
    String iso3;

    /**
     * Constructor for Nationality
     */
    public Country(String iso3) {
        this.iso3 = iso3;
    }

    /**
     * Generate the default genders to populate the database initially.
     */
    public static void generateDefault() {
        Country a = new Country("AT");
    }
}
