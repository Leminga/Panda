package helper;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import models.UserLogin;
import models.volunteer.Volunteer;

/**
 * Initializes the Panda application and
 * puts some default values to the database.
 * 
 * @author Michael Bredel <michael.bredel@fh-kufstein.ac.at>
 */
public class Starter {
	
	public static void start() {
		Starter.createUsers();
		Starter.createVolunteers();
	}
	
	/**
	 * Creates an MD5 hash from a String.
	 * 
	 * @param msg The string that should be hashed.
	 * @return <b>String</b> The hashed string.
	 */
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
	 * Create some dummy users and put
	 * them into the database
	 */
	private static void createUsers() {
		UserLogin admin = new UserLogin("admin@admin.at", Starter.getMD5("admin"));
		UserLogin userB = new UserLogin("test@test.at", Starter.getMD5("password"));
		
		admin.save();
		userB.save();
	}
	
	/**
	 * Create a dummy volunteer and put
	 * him into the database.
	 */
	private static void createVolunteers() {
		UserLogin userA = new UserLogin("demo@user.at", Starter.getMD5("password"));
		Volunteer volunteerA = new Volunteer("demo", "user", "Demo@Demo.com","Austria");
		volunteerA.setUserLogin(userA);
		
		userA.save();
		volunteerA.save();
	}

}
