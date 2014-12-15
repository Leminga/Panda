package models;


import play.db.ebean.Model.Finder;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import play.db.ebean.Model;
import play.libs.Json;
import play.data.validation.Constraints.Required;
import java.util.Date;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Email extends Model {
	
	/** The serialization version identifier. */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Required
	@GeneratedValue
	private long id;
	@Required
	private String subject;
	@Required
	private String content;
	@Required
	private byte[] attachement;
	@ManyToOne
	private long emailTId;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public byte[] getAttachement() {
		return attachement;
	}
	public void setAttachement(byte[] attachement) {
		this.attachement = attachement;
	}
	public long getEmailTId() {
		return emailTId;
	}
	public void setEmailTId(long emailTId) {
		this.emailTId = emailTId;
	}

}
