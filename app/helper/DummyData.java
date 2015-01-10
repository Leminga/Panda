package helper;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlUpdate;

import models.Translation;
import models.UserLogin;
import models.humans.Human;
import models.volunteer.Volunteer;

public class DummyData {
	
	public static void start() {
		DummyData.createVolunteers();
		DummyData.createSex(); 
	}

	private static String getMD5(String msg) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			//return new String(md.digest(msg.getBytes()));
			return msg;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Create a dummy volunteer and put
	 * him into the database.
	 */
	private static void createVolunteers() {
		UserLogin dummyUser = new UserLogin("dummy@panda.at", DummyData.getMD5("panda123"));
		Volunteer dummyVolunteer = new Volunteer("dummy", "panda", "dummy@panda.at","Austria");
		
		dummyVolunteer.setUserLogin(dummyUser);
		dummyVolunteer.setDateOfBirth(new Date("12/03/1993"));
		dummyVolunteer.save();
		
		
		dummyUser.setVolunteer(dummyVolunteer);
		dummyUser.save();
		
	}
	
	/**
	 * Speichert das Geschlecht in Deutsch und Englisch in der Translation Tabelle in der Datenbank
	 */
	private static void createSex(){
		Translation sex1 = new Translation("maennlich","male");
		Translation sex2 = new Translation("weiblich","female");
		
		sex1.setTranslation(sex1);
		sex1.save();
		sex2.setTranslation(sex2);
		sex2.save();
	}
}
