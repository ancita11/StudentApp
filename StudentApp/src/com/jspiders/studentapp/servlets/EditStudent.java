package com.jspiders.studentapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspiders.studentapp.beans.StudentBean;
import com.jspiders.studentapp.database.StudentDB;

@WebServlet("/EditStudent")
public class EditStudent extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int regno=Integer.parseInt(request.getParameter("regno"));
		String name=request.getParameter("name");
	 	String email=request.getParameter("email");
		String gender=request.getParameter("gender");
		String course=request.getParameter("course");
		Double fee=Double.parseDouble(request.getParameter("fee"));
		Double paid=Double.parseDouble(request.getParameter("paid"));
		Double due=Double.parseDouble(request.getParameter("due"));
		String address=request.getParameter("address");
		String contact=request.getParameter("contact");
		
		StudentBean bean=new StudentBean(regno,name, email, gender, course, fee, paid, due, address, contact);
		
		int status = StudentDB.update(bean);
		response.sendRedirect("ViewStudent");
		
		out.close();
	}

}
