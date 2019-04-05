package com.revature.model;

public class Users {
	

	private int UserID;
	private String UName;
	private String Password;
	private String FName;
	private String LName;
	private String Email;
	private UserRoles URole;
	private int returnValue = 0;
	
	public Users() {}
	
	public Users(int userID, String uName, String password, String fName, String lName, String email, UserRoles uRole) {
		super();
		UserID = userID;
		UName = uName;
		Password = password;
		FName = fName;
		LName = lName;
		Email = email;
		URole = uRole;
	}
	
	public int getUserID() {
		return UserID;
	}



	public void setUserID(int userID) {
		UserID = userID;
	}
	
	public int getValue() {
		return returnValue;
	}



	public void setValue(int v) {
		returnValue = v;
	}



	public String getUName() {
		return UName;
	}



	public void setUName(String uName) {
		UName = uName;
	}



	public String getPassword() {
		return Password;
	}



	public void setPassword(String password) {
		Password = password;
	}



	public String getFName() {
		return FName;
	}



	public void setFName(String fName) {
		FName = fName;
	}



	public String getLName() {
		return LName;
	}



	public void setLName(String lName) {
		LName = lName;
	}



	public String getEmail() {
		return Email;
	}



	public void setEmail(String email) {
		Email = email;
	}



	public UserRoles getURole() {
		return URole;
	}



	public void setURole(UserRoles uRole) {
		URole = uRole;
	}



	
	



}
