package org.auzmor.web.vo;

/**
 * @author mankri
 * 
 * User POJO for User data transfer
 *
 */
public class User {
	
	private int id;
	private String fName;
	private String lName;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}

}
