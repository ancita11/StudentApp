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

@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String name=request.getParameter("name");
	 	String email=request.getParameter("email");
		String gender=request.getParameter("gender");
		String course=request.getParameter("course");
		int fee=Integer.parseInt(request.getParameter("fee"));
		int paid=Integer.parseInt(request.getParameter("paid"));
		int due=Integer.parseInt(request.getParameter("due"));
		String address=request.getParameter("address");
		String contact=request.getParameter("contact");
		
		StudentBean bean=new StudentBean(name, email, gender, course, fee, paid, due, address, contact);
		int status=StudentDB.save(bean);
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Add Student</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("<link rel='stylesheet' href='style.css'/>");
		out.println("</head>");
		out.println("<body>");
		request.getRequestDispatcher("NavAccountant.html").include(request, response);
		out.println("<div class='container'>");
		
		out.println("Student is added successfully!");
		
		request.getRequestDispatcher("AddStudentForm.html").include(request, response);
		out.println("</div>");
		request.getRequestDispatcher("Footer.html").include(request, response);
		out.println("</body>");
		out.println("</html>");
		
		out.close();
	}

}
