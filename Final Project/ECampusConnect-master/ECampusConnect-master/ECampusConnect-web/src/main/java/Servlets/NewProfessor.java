/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Advait
 */
public class NewProfessor extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String i = request.getParameter("id");
        String n = request.getParameter("name");
        String e = request.getParameter("email");
        String d = request.getParameter("department");
        String u = request.getParameter("username");
        String p = request.getParameter("password");

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/SE554DB",
                    "APP", "APP");

            PreparedStatement ps = con.prepareStatement(
                    "insert into INSTRUCTOR (ID, DEPARTMENT, EMAIL, NAME, PASSWORD, USERNAME) values(?,?,?,?,?,?)");

            ps.setString(1, i);
            ps.setString(2, d);
            ps.setString(3, e);
            ps.setString(4, n);
            ps.setString(5, p);
            ps.setString(6, u);
            

            int ii = ps.executeUpdate();
            if (ii > 0) {
                out.print("You have successfully created acount for " + n);
                
                out.println("<a href='admin_dashboard.jsp'>Go to Dashboard</a>");
            }

        } catch (Exception e2) {
            System.out.println(e2);
        }

        out.close();

    }
}
