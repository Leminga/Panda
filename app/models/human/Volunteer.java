package models.human;

import com.avaje.ebean.Ebean;
import java.util.List;

import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import models.Event;
import models.User;
import models.fixed.ShoeSize;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import models.Entity;
import models.VolunteerLanguageSkill;
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

@javax.persistence.Entity
public class Volunteer extends Entity {

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

    @Id
    @Constraints.Required
    @GeneratedValue
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    @Constraints.Required
    private String surname;

    @Constraints.Required
    private String prename;

    @Constraints.Required
    @ManyToOne
    private Gender sex;

    @Constraints.Required
    @ManyToOne
    private Country nationality;

    @Constraints.Required
    private Date birthday;

    private int socialSecurityNumber;

    private String city;

    private String plz;

    private String address;

    @ManyToOne
    private Country country;

    private long phoneNumber;

    @ManyToOne
    private PreferedLanguage preferedLanguage;

    @ManyToOne
    private IdentificationType identificationType;

    private String idNumber;

    private Date idValidUntil;

    private boolean carDrivingLicense;

    @OneToOne
    private EmergencyContact emergencyContact;

    @ManyToOne
    private ClothingSize jacketSize;

    @ManyToOne
    private ClothingSize trouserSize;

    @ManyToOne
    private ShoeSize shoeSize;

    private String photo;

    @ManyToOne
    private Profession profession;

    @ManyToOne
    private HighestEducationLevel highestEducationLevel;

    private String university;

    private String fieldOfProfession;

    private String professionalCareer;

    @ManyToOne
    private Language motherTongue;

    @OneToMany
    private List<VolunteerLanguageSkill> additionalLanguages;

    private String interpretingLanguages;

    private String translatingLanguages;

    @ManyToOne
    private ITMediaSkill msOfficeSkill;

    @ManyToOne
    private ITMediaSkill itNetworkSkill;

    @ManyToOne
    private ITMediaSkill contentManagementSkill;

    @ManyToOne
    private ITMediaSkill graphicSkill;

    private String furtherQualifications;

    private String eventsParticipated;

    private boolean interestedICG2016;

    private boolean interestedSkiing;

    private boolean interestedSnowboarding;

    private boolean interestedCrossCountrySkiing;

    private boolean interestedBiathlon;

    private boolean interestedIceSkating;

    private boolean interestedIceHockey;

    @ManyToOne
    private AreaOfInterest areaInterest1;

    @ManyToOne
    private AreaOfInterest areaInterest2;

    @ManyToOne
    private AreaOfInterest areaInterest3;

    private Date availabilityBeginning;

    private Date availabilityEnd;

    private boolean interestedICG2016PriorToBeginning;

    private String icg2016Comment;

    private String languageSkillsProfessional;

    private String trainingSkillsProfessional;

    public static Volunteer findByUsername(String username) {
        Volunteer v = Ebean.find(Volunteer.class)
                .where()
                .eq("user_username", username)
                .findUnique();
        return v;
    }

    //used for registration proccess
    public Volunteer(User user, String prename, String surname, Gender sex, Country nationality, Date birthday) {
//        this.registeredVolunteer. = prename;
//        this.surname = surname;
//        this.sex = sex;
//        this.nationality = nationality;
//        this.birthday = birthday;
//        this.user = user;
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

//    public List<Event> getEvents() {
//        return this.events;
//    }
//
//    public void addEvent(Event event) {
//        if (!this.events.contains(event)) {
//            this.getEvents().add(event);
//            this.saveManyToManyAssociations("events");
//        }
//    }
//
//    public void removeEvent(Event event) {
//        if (this.getEvents().contains(event)) {
//            this.getEvents().remove(event);
//            this.saveManyToManyAssociations("events");
//        }
//    }
    /**
     * @return the socialSecurityNumber
     */
    public int getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    /**
     * @param socialSecurityNumber the socialSecurityNumber to set
     */
    public void setSocialSecurityNumber(int socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the plz
     */
    public String getPlz() {
        return plz;
    }

    /**
     * @param plz the plz to set
     */
    public void setPlz(String plz) {
        this.plz = plz;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the country
     */
    public Country getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(Country country) {
        this.country = country;
    }

    /**
     * @return the phoneNumber
     */
    public long getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return the preferedLanguage
     */
    public PreferedLanguage getPreferedLanguage() {
        return preferedLanguage;
    }

    /**
     * @param preferedLanguage the preferedLanguage to set
     */
    public void setPreferedLanguage(PreferedLanguage preferedLanguage) {
        this.preferedLanguage = preferedLanguage;
    }

    /**
     * @return the identificationType
     */
    public IdentificationType getIdentificationType() {
        return identificationType;
    }

    /**
     * @param identificationType the identificationType to set
     */
    public void setIdentificationType(IdentificationType identificationType) {
        this.identificationType = identificationType;
    }

    /**
     * @return the idNumber
     */
    public String getIdNumber() {
        return idNumber;
    }

    /**
     * @param idNumber the idNumber to set
     */
    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    /**
     * @return the idValidUntil
     */
    public Date getIdValidUntil() {
        return idValidUntil;
    }

    /**
     * @param idValidUntil the idValidUntil to set
     */
    public void setIdValidUntil(Date idValidUntil) {
        this.idValidUntil = idValidUntil;
    }

    /**
     * @return the carDrivingLicense
     */
    public boolean isCarDrivingLicense() {
        return carDrivingLicense;
    }

    /**
     * @param carDrivingLicense the carDrivingLicense to set
     */
    public void setCarDrivingLicense(boolean carDrivingLicense) {
        this.carDrivingLicense = carDrivingLicense;
    }

    /**
     * @return the emergencyContact
     */
    public EmergencyContact getEmergencyContact() {
        return emergencyContact;
    }

    /**
     * @param emergencyContact the emergencyContact to set
     */
    public void setEmergencyContact(EmergencyContact emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    /**
     * @return the jacketSize
     */
    public ClothingSize getJacketSize() {
        return jacketSize;
    }

    /**
     * @param jacketSize the jacketSize to set
     */
    public void setJacketSize(ClothingSize jacketSize) {
        this.jacketSize = jacketSize;
    }

    /**
     * @return the trouserSize
     */
    public ClothingSize getTrouserSize() {
        return trouserSize;
    }

    /**
     * @param trouserSize the trouserSize to set
     */
    public void setTrouserSize(ClothingSize trouserSize) {
        this.trouserSize = trouserSize;
    }

    /**
     * @return the shoeSize
     */
    public ShoeSize getShoeSize() {
        return shoeSize;
    }

    /**
     * @param shoeSize the shoeSize to set
     */
    public void setShoeSize(ShoeSize shoeSize) {
        this.shoeSize = shoeSize;
    }

    /**
     * @return the photo
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * @param photo the photo to set
     */
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    /**
     * @return the profession
     */
    public Profession getProfession() {
        return profession;
    }

    /**
     * @param profession the profession to set
     */
    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    /**
     * @return the highestEducationLevel
     */
    public HighestEducationLevel getHighestEducationLevel() {
        return highestEducationLevel;
    }

    /**
     * @param highestEducationLevel the highestEducationLevel to set
     */
    public void setHighestEducationLevel(HighestEducationLevel highestEducationLevel) {
        this.highestEducationLevel = highestEducationLevel;
    }

    /**
     * @return the university
     */
    public String getUniversity() {
        return university;
    }

    /**
     * @param university the university to set
     */
    public void setUniversity(String university) {
        this.university = university;
    }

    /**
     * @return the fieldOfProfession
     */
    public String getFieldOfProfession() {
        return fieldOfProfession;
    }

    /**
     * @param fieldOfProfession the fieldOfProfession to set
     */
    public void setFieldOfProfession(String fieldOfProfession) {
        this.fieldOfProfession = fieldOfProfession;
    }

    /**
     * @return the professionalCareer
     */
    public String getProfessionalCareer() {
        return professionalCareer;
    }

    /**
     * @param professionalCareer the professionalCareer to set
     */
    public void setProfessionalCareer(String professionalCareer) {
        this.professionalCareer = professionalCareer;
    }

    /**
     * @return the motherTongue
     */
    public Language getMotherTongue() {
        return motherTongue;
    }

    /**
     * @param motherTongue the motherTongue to set
     */
    public void setMotherTongue(Language motherTongue) {
        this.motherTongue = motherTongue;
    }

    /**
     * @return the additionalLanguages
     */
    public List<VolunteerLanguageSkill> getAdditionalLanguages() {
        return additionalLanguages;
    }

    /**
     * @param additionalLanguages the additionalLanguages to set
     */
    public void setAdditionalLanguages(List<VolunteerLanguageSkill> additionalLanguages) {
        this.additionalLanguages = additionalLanguages;
    }

    /**
     * @return the interpretingLanguages
     */
    public String getInterpretingLanguages() {
        return interpretingLanguages;
    }

    /**
     * @param interpretingLanguages the interpretingLanguages to set
     */
    public void setInterpretingLanguages(String interpretingLanguages) {
        this.interpretingLanguages = interpretingLanguages;
    }

    /**
     * @return the translatingLanguages
     */
    public String getTranslatingLanguages() {
        return translatingLanguages;
    }

    /**
     * @param translatingLanguages the translatingLanguages to set
     */
    public void setTranslatingLanguages(String translatingLanguages) {
        this.translatingLanguages = translatingLanguages;
    }

    /**
     * @return the msOfficeSkill
     */
    public ITMediaSkill getMsOfficeSkill() {
        return msOfficeSkill;
    }

    /**
     * @param msOfficeSkill the msOfficeSkill to set
     */
    public void setMsOfficeSkill(ITMediaSkill msOfficeSkill) {
        this.msOfficeSkill = msOfficeSkill;
    }

    /**
     * @return the itNetworkSkill
     */
    public ITMediaSkill getItNetworkSkill() {
        return itNetworkSkill;
    }

    /**
     * @param itNetworkSkill the itNetworkSkill to set
     */
    public void setItNetworkSkill(ITMediaSkill itNetworkSkill) {
        this.itNetworkSkill = itNetworkSkill;
    }

    /**
     * @return the contentManagementSkill
     */
    public ITMediaSkill getContentManagementSkill() {
        return contentManagementSkill;
    }

    /**
     * @param contentManagementSkill the contentManagementSkill to set
     */
    public void setContentManagementSkill(ITMediaSkill contentManagementSkill) {
        this.contentManagementSkill = contentManagementSkill;
    }

    /**
     * @return the graphicSkill
     */
    public ITMediaSkill getGraphicSkill() {
        return graphicSkill;
    }

    /**
     * @param graphicSkill the graphicSkill to set
     */
    public void setGraphicSkill(ITMediaSkill graphicSkill) {
        this.graphicSkill = graphicSkill;
    }

    /**
     * @return the furtherQualifications
     */
    public String getFurtherQualifications() {
        return furtherQualifications;
    }

    /**
     * @param furtherQualifications the furtherQualifications to set
     */
    public void setFurtherQualifications(String furtherQualifications) {
        this.furtherQualifications = furtherQualifications;
    }

    /**
     * @return the eventsParticipated
     */
    public String getEventsParticipated() {
        return eventsParticipated;
    }

    /**
     * @param eventsParticipated the eventsParticipated to set
     */
    public void setEventsParticipated(String eventsParticipated) {
        this.eventsParticipated = eventsParticipated;
    }

    /**
     * @return the interestedICG2016
     */
    public boolean isInterestedICG2016() {
        return interestedICG2016;
    }

    /**
     * @param interestedICG2016 the interestedICG2016 to set
     */
    public void setInterestedICG2016(boolean interestedICG2016) {
        this.interestedICG2016 = interestedICG2016;
    }

    /**
     * @return the interestedSkiing
     */
    public boolean isInterestedSkiing() {
        return interestedSkiing;
    }

    /**
     * @param interestedSkiing the interestedSkiing to set
     */
    public void setInterestedSkiing(boolean interestedSkiing) {
        this.interestedSkiing = interestedSkiing;
    }

    /**
     * @return the interestedSnowboarding
     */
    public boolean isInterestedSnowboarding() {
        return interestedSnowboarding;
    }

    /**
     * @param interestedSnowboarding the interestedSnowboarding to set
     */
    public void setInterestedSnowboarding(boolean interestedSnowboarding) {
        this.interestedSnowboarding = interestedSnowboarding;
    }

    /**
     * @return the interestedCrossCountrySkiing
     */
    public boolean isInterestedCrossCountrySkiing() {
        return interestedCrossCountrySkiing;
    }

    /**
     * @param interestedCrossCountrySkiing the interestedCrossCountrySkiing to
     * set
     */
    public void setInterestedCrossCountrySkiing(boolean interestedCrossCountrySkiing) {
        this.interestedCrossCountrySkiing = interestedCrossCountrySkiing;
    }

    /**
     * @return the interestedBiathlon
     */
    public boolean isInterestedBiathlon() {
        return interestedBiathlon;
    }

    /**
     * @param interestedBiathlon the interestedBiathlon to set
     */
    public void setInterestedBiathlon(boolean interestedBiathlon) {
        this.interestedBiathlon = interestedBiathlon;
    }

    /**
     * @return the interestedIceSkating
     */
    public boolean isInterestedIceSkating() {
        return interestedIceSkating;
    }

    /**
     * @param interestedIceSkating the interestedIceSkating to set
     */
    public void setInterestedIceSkating(boolean interestedIceSkating) {
        this.interestedIceSkating = interestedIceSkating;
    }

    /**
     * @return the interestedIceHockey
     */
    public boolean isInterestedIceHockey() {
        return interestedIceHockey;
    }

    /**
     * @param interestedIceHockey the interestedIceHockey to set
     */
    public void setInterestedIceHockey(boolean interestedIceHockey) {
        this.interestedIceHockey = interestedIceHockey;
    }

    /**
     * @return the areaInterest1
     */
    public AreaOfInterest getAreaInterest1() {
        return areaInterest1;
    }

    /**
     * @param areaInterest1 the areaInterest1 to set
     */
    public void setAreaInterest1(AreaOfInterest areaInterest1) {
        this.areaInterest1 = areaInterest1;
    }

    /**
     * @return the areaInterest2
     */
    public AreaOfInterest getAreaInterest2() {
        return areaInterest2;
    }

    /**
     * @param areaInterest2 the areaInterest2 to set
     */
    public void setAreaInterest2(AreaOfInterest areaInterest2) {
        this.areaInterest2 = areaInterest2;
    }

    /**
     * @return the areaInterest3
     */
    public AreaOfInterest getAreaInterest3() {
        return areaInterest3;
    }

    /**
     * @param areaInterest3 the areaInterest3 to set
     */
    public void setAreaInterest3(AreaOfInterest areaInterest3) {
        this.areaInterest3 = areaInterest3;
    }

    /**
     * @return the availabilityBeginning
     */
    public Date getAvailabilityBeginning() {
        return availabilityBeginning;
    }

    /**
     * @param availabilityBeginning the availabilityBeginning to set
     */
    public void setAvailabilityBeginning(Date availabilityBeginning) {
        this.availabilityBeginning = availabilityBeginning;
    }

    /**
     * @return the availabilityEnd
     */
    public Date getAvailabilityEnd() {
        return availabilityEnd;
    }

    /**
     * @param availabilityEnd the availabilityEnd to set
     */
    public void setAvailabilityEnd(Date availabilityEnd) {
        this.availabilityEnd = availabilityEnd;
    }

    /**
     * @return the interestedICG2016PriorToBeginning
     */
    public boolean isInterestedICG2016PriorToBeginning() {
        return interestedICG2016PriorToBeginning;
    }

    /**
     * @param interestedICG2016PriorToBeginning the
     * interestedICG2016PriorToBeginning to set
     */
    public void setInterestedICG2016PriorToBeginning(boolean interestedICG2016PriorToBeginning) {
        this.interestedICG2016PriorToBeginning = interestedICG2016PriorToBeginning;
    }

    /**
     * @return the icg2016Comment
     */
    public String getIcg2016Comment() {
        return icg2016Comment;
    }

    /**
     * @param icg2016Comment the icg2016Comment to set
     */
    public void setIcg2016Comment(String icg2016Comment) {
        this.icg2016Comment = icg2016Comment;
    }

    /**
     * @return the languageSkillsProfessional
     */
    public String getLanguageSkillsProfessional() {
        return languageSkillsProfessional;
    }

    /**
     * @param languageSkillsProfessional the languageSkillsProfessional to set
     */
    public void setLanguageSkillsProfessional(String languageSkillsProfessional) {
        this.languageSkillsProfessional = languageSkillsProfessional;
    }

    /**
     * @return the trainingSkillsProfessional
     */
    public String getTrainingSkillsProfessional() {
        return trainingSkillsProfessional;
    }

    /**
     * @param trainingSkillsProfessional the trainingSkillsProfessional to set
     */
    public void setTrainingSkillsProfessional(String trainingSkillsProfessional) {
        this.trainingSkillsProfessional = trainingSkillsProfessional;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * @return the surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @param surname the surname to set
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * @return the prename
     */
    public String getPrename() {
        return prename;
    }

    /**
     * @param prename the prename to set
     */
    public void setPrename(String prename) {
        this.prename = prename;
    }

    /**
     * @return the sex
     */
    public Gender getSex() {
        return sex;
    }

    /**
     * @param sex the sex to set
     */
    public void setSex(Gender sex) {
        this.sex = sex;
    }

    /**
     * @return the nationality
     */
    public Country getNationality() {
        return nationality;
    }

    /**
     * @param nationality the nationality to set
     */
    public void setNationality(Country nationality) {
        this.nationality = nationality;
    }

    /**
     * @return the birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * @param birthday the birthday to set
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

}
