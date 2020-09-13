package net.etfbl.ip.marko.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import net.etfbl.ip.marko.dao.UserDAO;
import net.etfbl.ip.marko.dto.User;

@ManagedBean
@ViewScoped
public class UserBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8366586646308610350L;
	
	private transient ListDataModel data = new ListDataModel<>();
	
	
	private User selected;
	private int numberOfRegisteredUsers;
	
	public UserBean() {
		super();
		List<User>users = new UserDAO().getAllUsers();
		numberOfRegisteredUsers = users.size();
		this.data.setWrappedData(users);
	}
	

	public User getSelected() {
		return selected;
	}

	public void setSelected(User user) {
		this.selected = user;
	}

	public int getNumberOfRegisteredUsers() {
		return numberOfRegisteredUsers;
	}

	public void setNumberOfRegisteredUsers(int numberOfRegisteredUsers) {
		this.numberOfRegisteredUsers = numberOfRegisteredUsers;
	}
	
	public void resetPassword() {
		int leftLimit = 48; //  '0'
	    int rightLimit = 122; // 'z'
	    int targetStringLength = 10;
	    Random random = new Random();
	 
	    String generatedString = random.ints(leftLimit, rightLimit + 1)
	      .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
	      .limit(targetStringLength)
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString();
	    
	    System.out.println(generatedString);	    
	    this.selected = (User)data.getRowData();
	    System.out.println(selected.getFirstName());
	    new UserDAO().resetPassword(selected.getId(), generatedString);
	    
	    
	}


	public ListDataModel getData() {
		return data;
	}


	public void setData(ListDataModel data) {
		this.data = data;
	}
	
}
