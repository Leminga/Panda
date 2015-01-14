package connections;

import play.mvc.Result;
import play.mvc.Results;
import models.volunteer.Volunteer;


public class VolunteerConnection {
	
	public static Result saveVolunteer(Volunteer volunteer){
		
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
