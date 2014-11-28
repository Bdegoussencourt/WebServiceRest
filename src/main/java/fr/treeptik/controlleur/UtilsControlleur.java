package fr.treeptik.controlleur;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import fr.treeptik.utils.SessionBean;

@ManagedBean
@RequestScoped
public class UtilsControlleur {

	@EJB
	private SessionBean sessionBean;

	public String logout() {
		return sessionBean.logout();
	}

	public boolean isUserRole() {
		return sessionBean.isOnRoleUser();
	}

	public boolean isAdminRole() {
		return sessionBean.isOnRoleAdmin();
	}

	public String userName() {
		return sessionBean.getUserName();
	}

	public boolean isloged() {
		return sessionBean.isloged();
	}
}
