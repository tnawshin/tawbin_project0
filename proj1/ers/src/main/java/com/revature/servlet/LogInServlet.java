package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.Service.ERSService;
import com.revature.model.Users;


public class LogInServlet extends HttpServlet {
	
	static ERSService service = new ERSService();	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//request.getRequestDispatcher("partials/login.html").forward(request, response);
		//PrintWriter writer = response.getWriter();
    	//writer.write("Login"); 
		ObjectMapper mapper = new ObjectMapper();
		Users inputUser = mapper.readValue(request.getInputStream(), Users.class);
		String username = inputUser.getUName();
		String password = inputUser.getPassword();
		
		
		PrintWriter writer = response.getWriter(); //initialize printwriter
		HttpSession session=request.getSession();  //initialize session
        
		Users userCode = service.logIn(username, password);
		
		if(userCode.getValue() ==-1)
		{
			response.setStatus(200); //CREATED
			response.setContentType("application/text");
			 
		}
		if(userCode.getValue()==-2)
		{
			response.setStatus(200); //CREATED
			response.setContentType("application/text");
			 
		}
		if(userCode.getValue()==3 ||userCode.getValue()==4 )
		{
			
			session.setAttribute("uid",userCode.getUserID());
			session.setAttribute("name",userCode.getFName());
			session.setAttribute("roleid",userCode.getURole().getRoleID());
			
			//resource = "/ers/ERequest.view";
			//request.getRequestDispatcher(resource).forward(request, response);
			//response.sendRedirect(resource);
			//writer.write("Welcome Employee"); 
		}
		response.setStatus(200);
		response.setContentType("application/text");
		writer.write(userCode.getValue()+"");
				
	}
}
