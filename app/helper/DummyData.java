package helper;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import models.Sex;
import models.Translation;
import models.UserLogin;
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
		UserLogin dummyUser = new UserLogin("dummy@panda.at", DummyData.getMD5("panda1"));
		Volunteer dummyVolunteer = new Volunteer("dummy", "panda", "dummy@panda.at","Austria");
		
		UserLogin dummyUser2 = new UserLogin("dummy2@panda.at", DummyData.getMD5("panda2"));
		Volunteer dummyVolunteer2 = new Volunteer("dummy2", "panda", "dummy2@panda.at","Austria");
		
		UserLogin dummyUser3 = new UserLogin("dummy3@panda.at", DummyData.getMD5("panda3"));
		Volunteer dummyVolunteer3 = new Volunteer("dummy3", "panda", "dummy3@panda.at","Austria");
		
		UserLogin dummyUser4 = new UserLogin("dummy4@panda.at", DummyData.getMD5("panda4"));
		Volunteer dummyVolunteer4 = new Volunteer("dummy4", "panda", "dummy4@panda.at","Austria");
		
		UserLogin dummyUser5 = new UserLogin("dummy5@panda.at", DummyData.getMD5("panda5"));
		Volunteer dummyVolunteer5 = new Volunteer("dummy5", "panda", "dummy5@panda.at","Austria");
		/*
		 * legt einen DummyVolunteer an mit den DummyUser Logindaten
		 */
		dummyVolunteer.setUserLogin(dummyUser);
		dummyUser.setVolunteer(dummyVolunteer);
		dummyUser.save();
		
		dummyVolunteer2.setUserLogin(dummyUser2);
		dummyUser2.setVolunteer(dummyVolunteer2);
		dummyUser2.save();
		
		dummyVolunteer3.setUserLogin(dummyUser3);
		dummyUser3.setVolunteer(dummyVolunteer3);
		dummyUser3.save();
		
		dummyVolunteer4.setUserLogin(dummyUser4);
		dummyUser4.setVolunteer(dummyVolunteer4);
		dummyUser4.save();
		
		dummyVolunteer5.setUserLogin(dummyUser5);
		dummyUser5.setVolunteer(dummyVolunteer5);
		dummyUser5.save();
		/*
		 * speichert den Geburtstag des DummyVolunteers
		 */
		dummyVolunteer.setDateOfBirth(new Date("12/03/1993"));
		dummyVolunteer2.setDateOfBirth(new Date("11/03/1993"));
		dummyVolunteer3.setDateOfBirth(new Date("10/03/1993"));
		dummyVolunteer4.setDateOfBirth(new Date("09/03/1993"));
		dummyVolunteer5.setDateOfBirth(new Date("08/03/1993"));
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
		dummyVolunteer2.setSex(abc);
		dummyVolunteer3.setSex(abc2);
		dummyVolunteer4.setSex(abc);
		dummyVolunteer5.setSex(abc2);
		
		dummyVolunteer.save();
		dummyVolunteer2.save();
		dummyVolunteer3.save();
		dummyVolunteer4.save();
		dummyVolunteer5.save();
		
	}
}
