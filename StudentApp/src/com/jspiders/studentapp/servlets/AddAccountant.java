package com.jspiders.studentapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspiders.studentapp.beans.AccountantBean;
import com.jspiders.studentapp.database.AccountantDB;

@WebServlet("/AddAccountant")
public class AddAccountant extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
 		resp.setContentType("text/html");
 		PrintWriter out=resp.getWriter();
 		
 		out.println("<!DOCTYPE html>");
 		out.println("<html>");
 		out.println("<head>");
 		out.println("<title>Accountant Added</title>");
 		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
 		out.println("<link rel='stylesheet' href='style.css'/>");
 		out.println("</head>");
 		out.println("<body>");
 		req.getRequestDispatcher("NavAdmin.html").include(req, resp);
 		
 		out.println("<div class='container'>");
 		
 		String name=req.getParameter("name");
 	 	String email=req.getParameter("email");
 		String password=req.getParameter("password");
 		String address=req.getParameter("address");
 		String contact=req.getParameter("contact");
 		
 		AccountantBean bean = new AccountantBean(name, email, password, address, contact);
 		int status = AccountantDB.save(bean);
 		
 		out.print("<h1>Add Accountant Form</h1>");
 		out.println("<p>Accountant is added successfully!</p>");
 		req.getRequestDispatcher("AddAccountantForm.html").include(req, resp);
 		
 		out.println("</div>");
 		req.getRequestDispatcher("Footer.html").include(req, resp);
 		out.println("</body>");
 		out.println("</html>");
 		
 		out.close();
 	}
 
}
