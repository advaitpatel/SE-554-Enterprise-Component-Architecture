/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.project.ecampusconnect.sessionbeans;

import javax.servlet.http.HttpServlet;

/**
 *
 * @author Advait
 */

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "/CourseCountClient", urlPatterns = {"/CourseCountClient"})
public class CourseCountClient extends HttpServlet
{
    private static final long serialVersionUID = 1L;

	@EJB
	CourseCountBean courseCount;
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Welcome to the Course Catalogt</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Resetting Page Course Count ... </h1>");
			courseCount.resetCounter();
			out.println("<h1>Incrementing Page Course Count ... </h1>");
			courseCount.incrementCourseCount();
			out.println("<h1>Page Count: " + courseCount.getCourseCount() + "</h1>");
			out.println("</body>");
			out.println("</html>");
		} finally {
			out.close();
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	@Override
	public String getServletInfo() {
		return "Short description";
	}
    
}
