package models.humans;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;

import models.Degree;
import models.Nationality;
import models.Sex;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

/**
 * Contains all the attributes that are related
 * to a human user. Basic class for users, volunteers,
 * athletes, delegates, etc.
 * 
 * @author Michael Bredel <michael.bredel@fh-kufstein.ac.at>
 */
@MappedSuperclass
public abstract class Human extends Model {
	/** The serialization version identifier. */
	private static final long serialVersionUID = 1L;
	/** The database id. */
	@Id
	@Required
	@GeneratedValue
	private long id;
	/** The surname of the person. */
	@Required
	private String surname;
	/** The name of the person. */
	@Required
	private String name;
	/** The gender. */
	@Required
	private Sex sex;
	/** The date of birth of the person. */
	@Required
	public Date dateOfBirth;
	/** The (multiple) nationalities of the person. */
	@Required
	@ManyToMany(cascade = CascadeType.ALL)
	public List <Nationality>nationality;
	/** The (multiple) degrees of the person. */
	@ManyToMany(cascade = CascadeType.ALL)
	public List <Degree>degree;
	
	/**
	 * Getter for the database id.
	 * 
	 * @return <b>long</b>The database id.
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * Getter for the surname.
	 * 
	 * @return <b>String</b> The surname.
	 */
	public String getSurname() {
		return surname;
	}
	
	/**
	 * Setter for the surname.
	 * 
	 * @param surname The surname.
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	/**
	 * Getter for the name.
	 * 
	 * @return <b>String</b>The name.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Setter for the name.
	 * 
	 * @param name The name.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Getter for the gender.
	 * 
	 * @return <b>Sex</b>The gender of the person.
	 */
	public Sex getSex() {
		return sex;
	}
	
	/**
	 * Setter for the gender.
	 * 
	 * @param sex The gender of the person.
	 */
	public void setSex(Sex sex) {
		this.sex = sex;
	}
	
	/**
	 * Getter for the date of birth.
	 * 
	 * @return <b>Data</b>The date of birth.
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	
	/**
	 * Setter of the date of birth.
	 * 
	 * @param dateOfBirth The date of birth.
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	/**
	 * Getter for the list of degrees.
	 * 
	 * @return <b>List of Degree</b>The list of degrees.
	 */
	public List<Degree> getDegree() {
		return degree;
	}
	
	/**
	 * Setter for the list of degrees.
	 * 
	 * @param degree The list of degrees.
	 */
	public void setDegree(List<Degree> degree) {
		this.degree = degree;
	}
	
	/**
	 * Adds a nationality to the person.
	 * 
	 * @param nationality An additional nationality
	 */
	public void addNationality(Nationality nationality) {
		if (!this.nationality.contains(nationality))
			this.nationality.add(nationality);
	}
	
	/**
	 * Removes a nationality from the person.
	 * 
	 * @param nationality The nationality of the person to be removed.
	 */
	public void removeNationality(Nationality nationality) {
		if (this.nationality.contains(nationality))
			this.nationality.remove(nationality);
	}
	
	/**
	 * Adds a degree to a person.
	 * 
	 * @param degree The new degree of the person.
	 */
	public void addDegree(Degree degree) {
		if (!this.degree.contains(degree))
			this.degree.remove(degree);
	}
	
	/**
	 * Removes a degree from a person.
	 * 
	 * @param degree The degree of the person to be removed.
	 */
	public void removeDegree(Degree degree) {
		if (this.degree.contains(degree))
			this.degree.remove(degree);
	}
}
