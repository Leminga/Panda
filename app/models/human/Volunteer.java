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
import java.util.Date;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import models.fixed.ClothingSize;
import models.fixed.Month;
import models.fixed.Country;
import models.fixed.ITMediaSkill;
import models.fixed.IdentificationType;
import models.fixed.Interest;
import models.fixed.LanguageSkill;
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
    /**
     * The user login data.
     */
    @OneToOne // Owning side.
    @JoinColumn(name = "username", referencedColumnName = "username")
    protected User user;

    @Constraints.Required
    protected int birthdayDate;

    @Constraints.Required
    @ManyToOne
    @JoinColumn(name = "birthdayMonth_id", referencedColumnName = "id")
    protected Month birthdayMonth;

    @Constraints.Required
    protected int birthdayYear;

    @Constraints.Required
    @ManyToOne
    @JoinColumn(name = "countryOfBirth_id", referencedColumnName = "id")
    protected Country countryOfBirth;

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
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    protected Country country;

    @Constraints.Required
    protected long phoneNumber;

    @Constraints.Required
    protected String mail;

    @Constraints.Required
    protected boolean adressConfirmed;

    @Constraints.Required
    @ManyToOne
    @JoinColumn(name = "identificationType_id", referencedColumnName = "id")
    protected IdentificationType identificationType;

    @Constraints.Required
    protected String idNumber;

    @Constraints.Required
    protected int dateOfIssue;

    @Constraints.Required
    @ManyToOne
    @JoinColumn(name = "monthOfIssue_id", referencedColumnName = "id")
    protected Month monthOfIssue;

    @Constraints.Required
    protected int yearOfIssue;

    @Constraints.Required
    protected String issuingAuthority;

    @Constraints.Required
    @ManyToOne
    @JoinColumn(name = "validUntilMonth_id", referencedColumnName = "id")
    protected Month validUntilMonth;

    @Constraints.Required
    protected int validUntilYear;

    @Constraints.Required
    protected boolean carDrivingLicense;

    @Constraints.Required
    protected String otherDrivingLicense;

    @Constraints.Required
    protected String comment;

    @OneToOne
    @Constraints.Required
    @JoinColumn(name = "emergencyContact_id", referencedColumnName = "id")
    protected EmergencyContact emergencyContact;

    @Constraints.Required
    @ManyToOne
    @JoinColumn(name = "jacketSize_id", referencedColumnName = "id")
    protected ClothingSize jacketSize;

    @Constraints.Required
    @ManyToOne
    @JoinColumn(name = "trouserSize_id", referencedColumnName = "id")
    protected ClothingSize trouserSize;

    @Constraints.Required
    @ManyToOne
    @JoinColumn(name = "shoeSize_id", referencedColumnName = "id")
    protected ShoeSize shoeSize;

    @Constraints.Required
    @ManyToOne
    @JoinColumn(name = "profession_id", referencedColumnName = "id")
    protected Profession profession;

    protected String university;

    protected String fieldOfProfession;

    protected String professionalCareer;

    @Constraints.Required
    @ManyToOne
    @JoinColumn(name = "germanSkill_id", referencedColumnName = "id")
    protected LanguageSkill germanSkill;

    @Constraints.Required
    @ManyToOne
    @JoinColumn(name = "englishSkill_id", referencedColumnName = "id")
    protected LanguageSkill englishSkill;

    @Constraints.Required
    @ManyToOne
    @JoinColumn(name = "italianSkill_id", referencedColumnName = "id")
    protected LanguageSkill italianSkill;

    @Constraints.Required
    @ManyToOne
    @JoinColumn(name = "frenchSkill_id", referencedColumnName = "id")
    protected LanguageSkill frenchSkill;

    @Constraints.Required
    @ManyToOne
    @JoinColumn(name = "spanishSkill_id", referencedColumnName = "id")
    protected LanguageSkill spanishSkill;

    protected String furtherLangues;

    protected String interpretingLanguages;

    protected String translatingLanguages;

    @Constraints.Required
    @ManyToOne
    @JoinColumn(name = "msOfficeSkill_id", referencedColumnName = "id")
    protected ITMediaSkill msOfficeSkill;

    @Constraints.Required
    @ManyToOne
    @JoinColumn(name = "itNetworkSkill_id", referencedColumnName = "id")
    protected ITMediaSkill itNetworkSkill;

    @Constraints.Required
    @ManyToOne
    @JoinColumn(name = "contentManagementSkill_id", referencedColumnName = "id")
    protected ITMediaSkill contentManagementSkill;

    @Constraints.Required
    @ManyToOne
    @JoinColumn(name = "graphicSkill_id", referencedColumnName = "id")
    protected ITMediaSkill graphicSkill;

    protected String furtherQualifications;

    protected String eventsParticipated;

    @Constraints.Required
    protected boolean interestedICG2016;

    @Constraints.Required
    protected boolean interestedICG2016PriorToBeginning;

    protected String ICG2016Comment;

    @Constraints.Required
    @ManyToOne
    @JoinColumn(name = "skiingSkill_id", referencedColumnName = "id")
    protected SportSkill skiingSkill;

    @Constraints.Required
    @ManyToOne
    @JoinColumn(name = "snowboardSkill_id", referencedColumnName = "id")
    protected SportSkill snowboardSkill;

    @Constraints.Required
    @ManyToOne
    @JoinColumn(name = "crossCountrySkill_id", referencedColumnName = "id")
    protected SportSkill crossCountrySkill;

    @Constraints.Required
    @ManyToOne
    @JoinColumn(name = "biathlonSkill_id", referencedColumnName = "id")
    protected SportSkill biathlonSkill;

    @Constraints.Required
    @ManyToOne
    @JoinColumn(name = "iceSkatingSkill_id", referencedColumnName = "id")
    protected SportSkill iceskatingSkill;

    @Constraints.Required
    @ManyToOne
    @JoinColumn(name = "iceHockeySkill_id", referencedColumnName = "id")
    protected SportSkill iceHockeySkill;

    @Constraints.Required
    @ManyToOne
    @JoinColumn(name = "interest1_id", referencedColumnName = "id")
    protected Interest interest1;

    @Constraints.Required
    @ManyToOne
    @JoinColumn(name = "interest2_id", referencedColumnName = "id")
    protected Interest interest2;

    @Constraints.Required
    @ManyToOne
    @JoinColumn(name = "interest3_id", referencedColumnName = "id")
    protected Interest interest3;

    @Constraints.Required
    protected Date availabilityBeginning;

    @Constraints.Required
    protected Date availabilityEnd;

    @Constraints.Required
    protected String availabilityComment;

    /**
     *
     * @param username
     * @return
     */
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
    public Volunteer(String prename, String surname, User user, String email) {
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
