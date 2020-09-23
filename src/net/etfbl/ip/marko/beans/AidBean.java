package net.etfbl.ip.marko.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import net.etfbl.ip.marko.dao.AidDAO;
import net.etfbl.ip.marko.dto.Aid;

@ManagedBean(name = "aidBean")
@SessionScoped
public class AidBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6823474459531375322L;
	
	private Aid aid;
	private List<Aid> aids;
	
	public AidBean() {
		super();
		aids = new AidDAO().getAllAids();
		aid = new Aid();
	}

	public Aid getAid() {
		return aid;
	}

	public void setAid(Aid aid) {
		this.aid = aid;
	}

	public List<Aid> getAids() {
		return aids;
	}

	public void setAids(List<Aid> aids) {
		this.aids = aids;
	}
	
	public void deleteAid() {
		
	}
	
	

}
