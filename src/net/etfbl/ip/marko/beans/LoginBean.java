package net.etfbl.ip.marko.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import net.etfbl.ip.marko.dao.LoginDAO;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1273339461352698650L;
	
	private int numberOfOnlineUsers;
	
	
	
	public LoginBean() {
		super();
	}
	
	public int getNumberOfOnlineUsers() {
		return new LoginDAO().getNumberOfOnlineUsers();
	}

	public void setNumberOfOnlineUsers(int numberOfOnlineUsers) {
		this.numberOfOnlineUsers = numberOfOnlineUsers;
	}

}