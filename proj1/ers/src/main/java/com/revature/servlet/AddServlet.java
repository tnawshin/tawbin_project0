package com.revature.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.Service.ERSService;
import com.revature.model.ReimbReq;


@WebServlet("/addReq")
public class AddServlet extends HttpServlet {
	static ERSService service = new ERSService();   
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ObjectMapper mapper = new ObjectMapper();
		
		//Create an object of ReimbReq
		ReimbReq _reqNew = mapper.readValue(request.getInputStream(), ReimbReq.class);
		
		int statusID = 0, typeID = 0,authorID=0,resolver = 0;
		String desc="";
		double amount= 0.0;
		
			typeID =_reqNew.getTypeID();
			desc =_reqNew.getDescription();
			amount =_reqNew.getAmount();
		
		HttpSession session=request.getSession();  
		authorID =(int)session.getAttribute("uid");
			 
		resolver =30;
		
		//ReimbReq _requesto = new ReimbReq(reqID, amount, subDate, resolveDate, description, reciept, author, resolver, status, type, authorID, resolverID, statusID, typeID)
		ReimbReq _requesto = new ReimbReq(0, amount, null, null, desc, null, null, null, null, null, authorID, resolver, statusID, typeID);
		
		int retValue = service.AddRequest(_requesto);
		
		if(retValue==0)
		{
			resp.setStatus(200);
		}
		else
		{
			resp.setStatus(400);
		}
		
		
		
		
			
		
	}

}
