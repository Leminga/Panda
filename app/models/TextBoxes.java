package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import play.data.validation.Constraints.Required;

@Entity
public class TextBoxes {
	@Required
	@Id
	@GeneratedValue
	private long id;
	private String career;
	private String otherQualification;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCareer() {
		return career;
	}
	public void setCareer(String career) {
		this.career = career;
	}
	public String getOtherQualification() {
		return otherQualification;
	}
	public void setOtherQualification(String otherQualification) {
		this.otherQualification = otherQualification;
	}
		
}
