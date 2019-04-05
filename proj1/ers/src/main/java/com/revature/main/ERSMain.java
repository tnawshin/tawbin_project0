package com.revature.main;

import java.io.IOException;
import java.util.List;

import com.revature.Service.ERSService;
import com.revature.model.ReimbReq;
import com.revature.model.UserRoles;
import com.revature.model.Users;

public class ERSMain {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		 System.out.println("HELLO ERS SYSTEM");
		 
		 ERSService service = new ERSService();
		 
		 /*for(Users u: service.GetUsers())
		 {
			 System.out.println("---USERS---");
			 System.out.println(u.getFName());
			 System.out.println(u.getLName());
			 System.out.println(u.getUName());
			 System.out.println(u.getURole().getRoleID());
			 System.out.println(u.getURole().getRole());
			 
		 }
		 */
		 
		 /*Users u = service.logIn("TAWBIN", "password123");
		 System.out.println(u.getUName());
		 
		 List<ReimbReq> req = service.GetRequestsByUser(27);
		 
		 for(ReimbReq r: req)
		 {
			 System.out.println("---USERS---");
			 System.out.println(r.getDescription());
			 System.out.println(r.getAmount());
			 System.out.println(r.getResolveDate());
			 System.out.println(r.getResolver());
			 System.out.println(r.getStatus());
			 System.out.println(r.getType());
			 
			 
		 }
		 
		 */
		 
		 		 
		 List<ReimbReq> req = service.GetRequestsByManager(30);
		 
		 for(ReimbReq r: req)
		 {
			 System.out.println("---USERS---");
			 System.out.println(r.getDescription());
			 System.out.println(r.getAmount());
			 System.out.println(r.getResolveDate());
			 System.out.println(r.getAuthor());
			 System.out.println(r.getStatus());
			 System.out.println(r.getType());
			 
			 
		 }
		 
	}

}
