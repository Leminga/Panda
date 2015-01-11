package controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import models.EmailAddress;
import models.UserLogin;
import models.volunteer.Volunteer;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
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

	// Test Dummy für Frontend Backend Test mit passender Json Struktur
	// @Security.Authenticated(Secured.class)
	/**
	 * @return
	 * @throws JSONException
	 */

	public static Result dummyData() throws JSONException {

		// Neue Label bezeichnungen in der jeweiligen Sprache - Dummy default ->
		// deutsch
		ObjectNode labels = Json.newObject();
		labels.put("prename", "Vorname:");
		labels.put("surname", "Nachname:");
		labels.put("emailAddress", "Deine E.Mail Adresse:");
		labels.put("gender", "Geschlecht");

		// Test Json für Befüllung der Geschlechter Dropdowns - jeweils mit
		// Value (der setzt und speichert) und passender Description - ISSET ob
		// gewählt ist
		JSONObject test = new JSONObject();
		test.put("Value", "2");
		test.put("Description", "Female");
		test.put("ISSET", "1");

		// Test Json 2 selbe Funktion wie test
		JSONObject test2 = new JSONObject();
		test2.put("Value", "1");
		test2.put("Description", "Male");
		test2.put("ISSET", "0");

		// Neues Json Objekt für User Daten
		ObjectNode user = Json.newObject();
		user.put("prename", "hans");
		user.put("surname", "wurst");
		user.put("emailAddress", "hans.wurst@metzgerei.at");
		user.put("gender", "männlich");
		user.put("dateOfBirth", "12/01/1998");
		user.put("nationality", "austria");
		user.put("socialSecurityNumber", "3589125814");
		user.put("profilePicture", AdminController.dummyPicture());

		// JSONArray enthält die Gender Ausprägungen
		JSONArray gender = new JSONArray();
		gender.put(test2);
		gender.put(test);

		// Json welches die passenden gruppen beinhaltet
		ObjectNode values = Json.newObject();
		values.put("gender", gender.toString());
		values.put("nationality", "JSON FOLLOWING");

		// Gesammeltes JsonObject aller Ausgaben
		JSONObject mainObj = new JSONObject();
		mainObj.put("values", values);
		mainObj.put("labels", labels);
		mainObj.put("user", user);
		mainObj.put("volunteers", AdminController.dummyDataAdmin());

		ObjectNode jsonReturn = Json.newObject();
		jsonReturn.put("values", values);
		jsonReturn.put("labels", labels);
		jsonReturn.put("user", user);
		jsonReturn.put("volunteers", AdminController.dummyDataAdmin());
		
		return Results.ok(jsonReturn);
	}

	public static ObjectNode languageDummy(int preferred) {

		// Sprachtest -> angenommen Spracheinstellung ist Deutsch für
		// Geschlecht(Sex) -> soll dann im Dropdown angezeigt werden

		if (preferred == 1) {
			ObjectNode innerDummyGER = Json.newObject();
			innerDummyGER.put("1", "männlich");
			innerDummyGER.put("2", "weiblich");
			return innerDummyGER;

		}

		else {
			ObjectNode innerDummyENG = Json.newObject();
			innerDummyENG.put("1", "male");
			innerDummyENG.put("2", "female");
			return innerDummyENG;
		}

	}

	@Security.Authenticated(Secured.class)
	public static Result userRequest() {

		/*
		 * //Abfrage ob admin oder nicht if (admin){ //Wenn Admin dann sollen
		 * alle Volunteers mitgegeben werden AdminController.dummyDataAdmin(); }
		 */

		String authHeader = request().getHeader("X-AUTH-TOKEN");
		UserLogin user = UserLogin.findByAuthToken(authHeader);

		LOGGER.info(" username is: " + user);

		// Test Objekt
		Volunteer volunteer = new Volunteer(null, null, user.getUsername(),
				null);

		volunteer.setLoginData(user);

		ObjectNode loginJson = Json.newObject();
		loginJson.put("prename", volunteer.getPrename());
		loginJson.put("surname", volunteer.getSurname());
		loginJson.put("emailAddress", volunteer.getEmailAddress().toString());
		loginJson.put("gender", volunteer.getSex().toString());
		// loginJson.put("dateofBirth",
		// parseDatetoString(volunteer.getDateOfBirth()));
		loginJson.put("nationality", volunteer.getNationality());
		loginJson.put("socialSecurityNumber",
				volunteer.getSocialSecurityNumber());

		LOGGER.info(" userRequest successfully by : " + volunteer.getPrename()
				+ " " + volunteer.getSurname());
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

	// Methode für das parsen von String zu Date -- Gehört eigentlich ins Model
	// funktioniert so noch nicht da von Date zu Date in anderes Format
	// "geparst" gehört"
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

	// Methode um DB Zugang zu testen - mit Json ausgabe
	public static Result dataBaseTest() {

		Volunteer test = new Volunteer("sepp", "huber", "s.huber@bauer.at",
				"austria");

		JsonNode user = test.toJson();

		return ok(user);

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
