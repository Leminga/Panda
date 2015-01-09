package controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import models.EmailAddress;
import models.UserLogin;
import models.volunteer.Volunteer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import play.data.validation.Constraints;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;
import play.mvc.Security;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import controllers.SecurityController.RegisterForm;

public class VolunteerController extends Controller {

	/** Logger to log VolunteerController events. */
	private static Logger LOGGER = LoggerFactory
			.getLogger(VolunteerController.class);
	/** The authentication token header for the Play framework. */
	protected final static String AUTH_TOKEN_HEADER = "X-AUTH-TOKEN";
	/** The authentication token for the Play framework. */
	protected static final String AUTH_TOKEN = "authToken";

	
	
	// Test Dummy für Frontend Backend Test
	//@Security.Authenticated(Secured.class)
	public static Result dummyData (){
    	
    	ObjectNode userin = Json.newObject();
    	userin.put("prename","hans");
		userin.put("surname", "wurst");
		userin.put("emailAddress", "hans.wurst@metzgerei.at");
		userin.put("gender", "male");
		userin.put("dateOfBirth", "12/01/1998");
		userin.put("nationality", "austria");
		userin.put("socialSecurityNumber", "3589125814");
		
		ObjectNode userout = Json.newObject();
		userout.put("user", userin);
         
		return Results.ok(userout);
    	
    }
	
public static Result userDataTest (){
	
		//token test für user aktuellen
		UserLogin user = UserLogin.findByAuthToken("437f1e06-5f53-4545-8dec-c3fb25e6b88e");
		LOGGER.info(" username is: " + user);

		Volunteer volunteer = new Volunteer(null, null, user.getUsername(),	null);

		volunteer.setLoginData(user);

		ObjectNode loginJson = Json.newObject();
		loginJson.put("prename", volunteer.getPrename());
		loginJson.put("surname", volunteer.getSurname());
		//loginJson.put("emailAddress", volunteer.getEmailAddress().toString());
		//loginJson.put("gender", volunteer.getSex().toString());
		//loginJson.put("dateofBirth",parseDatetoString(volunteer.getDateOfBirth()));
		loginJson.put("nationality", volunteer.getNationality());
		loginJson.put("socialSecurityNumber",
		volunteer.getSocialSecurityNumber());

		
		return Results.ok(loginJson);
    	
    }

@Security.Authenticated(Secured.class)
	public static Result userRequest() {
	
			String authHeader = request().getHeader("X-AUTH-TOKEN");
			UserLogin user = UserLogin.findByAuthToken(authHeader);
			
			LOGGER.info(" username is: " + user);

			
			//Test Objekt
			Volunteer volunteer = new Volunteer(null, null, user.getUsername(),	null);

			volunteer.setLoginData(user);
			

				ObjectNode loginJson = Json.newObject();
				loginJson.put("prename", volunteer.getPrename());
				loginJson.put("surname", volunteer.getSurname());
				loginJson.put("emailAddress", volunteer.getEmailAddress()
						.toString());
				loginJson.put("gender", volunteer.getSex().toString());
				loginJson.put("dateofBirth",
						parseDatetoString(volunteer.getDateOfBirth()));
				loginJson.put("nationality", volunteer.getNationality());
				loginJson.put("socialSecurityNumber",
						volunteer.getSocialSecurityNumber());

				LOGGER.info(" userRequest successfully by : "
						+ volunteer.getPrename() + " " + volunteer.getSurname());
				return ok(loginJson);
				
				
	}

	public static Result saveAll() {
		// The CoreData JSon input.
		JsonNode json = request().body().asJson();

		if (json == null) {

			LOGGER.debug("JSon expected!");
			return badRequest("Expecting Json data");

		} else {
			String prename = json.findPath("prename").textValue();
			String surname = json.findPath("surname").textValue();
			String emailAddress = json.findPath("emailAddress").textValue();
			String nationality = json.findPath("nationality").textValue();

			Volunteer volunteer = new Volunteer(prename, surname, emailAddress,
					nationality);
			volunteer.setPrename(prename);
			volunteer.setSurname(surname);

			EmailAddress address = new EmailAddress(emailAddress);
			volunteer.setEmailAddress(address);

			// wenn sprachen knowledge other entspricht - kenntniss-stand null
			// setzen

			if (prename != null) {
				return badRequest("Missing parameter [name]");
			} else {

				try {
					volunteer.save();

					return Results.ok();

				} catch (Exception e) {
					// Make sure to clean up the database if something went
					// wrong.
					volunteer.delete();
					return Results.ok("volunteer saving failed");

				}

			}

		}
	}

	public static Date parseStringToDate(String input) {
		try {
			DateFormat sourceFormat = new SimpleDateFormat("dd/MM/yyyy");
			String dateAsString = input;
			Date date = sourceFormat.parse(dateAsString);
			LOGGER.info("Parse String to Date.");

			return date;
		} catch (Exception e) {
			LOGGER.debug("Parsing StringtoDate not successfully - Exception: "
					+ e);
			return null;

		}
	}

	public static String parseDatetoString(Date input) {
		try {
			DateFormat sourceFormat = new SimpleDateFormat("dd/MM/yyyy");
			String dateAsString = sourceFormat.format(input);
			LOGGER.info("Parse Date to String.");

			return dateAsString;
		} catch (Exception e) {
			LOGGER.debug("Parsing DatetoString not successfully - Exception: "
					+ e);
			return null;

		}
	}

	/**
	 * Maps the coredata form fields to a register object.
	 * 
	 * @author Manuel Dorfer
	 */
	public static class CoreDataForm extends RegisterForm {
		/**
		 * Core Data inherit from RegisterForm - prename, surname, password and
		 * e-mail.
		 */

		/**
		 * The gender. AngularJS calls Form gender - not sex
		 */
		@Constraints.Required
		public String gender;
		/** The date of birth of the person. */
		@Constraints.Required
		public String dateOfBirth;
		/** The (multiple) nationalities of the person. */
		@Constraints.Required
		// @ManyToMany(cascade = CascadeType.ALL)
		public String nationality;
		@Constraints.Required
		public String socialSecurityNumber;
		@Constraints.Required
		public String city;
		@Constraints.Required
		public String country;
		@Constraints.Required
		public String houseNumber;
		@Constraints.Required
		public String street;
		@Constraints.Required
		public String zip;
		@Constraints.Required
		public String phoneNumber;
		@Constraints.Required
		public String emailAddress;
		@Constraints.Required
		public String preferredCommunicationLanguage;

		@Constraints.Required
		public String em_email;
		@Constraints.Required
		public String em_phonenumber;
		@Constraints.Required
		public String em_prename;
		@Constraints.Required
		public String em_relation;
		@Constraints.Required
		public String em_surname;

	}
}
