package com.revature.Service;

import java.util.List;

import com.revature.data.UserDAO;
import com.revature.model.ReimbReq;
import com.revature.model.Users;


public class ERSService {
	static UserDAO dao = new UserDAO();
	
	public  Users logIn(String username, String password) {
					
		int returnValue= 0;
		Users u = dao.getByUsername(username);
		if(u == null) {
			returnValue= -1; //no user by username
			u = new Users();
		}
		else {
			if(u.getPassword().equals(password)) {
				if(u.getURole().getRoleID()==3)
				{
					returnValue= 3;//emp
				}
				else
				{
					returnValue= 4;//manager
				}
				
			}
			else {
				returnValue= -2; //password does not match 
			}
		}
		
		
		u.setValue(returnValue);
		
		return u;
	}
	
	public List<Users> GetUsers() {
		List<Users> u = dao.getUsers();
		return u;
	}
   
	public List<ReimbReq> GetRequestsByUser(int UserID)
	{
		List<ReimbReq> _requests = dao.GetRequestsByUser(UserID);
				
		return _requests;
	}
	
	public List<ReimbReq> GetRequestsByManager(int UserID)
	{
		List<ReimbReq> _requests = dao.GetRequestsByManager(UserID);
				
		return _requests;
	}
	
	public void UpdateRequestByManager(int ReqID,int StatusID)  
	{
		dao.UpdateRequestByManager(ReqID,StatusID);
	}
	
	public int AddRequest(ReimbReq req)
	{
		return dao.AddRequest(req);
	}
	
}