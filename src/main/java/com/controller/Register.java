package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.dao.RegisterDao;
import com.model.RegisterModel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		//Model
		RegisterModel user= new RegisterModel();
		

		
		String name= request.getParameter("name");
		String email= request.getParameter("email");
		String password= request.getParameter("password");
		String confirm= request.getParameter("confirm");
		String tel= request.getParameter("tel");
		
		
//		Validating the Password by Confirm password
		if(password.equals(confirm)) {
	
			user.setName(name);
			user.setEmail(email);
			user.setPassword(password);
			user.setTel(tel);
	
//			Forwarding to DAO Layer
			RegisterDao registerDao = new RegisterDao();
			boolean status =registerDao.insertUser(user);
			
			
			if(status) {
			response.sendRedirect("home.html");
			
			}
			else {
				out.println("<h1>Failed to Register...!</h1>");
			}
			
			
		}else {
			
			response.sendRedirect("register.html");
		}
		
		
		
	}

}
