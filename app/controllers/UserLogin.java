package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.Id;

import models.EventDataVolunteer;

import org.apache.commons.mail.EmailException;
import mailer.mail;
import models.Volunteer;
import com.avaje.ebean.Ebean;
import com.fasterxml.jackson.databind.JsonNode;
import play.libs.Json;
import play.mvc.*;


public class UserLogin extends Controller {

	@BodyParser.Of(BodyParser.Json.class)
	public static Result save() throws EmailException {
		//JsonNode body = request().body().asJson();
		//Volunteer v = new Volunteer(body.get("username").toString(),body.get("user.password").toString());
		//Ebean.save(v);
		 
		//List<Volunteer> vs = new ArrayList<Volunteer>();
		//Volunteer  v1 = new Volunteer(session().get("username"),session().get("password"));
		//v1.setUsername("Berni");
		//v1.setPassword("123456");
		//vs.add(v1);
		//Volunteer  v2 = new Volunteer(session().get("username"),session().get("password"));
		//v2.setUsername("Lessi");
		//v2.setPassword("2365");
		//vs.add(v2);
		//Ebean.save(v1);
		
		//mail.sendMail();
		return ok("2ez");
	}

	public static Result load() {
		
		List<EventDataVolunteer> vl = new ArrayList<EventDataVolunteer>();
		vl = EventDataVolunteer.find.all();
		return ok(Json.toJson(vl));
		
		//Volunteer  v1 = new Volunteer(session().get("name"),session().get("password"));
		//v1.setUsername("Berni");
		//v1.setPassword("123456");
		//vs.add(v1);
		//Volunteer  v2 = new Volunteer(session().get("name"),session().get("password"));
		//v2.setUsername("Lessi");
		//v2.setPassword("2365");
		//vs.add(v2);
		
				

		//Map<String,String> itWorks = new HashMap<String,String>(); 
    	//itWorks.put("username","Berni");
    	//itWorks.put("password","123456");
    	//itWorks.put("username","Berni");
    	//itWorks.put("password","123456");
    	//itWorks.put("username","Bei");
    	//itWorks.put("password","123456");
        //return ok(play.libs.Json.toJson(itWorks));
	}	
	 
}

