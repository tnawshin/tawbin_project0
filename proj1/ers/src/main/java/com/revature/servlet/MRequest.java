package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.Service.ERSService;
import com.revature.model.ReimbReq;

@WebServlet("/mlistReqs")
public class MRequest extends HttpServlet {
	static ERSService service = new ERSService();   
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		
		String mode = request.getParameter("mode");
		int statusID = 0, requestID = 0;
		
			
		if(request.getParameter("statusID")!=null)
			statusID =Integer.parseInt(request.getParameter("statusID"));
		
		if(request.getParameter("reqID")!=null)
		requestID =Integer.parseInt(request.getParameter("reqID"));
		
		if(mode=="" || mode == null) //loading all requests by manager id
		{
			ObjectMapper mapper = new ObjectMapper();
			
			HttpSession session=request.getSession();  
			int id =(int)session.getAttribute("uid");
			
			
			List<ReimbReq> _req = service.GetRequestsByManager(id);
			if(_req == null) {
				resp.setStatus(400);
			}
			else {
				resp.setStatus(201); //CREATED
				resp.setContentType("application/json");
				PrintWriter writer = resp.getWriter();
				writer.write(mapper.writeValueAsString(_req));
			}
		}
		else 
		{
			//passing mode and request id for approve or deny
			service.UpdateRequestByManager(requestID, statusID);
				
		}
		
			
		
	}

}
