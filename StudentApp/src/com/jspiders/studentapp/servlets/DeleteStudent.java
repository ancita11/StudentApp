package com.jspiders.studentapp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspiders.studentapp.database.StudentDB;

@WebServlet("/DeleteStudent")
public class DeleteStudent extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sregno=request.getParameter("regno");
		int regno=Integer.parseInt(sregno);
		StudentDB.delete(regno);
		response.sendRedirect("ViewStudent");
	}
	
}
