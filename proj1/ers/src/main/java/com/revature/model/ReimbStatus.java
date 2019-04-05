package com.revature.model;

public class ReimbStatus {
	
	private int StatusID;
	private String Status;
	public ReimbStatus(int statusID, String status) {
		super();
		StatusID = statusID;
		Status = status;
	}
	public int getStatusID() {
		return StatusID;
	}
	public void setStatusID(int statusID) {
		StatusID = statusID;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	
	

}
