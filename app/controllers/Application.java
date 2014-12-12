package controllers;

//import org.specs2.json.Json;

import play.mvc.*;
import views.html.*;

public class Application extends Controller {

    public static Result index() {

    	//Ok(Json.toJson(names)).as(JSON)
        //return ok(index.render(".ady"));
        return ok("Hello World");
    }

}
