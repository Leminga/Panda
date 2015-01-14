package models.human;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import models.Event;
import models.User;
import models.fixed.ShoeSize;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.avaje.ebean.common.BeanList;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.Date;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import models.UserLanguageSkill;
import models.fixed.ClothingSize;
import models.fixed.Country;
import models.fixed.HighestEducationLevel;
import models.fixed.ITMediaSkill;
import models.fixed.IdentificationType;
import models.fixed.AreaOfInterest;
import models.fixed.Gender;
import models.fixed.Language;
import models.fixed.LanguageSkill;
import models.fixed.PreferedLanguage;
import models.fixed.Profession;
import models.fixed.SportSkill;
import play.data.validation.Constraints;

@Entity
public class Volunteer extends Human {

    /**
     * The serialization version identifier.
     */
    private static final long serialVersionUID = 1L;
    /**
     * A finder to query the database.
     */
    private static Finder<Long, Volunteer> FIND = new Finder<Long, Volunteer>(Long.class, Volunteer.class);
    /**
     * Logger to log SecurityController events.
     */
    private static Logger LOGGER = LoggerFactory.getLogger(Volunteer.class);

    /**
     * A list of events the volunteer is registered for.
     */
    @ManyToMany
    protected List<Event> events;

    @OneToOne // Owning side.
    protected User user;

    @Constraints.Required
    protected String mail;

    @Constraints.Required
    protected int socialSecurityNumber;

    @Constraints.Required
    protected String placeOfResidence;

    @Constraints.Required //german postal numbers sometimes start with 0 -> String
    protected String plz;

    @Constraints.Required
    protected String adress;

    @Constraints.Required
    @ManyToOne
    protected Country country;

    @Constraints.Required
    protected long phoneNumber;

    @Constraints.Required
    @ManyToOne
    protected PreferedLanguage preferedLanguage;

    @Constraints.Required
    protected boolean adressConfirmed;

    @Constraints.Required
    @ManyToOne
    protected IdentificationType identificationType;

    @Constraints.Required
    protected String idNumber;

    @Constraints.Required
    protected Date idValidUntil;

    @Constraints.Required
    protected boolean carDrivingLicense;

    @OneToOne
    @Constraints.Required
    protected EmergencyContact emergencyContact;

    @Constraints.Required
    @ManyToOne
    protected ClothingSize jacketSize;

    @Constraints.Required
    @ManyToOne
    protected ClothingSize trouserSize;

    @Constraints.Required
    @ManyToOne
    protected ShoeSize shoeSize;

    @Constraints.Required
    protected String photo;

    @Constraints.Required
    @ManyToOne
    protected Profession profession;

    @ManyToOne
    protected HighestEducationLevel highestEducationLevel;

    protected String university;

    protected String fieldOfProfession;

    protected String professionalCareer;

    @ManyToOne
    protected Language motherTongue;

    @OneToMany
    private List<UserLanguageSkill> additionalLanguages;

//    @Constraints.Required
//    @ManyToOne
//    protected LanguageSkill germanSkill;
//
//    @Constraints.Required
//    @ManyToOne
//    protected LanguageSkill englishSkill;
//
//    @Constraints.Required
//    @ManyToOne
//    protected LanguageSkill italianSkill;
//
//    @Constraints.Required
//    @ManyToOne
//    protected LanguageSkill frenchSkill;
//
//    @Constraints.Required
//    @ManyToOne
//    protected LanguageSkill spanishSkill;
    protected String interpretingLanguages;

    protected String translatingLanguages;

    @Constraints.Required
    @ManyToOne
    protected ITMediaSkill msOfficeSkill;

    @Constraints.Required
    @ManyToOne
    protected ITMediaSkill itNetworkSkill;

    @Constraints.Required
    @ManyToOne
    protected ITMediaSkill contentManagementSkill;

    @Constraints.Required
    @ManyToOne
    protected ITMediaSkill graphicSkill;

    protected String furtherQualifications;

    protected String eventsParticipated;

    @Constraints.Required
    protected boolean interestedICG2016;

    protected boolean interestedSkiing;

    protected boolean interestedSnowboarding;

    protected boolean interestedCrossCountrySkiing;

    protected boolean interestedBiathlon;

    protected boolean interestedIceSkating;

    protected boolean interestedIceHockey;

    @Constraints.Required
    @ManyToOne
    protected AreaOfInterest areaInterest1;

    @Constraints.Required
    @ManyToOne
    protected AreaOfInterest areaInterest2;

    @Constraints.Required
    @ManyToOne
    protected AreaOfInterest areaInterest3;

    @Constraints.Required
    protected Date availabilityBeginning;

    @Constraints.Required
    protected Date availabilityEnd;

    protected boolean interestedICG2016PriorToBeginning;

    protected String icg2016Comment;

    String languageSkillsProfessional;

    String trainingSkillsProfessional;

    public static Volunteer findByUsername(String username) {
//        Volunteer v = new Volunteer(username, username, null);
//
//        if (username == null) {
//            return null;
//        }
//
//        // Search the database for the user.
//        try {
//            Volunteer volunteer = FIND.where().eq("user_username", username).findUnique();
//            if (LOGGER.isDebugEnabled() && volunteer == null) {
//                LOGGER.debug("No user was found in the database for the token " + username);
//            }
//            return volunteer;
//        } catch (Exception e) {
//            LOGGER.error("Unable to query the database.\n" + e.getMessage());
//            return null;
//        }
        return null;
    }

    /**
     * Default constructor.
     *
     * @param prename The name of the volunteer
     * @param surname The surname of the volunteer
     * @param user The login data of the volunteer
     */
    public Volunteer(User user, String prename, String surname, Gender gender, List<Country> nationalities, Date birthday, String email) {
        super(prename, surname);
        events = new BeanList<Event>();
        this.user = user;
    }

    public List<Event> getEvents() {
        return this.events;
    }

    public void addEvent(Event event) {
        if (!this.events.contains(event)) {
            this.events.add(event);
            this.saveManyToManyAssociations("events");
        }
    }

    public void removeEvent(Event event) {
        if (this.events.contains(event)) {
            this.events.remove(event);
            this.saveManyToManyAssociations("events");
        }
    }

    @JsonIgnore
    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
