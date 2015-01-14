package helper;

import com.avaje.ebean.Ebean;
import java.util.Date;
import java.util.List;
import models.Event;
import models.User;
import models.fixed.ClothingSize;
import models.fixed.Gender;
import models.fixed.ITMediaSkill;
import models.fixed.IdentificationType;
import models.fixed.AreaOfInterest;
import models.fixed.LanguageSkill;
import models.fixed.Profession;
import models.fixed.ShoeSize;
import models.fixed.SportSkill;
import models.human.Volunteer;

/**
 * Initializes the Panda application and puts some default values to the
 * database.
 *
 * @author Michael Bredel <michael.bredel@fh-kufstein.ac.at>
 */
public class Starter {

    public static void start() {
        // Initialize some default values needed in the database.
        Gender.generateDefault();
        ShoeSize.generateDefault();
        ClothingSize.generateDefault();
        ITMediaSkill.generateDefault();
        IdentificationType.generateDefault();
        AreaOfInterest.generateDefault();
        LanguageSkill.generateDefault();
        Profession.generateDefault();
        SportSkill.generateDefault();

        // Initialize the default event, ie. ICG2016
        Starter.createEvents();

        // Create some dummy data for testing.
        Starter.createUsers();
    }

    // JUST FOR INITIALIZATION
    private static void createEvents() {
        Event icg2016 = new Event("icg2016");
        icg2016.save();
    }

    // JUST FOR TESTING
    /**
     * Create some dummy users and put them into the database
     */
    private static void createUsers() {
        Event event = Event.findOrCreateEvent("icg2016");
        User user = new User("christian@gruber.at", "passwort");
        Volunteer vol = new Volunteer(user, "Christian", "Gruber", Ebean.find(Gender.class, 1), null, new Date(System.currentTimeMillis()));
        vol.save();
    }
}
