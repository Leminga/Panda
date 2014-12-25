package models;

import java.util.Date;

import javax.persistence.Entity;

import play.db.ebean.Model;
import javax.persistence.ManyToOne;

@Entity
public class LoginTime extends Model {
	
	/** The serialization version identifier. */
	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Date login;

	public Date getLogin() {
		return login;
	}

	public void setLogin(Date login) {
		this.login = login;
	}
		
		
}
