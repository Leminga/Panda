package controllers;

import com.avaje.ebean.Ebean;
import java.io.IOException;

import forms.VolunteerForm;
import helper.FileType;
import helper.JSONHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import play.data.Form;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.Results;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Date;
import models.User;
import models.fixed.Gender;
import models.human.Volunteer;

/**
 * @author manuel
 *
 * DummyController nur für internes Testen verwendet Enthält dummy daten für die
 * Frontend/Backend Kommunikation
 *
 */
public class DummyController {

    /**
     * Logger to log VolunteerController events.
     */
    private static Logger LOGGER = LoggerFactory
            .getLogger(DummyController.class);
    /**
     * The authentication token header for the Play framework.
     */
    protected final static String AUTH_TOKEN_HEADER = "X-AUTH-TOKEN";
    /**
     * The authentication token for the Play framework.
     */
    protected static final String AUTH_TOKEN = "authToken";

    // Test Dummy für Frontend Backend Test mit passender Json Struktur
    // @Security.Authenticated(Secured.class)
    /**
     * @return @throws JSONException
     */
    public static Result newDummyJson() throws JSONException {
        User u = new User("", "");
        Volunteer volunteer = new Volunteer(u, "hans", "wurst", Ebean.find(Gender.class, 1), null, new Date(System.currentTimeMillis()));

        LOGGER.info("Volunteer dummy added");

        String pic = null;
        FileHandler.savePicture("5", "Manuel", "Dorfer", "icg", DummyController.dummyPicture());
        try {
            pic = FileHandler.getPicture("5", "Manuel", "Dorfer", "icg", FileType.PICTURE);
            LOGGER.info(pic);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        ObjectNode json = Json.newObject();
        json.put("volunteer", JSONHelper.objectToJsonAndPlot(volunteer));
        json.put("picture", pic);

        return Results.ok(json);

    }

//    public static Result saveDummyPicture() {
//
////        Form<VolunteerForm> form = Form.form(VolunteerForm.class).bindFromRequest();
////
////        // Check the form itself for errors.
////        if (form.hasErrors()) {
////            //return Results.badRequest(form.errorsAsJson());
////        }
////
////        // Get the login information from the login form.
////        VolunteerForm cdf = form.get();
////
////        //Deletes the first 20 characters from the BASE String
////        String pic = cdf.profilePicture.trim().substring(20);
////
//////        FileHandler.savePicture(cdf.vid, cdf.prename, cdf.surname, "ICG", pic);
////        //FileHandler.savePicture("1", "hans", "wurst", "ICG", dummyPicture());
////        return Results.ok("Picture saved");
//
//    }

//    public static String getDummyPicture(Volunteer volunteer) throws IOException {
//
////        return FileHandler.getPicture(String.valueOf(volunteer.getId()), volunteer.getPrename(), volunteer.getSurname(), "ICG", helper.FileType.PICTURE);
//
//    }

    public static Result getAdminDummyPicture() throws IOException {
//		Form<CoreDataForm> form = Form.form(VolunteerForm.class).bindFromRequest();
//    	
//    	// Check the form itself for errors.
//        if (form.hasErrors()) {
//            //return Results.badRequest(form.errorsAsJson());
//        }
//        
//        // Get the login information from the login form.
//        VolunteerForm cdf = form.get();

        //ObjectNode pictures = Json.newObject();
        //pictures.put("picture", FileHandler.getPicture(cdf.vid, cdf.prename, cdf.surname, "ICG", helper.FileType.PICTURE));
        //pictures.put("thumbnail", FileHandler.getPicture(cdf.vid, cdf.prename, cdf.surname, "ICG", helper.FileType.THUMBNAIL));
        return Results.ok();
    }

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
        test.put("value", "2");
        test.put("description", "Female");
        test.put("isSet", "1");

        // Test Json 2 selbe Funktion wie test
        JSONObject test2 = new JSONObject();
        test2.put("value", "1");
        test2.put("description", "Male");
        test2.put("isSet", "0");

        // Neues Json Objekt für User Daten
        ObjectNode user = Json.newObject();
        user.put("prename", "hans");
        user.put("surname", "wurst");
        user.put("emailAddress", "hans.wurst@metzgerei.at");
        user.put("gender", "männlich");
        user.put("dateOfBirth", "12/01/1998");
        user.put("nationality", "austria");
        user.put("socialSecurityNumber", "3589125814");
        user.put("profilePicture", dummyPicture());

        // JSONArray enthält die Gender Ausprägungen
        JSONArray gender = new JSONArray();
        gender.put(test2);
        gender.put(test);

        // Json welches die passenden gruppen beinhaltet
        ObjectNode values = Json.newObject();
        values.put("gender", gender.toString());	// Frontend benötigt Array nicht als String 
        values.put("nationality", "JSON FOLLOWING");

        // Gesammeltes ObjectNode aller Ausgaben
        ObjectNode jsonReturn = Json.newObject();
        jsonReturn.put("values", values);
        jsonReturn.put("labels", labels);
        jsonReturn.put("user", user);
        jsonReturn.put("volunteers", dummyDataAdmin());

        //JSON werden per hand 
        //JSONHelper.objectToJsonAndPlot();
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

        } else {
            ObjectNode innerDummyENG = Json.newObject();
            innerDummyENG.put("1", "male");
            innerDummyENG.put("2", "female");
            return innerDummyENG;
        }

    }

    // Test Dummy für Frontend Backend Test
    // Aufgerufen in VolunteerController wenn Admin bestätigt - und für Dummy
    //@Security.Authenticated(Secured.class)
    public static ObjectNode dummyDataAdmin() throws JSONException {

        //Object input for Nationality Array
        JSONObject nationalityInput = new JSONObject();
        nationalityInput.put("Value", "2");
        nationalityInput.put("Description", "Austria");
        nationalityInput.put("ISSET", "1");

        //Object input for Nationality Array
        JSONObject nationalityInput2 = new JSONObject();
        nationalityInput2.put("Value", "1");
        nationalityInput2.put("Description", "Germany");
        nationalityInput2.put("ISSET", "0");

        //Nationality-Array for Volunteer  
        JSONArray nationality = new JSONArray();
        nationality.put(nationalityInput);
        nationality.put(nationalityInput2);

        //Object input for itKnowledge Array
        JSONObject iTimport1 = new JSONObject();
        iTimport1.put("Value", "2");
        iTimport1.put("Description", "MS Office");
        iTimport1.put("ISSET", "1");

        //Object input for itKnowledge Array
        JSONObject itImport2 = new JSONObject();
        itImport2.put("Value", "1");
        itImport2.put("Description", "Photoshop");
        itImport2.put("ISSET", "0");

        //Object input for itKnowledge Array
        JSONObject itImport3 = new JSONObject();
        itImport3.put("Value", "3");
        itImport3.put("Description", "Linux Mint");
        itImport3.put("ISSET", "0");

        //Object input for itKnowledge Array
        JSONObject itImport4 = new JSONObject();
        itImport4.put("Value", "4");
        itImport4.put("Description", "Netzwerke");
        itImport4.put("ISSET", "0");

        //Object input for itKnowledge Array
        JSONArray itKnowledge = new JSONArray();
        itKnowledge.put(iTimport1);
        itKnowledge.put(itImport2);
        itKnowledge.put(itImport3);
        itKnowledge.put(itImport4);

        // Dummy Volunteer Object
        ObjectNode volunteer1 = Json.newObject();
        volunteer1.put("ID", "3254879");
        volunteer1.put("prename", "hans");
        volunteer1.put("surname", "wurst");
        volunteer1.put("emailAddress", "hans.wurst@metzgerei.at");
        volunteer1.put("profilePicture", dummyPicture());
        volunteer1.put("zip", "5020");
        volunteer1.put("city", "salzburg");
        volunteer1.put("phoneNumber", "0900666666");
        volunteer1.put("currentWork", "Metzger");
        volunteer1.put("motherTongue", "Deutsch");
        volunteer1.put("itKnowledge", itKnowledge.toString());
        volunteer1.put("nationality", nationality.toString());

        // Dummy Volunteer Object
        ObjectNode volunteer2 = Json.newObject();
        volunteer2.put("ID", "123456789");
        volunteer2.put("prename", "johann:");
        volunteer2.put("surname", "hinterseer:");
        volunteer2.put("emailAddress", "hansi.hinterseer@singer.at");
        volunteer2.put("profilePicture", dummyPicture());
        volunteer2.put("zip", "6615");
        volunteer2.put("city", "Kitzbühel");
        volunteer2.put("phoneNumber", "0900333666");
        volunteer2.put("currentWork", "Metzger");
        volunteer2.put("motherTongue", "Deutsch");
        volunteer2.put("itKnowledge", itKnowledge.toString());
        volunteer2.put("nationality", nationality.toString());

        //Object with "all" dummy Objects 
        ObjectNode jsonReturn = Json.newObject();
        jsonReturn.put("volunteer1", volunteer2);
        jsonReturn.put("volunteer2", volunteer1);

        //returns Object Node - e.g. for VOlunteerController 
        return jsonReturn;
    }

    //Methode um String Code für DummyBIld zu speichern
    public static String dummyPicture() {
        //data:image/png;base64,
        String test = "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";

        return test;
    }

}
