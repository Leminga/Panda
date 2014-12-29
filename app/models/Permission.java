package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.data.validation.Constraints.Required;

@Entity
public class Permission {

	@Required
	@OneToMany(cascade = CascadeType.ALL)
	private int permission;

	public int getPermission() {
		return permission;
	}

	public void setPermission(int permission) {
		this.permission = permission;
	}
	
	
	
}
