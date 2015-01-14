package models.human;

import java.util.List;

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
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.GregorianCalendar;
import javax.persistence.CascadeType;
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
import models.fixed.PreferedLanguage;
import models.fixed.Profession;
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

    @OneToOne(cascade = CascadeType.ALL)
    protected User user;

    protected int socialSecurityNumber;

    protected String city;

    protected String plz;

    protected String address;

    @ManyToOne
    protected Country country;

    protected long phoneNumber;

    @ManyToOne
    protected PreferedLanguage preferedLanguage;

    @ManyToOne
    protected IdentificationType identificationType;

    protected String idNumber;

    protected GregorianCalendar idValidUntil;

    protected boolean carDrivingLicense;

    @OneToOne
    protected EmergencyContact emergencyContact;

    @ManyToOne
    protected ClothingSize jacketSize;

    @ManyToOne
    protected ClothingSize trouserSize;

    @ManyToOne
    protected ShoeSize shoeSize;

    protected String photo;

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

    @ManyToOne
    protected ITMediaSkill msOfficeSkill;

    @ManyToOne
    protected ITMediaSkill itNetworkSkill;

    @ManyToOne
    protected ITMediaSkill contentManagementSkill;

    @ManyToOne
    protected ITMediaSkill graphicSkill;

    protected String furtherQualifications;

    protected String eventsParticipated;

    protected boolean interestedICG2016;

    protected boolean interestedSkiing;

    protected boolean interestedSnowboarding;

    protected boolean interestedCrossCountrySkiing;

    protected boolean interestedBiathlon;

    protected boolean interestedIceSkating;

    protected boolean interestedIceHockey;

    @ManyToOne
    protected AreaOfInterest areaInterest1;

    @ManyToOne
    protected AreaOfInterest areaInterest2;

    @ManyToOne
    protected AreaOfInterest areaInterest3;

    protected GregorianCalendar availabilityBeginning;

    protected GregorianCalendar availabilityEnd;

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

    //used for registration proccess
    public Volunteer(User user, String prename, String surname, Gender sex, List<Country> nationalities, Date birthday) {
        this.prename = prename;
        this.surname = surname;
        this.sex = sex;
        this.nationalities = nationalities;
        this.birthday = birthday;
        this.user = user;
    }

    //used to save volunteer information
    public Volunteer(int socialSecurityNumber, String city, String plz, String address, Country country, long phoneNumber, PreferedLanguage preferedLanguage) {
        this.socialSecurityNumber = socialSecurityNumber;
        this.city = city;
        this.plz = plz;
        this.address = address;
        this.country = country;
        this.phoneNumber = phoneNumber;
        this.preferedLanguage = preferedLanguage;
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
