package helper;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlUpdate;

import models.Sex;
import models.Translation;
import models.UserLogin;
import models.humans.Human;
import models.volunteer.Volunteer;

public class DummyData {
	
	public static void start() {
		DummyData.createVolunteers();
		//DummyData.createSex(); 
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
		
		/*
		 * legt einen DummyVolunteer an mit den DummyUser Logindaten
		 */
		dummyVolunteer.setUserLogin(dummyUser);
		
		dummyUser.setVolunteer(dummyVolunteer);
		dummyUser.save();
		
		/*
		 * speichert den Geburtstag des DummyVolunteers
		 */
		dummyVolunteer.setDateOfBirth(new Date("12/03/1993"));
		dummyVolunteer.save();
		
		
		/*
		 * speichert die Übersetzungen für das Geschlecht in der Translation Tabelle
		 */
		Translation sex1 = new Translation("maennlich","male");
		Translation sex2 = new Translation("weiblich","female");
		
		sex1.save();
		sex2.save();
		
		/*
		 * Primärschlüssel der Translation Tabelle verweist auf Fremdschlüssel in Sex Tabelle
		 */
		Sex abc = new Sex(sex1.getTid());
		Sex abc2 = new Sex(sex2.getTid());
		
		abc.setTranslation(sex1);
		abc.save();
		abc2.setTranslation(sex2);
		abc2.save();
		
		/*
		 * Geschlecht des DummyVolunteers
		 */
		dummyVolunteer.setSex(abc);
		dummyVolunteer.save();
		
		
	}
}
