package net.etfbl.ip.marko.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.apache.catalina.manager.util.SessionUtils;

import net.etfbl.ip.marko.dao.AdminDAO;
import net.etfbl.ip.marko.dto.Admin;

@ManagedBean
@SessionScoped
public class AdminBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6073214935137892761L;

	private Admin admin = new Admin();
	
	public AdminBean() {
		super();
	}
	
	public String login() {
		String retVal = "invalid";
		if(new AdminDAO().getAdminByUsernamePassword(admin.getUsername(), admin.getPassword()) != null) {
			retVal = "success";
		}
		return retVal;
	}
	
	public String logout() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
		session.invalidate();
		return "index";
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
}
