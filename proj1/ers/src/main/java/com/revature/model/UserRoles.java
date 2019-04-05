package com.revature.model;

public class UserRoles {


	private int RoleID;
	private String Role;
	public UserRoles(int roleID, String role) {
		super();
		RoleID = roleID;
		Role = role;
	}
	public int getRoleID() {
		return RoleID;
	}
	public void setRoleID(int roleID) {
		RoleID = roleID;
	}
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
	
	
	
}
