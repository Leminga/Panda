package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Id;

import models.EventDataVolunteer;

import com.avaje.ebean.Ebean;
import com.fasterxml.jackson.databind.JsonNode;





import jdk.nashorn.internal.ir.ObjectNode;
import play.*;
import play.db.ebean.Model.Finder;
import play.libs.Json;
import play.mvc.*;
import play.mvc.Http.RequestBody;


public class UserLogin extends Controller {

	@BodyParser.Of(BodyParser.Json.class)
	public static Result save() {
		JsonNode body = request().body().asJson();		  
		EventDataVolunteer v = new EventDataVolunteer(body.get("name").toString(),body.get("password").toString());		
		Ebean.save(v);
		
		 
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

