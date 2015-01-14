package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import play.data.validation.Constraints.Required;

@Entity
public class Permission {

	@Id
	@Required
	@GeneratedValue
	private long id;
	
	@Required
	//@OneToMany(cascade = CascadeType.ALL)
	private List<Integer> permission;

	public List<Integer> getPermission() {
		return permission;
	}

	public void setPermission(List<Integer> permission) {
		this.permission = permission;
	}
}
