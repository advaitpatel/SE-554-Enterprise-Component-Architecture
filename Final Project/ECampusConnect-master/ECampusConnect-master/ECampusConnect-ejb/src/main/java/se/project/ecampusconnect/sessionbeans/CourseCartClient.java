/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.project.ecampusconnect.sessionbeans;

/**
 *
 * @author Advait
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "/CourseCartClient", urlPatterns = {"/CourseCartClient"})
public class CourseCartClient extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    
	@EJB
	CourseCartBean courseCart;
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Add Courses from here</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Adding Courses</h1>");
			courseCart.addCourse("CSC 695");
			out.println("<h1>Printing Courses </h1>");
			ArrayList<String> cartItems = courseCart.getCartItems();
			for (String course : cartItems) {
				out.println("<h1>" + course + "</h1>");
			}
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
