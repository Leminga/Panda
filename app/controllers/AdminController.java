package controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import play.libs.Json;
import play.mvc.Controller;

import com.fasterxml.jackson.databind.node.ObjectNode;

public class AdminController extends Controller {

	/** Logger to log VolunteerController events. */
	private static Logger LOGGER = LoggerFactory
			.getLogger(AdminController.class);
	/** The authentication token header for the Play framework. */
	protected final static String AUTH_TOKEN_HEADER = "X-AUTH-TOKEN";
	/** The authentication token for the Play framework. */
	protected static final String AUTH_TOKEN = "authToken";

	
	
	// Test Dummy für Frontend Backend Test
	// Aufgerufen in VolunteerController wenn Admin bestätigt - und für Dummy
	//@Security.Authenticated(Secured.class)
	public static ObjectNode dummyDataAdmin (){
    	
    	ObjectNode volunteer1 = Json.newObject();
    	volunteer1.put("prename","hans");
		volunteer1.put("surname", "wurst");
		volunteer1.put("emailAddress", "hans.wurst@metzgerei.at");
		volunteer1.put("profilePicture", dummyPicture());

         
    	ObjectNode volunteer2 = Json.newObject();
    	volunteer2.put("prename","johann:");
		volunteer2.put("surname", "hinterseer:");
		volunteer2.put("emailAddress", "hansi.hinterseer@singer.at");
		volunteer2.put("profilePicture", dummyPicture());

		ObjectNode jsonReturn = Json.newObject();
		jsonReturn.put("volunteer1", volunteer2);
		jsonReturn.put("volunteer2", volunteer1);

		return jsonReturn;  	
    }
	
	//Methode um langen String Code für DummyBIld zu spreichern
	public static String dummyPicture(){
		
		return "";
	}
}
