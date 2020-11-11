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

@WebServlet("/SearchStudent")
public class SearchStudent extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String sregno=request.getParameter("regno");
		int regno=Integer.parseInt(sregno);
		StudentBean bean=StudentDB.getRecordByRegno(regno);
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Search Student</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("<link rel='stylesheet' href='style.css'/>");
		out.println("</head>");
		out.println("<body>");
		request.getRequestDispatcher("NavAccountant.html").include(request, response);
		out.println("<div class='container'>");
		
	
		out.println("<h1>Search Student</h1>");
		
		if(bean.getRegno()>0){
		out.println("<table class='table table-bordered table-striped'>");
		out.print("<tr><td>RegNo:</td><td>"+bean.getRegno()+"</td></tr>");
		out.print("<tr><td>Name:</td><td>"+bean.getName()+"</td></tr>");
		out.print("<tr><td>Email:</td><td>"+bean.getEmail()+"</td></tr>");
		out.print("<tr><td>Gender:</td><td>"+bean.getGender()+"</td></tr>");
		out.print("<tr><td>Course:</td><td>"+bean.getCourse()+"</td></tr>");
		out.print("<tr><td>Fee:</td><td>"+bean.getFee()+"</td></tr>");
		out.print("</table>");
		}else{
			out.println("<p>Sorry, No Record found for "+regno+"</p>");
		}
		
		out.println("</div>");
		request.getRequestDispatcher("Footer.html").include(request, response);
		out.println("</body>");
		out.println("</html>");
		
		out.close();
	}
}
