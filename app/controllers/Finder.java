package controllers;

import java.util.HashMap;
import java.util.Map;

import models.User;

/**
 * A temporary helper class that mimics the
 * user database. It stores users with a
 * username, email address, and password.
 * 
 * @author Michael Bredel <michael.bredel@fh-kufstein.ac.at>
 */
public class Finder {
	
	/** Singleton object. */
	private static Finder finder;
	
	/** Map that stores the users: email -> user. */
	private static Map<String, User> users = new HashMap<String, User>();
	
	/**
	 * Default constructor that adds two demo users to the
	 * virtual database. Private constructor to implement a 
	 * singleton pattern.
	 */
	private Finder() {
		User user1 = new User("michael.bredel@fh-kufstein.ac.at", "password", "Michael Bredel");
		users.put(user1.getEmailAddress(), user1);
		User user2 = new User("demo@fh-kufstein.ac.at", "password", "Demo User");
		users.put(user2.getEmailAddress(), user2);
	}
	
	/**
	 * Getter for the singleton instance of the Finder.
	 * 
	 * @return <b>Finder</b> The singleton finder.
	 */
	public static synchronized Finder getInstance() {
		if (Finder.finder == null)
			Finder.finder = new Finder();
		return Finder.finder;
	}
	
	/**
	 * Searches the virtual database for a given user. Returns the
	 * user object, if and only if the password is correct. Thus
	 * it also verifies the user. 
	 * 
	 * @param emailAddress The email address that identifies the user.
	 * @param password The password of the user.
	 * @return <b>User</b> The user and all its data.
	 */
	public User find(String emailAddress, String password) {
		User user = Finder.users.get(emailAddress);
		
		if (user != null && user.getPassword().equals(password)) {
			return user;
		} else {
			return null;
		}
	}
	
	/**
	 * Searches the virtual database for a given user. Returns the
	 * user object, if a valid authentication token was found.
	 * 
	 * @param authToken A authentication token provided by an URL.
	 * @return <b>User</b> The user and all its data.
	 */
	public User find(String authToken) {
		for (Map.Entry<String, User> entry : Finder.users.entrySet()) {
			if (entry.getValue().getToken() == authToken) {
				return entry.getValue();
			}
		}
		return null;
	}

}
