package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.Service.ERSService;
import com.revature.model.ReimbReq;

@WebServlet("/elistReqs")
public class ERequest extends HttpServlet {
	       
	static ERSService service = new ERSService();   
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ObjectMapper mapper = new ObjectMapper();
		
		HttpSession session=request.getSession();  
		int id =(int)session.getAttribute("uid");
		
		
		List<ReimbReq> _req = service.GetRequestsByUser(id);
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
}
