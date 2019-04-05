package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;


@WebServlet("*.view")
public class LoadingServlet extends HttpServlet{
	private static Logger log = Logger.getLogger(LoadingServlet.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {

		log.info(req.getRequestURI());
		
		String uri = req.getRequestURI();
		
		String resource = getResource(uri);
		
		req.getRequestDispatcher(resource).forward(req, resp);
	}

	 
	private String getResource(String uri) {
		String resource = "/Partials/";
		switch(uri) {
		case "/ers/login.view" : 
			resource+="Login.html";
			break;

		case "/ers/index.view" :
			resource+="index.html";
			break;
			
		case "/ers/ERequest.view" :
			resource+="ERequest.html";
			break;
			
			
		case "/ers/MRequest.view" :
			resource+="MRequest.html";
			break;
			
		case "/ers/Reimbursement.view" :
			resource+="Reimbursement.html";
			break;
		case "/ers/Header.view" :
			resource+="Header.html";
			break;
		case "/ers/AddRequest.view" :
			resource+="AddRequest.html";
			break;
		}
		return resource;
	}
}