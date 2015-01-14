package helper;

import models.Event;
import models.User;
import models.fixed.ClothingSize;
import models.fixed.Gender;
import models.fixed.ITMediaSkill;
import models.fixed.IdentificationType;
import models.fixed.Interest;
import models.fixed.LanguageSkill;
import models.fixed.Month;
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
        Interest.generateDefault();
        LanguageSkill.generateDefault();
        Month.generateDefault();
        Profession.generateDefault();
        SportSkill.generateDefault();

        // Initialize the default event, ie. ICG2016
        Starter.createEvents();

        // Create some dummy data for testing.
        Starter.createUsers();
        Starter.createVolunteers();
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
        // Do nothing.
    }

    /**
     * Create a dummy volunteer and put him into the database.
     */
    private static void createVolunteers() {
        Event event = Event.findOrCreateEvent("icg2016");

        // Create a user and a volunteer.
        User user_male = User.findByName("markus@male.at");
        if (user_male == null) {
            user_male = new User("markus@male.at", "password");
            user_male.save();

//            Volunteer male = new Volunteer("Markus", "Male", user_male);
//            male.setGender(new Gender("male"));
//            male.addEvent(event);
//            male.save();
        }
        // Create a user and a volunteer.
        User user_female = User.findByName("friederike@female.at");
        if (user_female == null) {
            user_female = new User("friederike@female.at", "password");
            user_female.save();

//            Volunteer female = new Volunteer("Friederike", "Female", user_female);
//            female.setGender(new Gender("female"));
//            female.addEvent(event);
//            female.save();
        }

        event = Event.findOrCreateEvent("icg2016");
        System.out.println("TEST:" + event.getVolunteers()); // Fails for some reason.

        // TESTING get a user
        User user = User.findByName("markus@male.at");
        System.out.println("TEST: " + user);
    }
}
