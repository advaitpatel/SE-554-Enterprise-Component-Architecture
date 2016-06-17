/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.project.ecampusconnect.sessionbeans;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Advait
 */

@WebServlet(name = "/SearchFacadeCourse", urlPatterns = {"/SearchFacadeCourse"})
public class SearchFacadeCourse extends HttpServlet
{
    private static final long serialVersionUID = 1L;
       
	@EJB
	SearchFacadeBean searchFacade;
	
	@EJB
	CourseCountBean courseCount;
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			out.write("<html>");
			out.write("<head>");
			out.write("<title>Servlet Search Course For Client</title>");
			out.write("</head>");
			out.write("<body>");
			out.println("<h1>Starting Courses from DB ... </h1>");
			out.println("<h1>SearchFacade Lookup</h1>");
			out.println("<h1>Searching courses</h1>");
			List<String> courseList = searchFacade.courseSearch("Grad");
			out.println("<h1>Printing Courses List</h1>");
			for(String course : courseList) {
				out.println("<h1>" + course + "</h1>");
			}
			
			out.println("Printing Page count after incrementing it...");
			courseCount.incrementCourseCount();
			out.println("<h1>" + courseCount.getCourseCount() + "</h1>");
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
