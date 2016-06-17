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
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Advait
 */
public class ViewCourses extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        //String name = request.getParameter("uname");

        out.println("==========================================================================");
        out.println("<h1>ONLINE COURSES</h1>");

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/SE554DB",
                    "APP", "APP");
            PreparedStatement ps = con.prepareStatement("select * from ONLINECOURSE");
            ResultSet rs = ps.executeQuery();
            /* Printing column names */
            ResultSetMetaData rsmd = rs.getMetaData();
            while (rs.next()) {
                out.print("<table width=25% border=1 align='center'>");
                out.print("<center><h1>Result:</h1></center>");
                out.print("<tr>");
                out.print("<td>" + rsmd.getColumnName(1) + "</td>");
                out.print("<td>" + rs.getString(1) + "</td></tr>");
                out.print("<tr><td>" + rsmd.getColumnName(2) + "</td>");
                out.print("<td>" + rs.getString(2) + "</td></tr>");
                out.print("<tr><td>" + rsmd.getColumnName(3) + "</td>");
                out.print("<td>" + rs.getString(3) + "</td></tr>");
                out.print("<tr><td>" + rsmd.getColumnName(4) + "</td>");
                out.print("<td>" + rs.getString(4) + "</td></tr>");
                out.print("<tr><td>" + rsmd.getColumnName(5) + "</td>");
                out.print("<td>" + rs.getString(5) + "</td></tr>");

                out.print("</table>");
            }

            out.println("==========================================================================");
            out.println("<h1>IN CLASS COURSES</h1>");

            PreparedStatement ps2 = con.prepareStatement("select * from INCLASSCOURSE");
            ResultSet rs2 = ps2.executeQuery();
            /* Printing column names */
            ResultSetMetaData rsmd2 = rs2.getMetaData();
            while (rs2.next()) {
                out.print("<table width=25% border=1 align='center'>");
                out.print("<center><h1>Result:</h1></center>");
                out.print("<tr>");
                out.print("<td>" + rsmd2.getColumnName(1) + "</td>");
                out.print("<td>" + rs2.getString(1) + "</td></tr>");
                out.print("<tr><td>" + rsmd2.getColumnName(2) + "</td>");
                out.print("<td>" + rs2.getString(2) + "</td></tr>");
                out.print("<tr><td>" + rsmd2.getColumnName(3) + "</td>");
                out.print("<td>" + rs2.getString(3) + "</td></tr>");
                out.print("<tr><td>" + rsmd2.getColumnName(4) + "</td>");
                out.print("<td>" + rs2.getString(4) + "</td></tr>");
                out.print("<tr><td>" + rsmd2.getColumnName(5) + "</td>");
                out.print("<td>" + rs2.getString(5) + "</td></tr>");

                out.print("</table>");
            }

        } catch (Exception e2) {
            e2.printStackTrace();
        } finally {
            out.close();
        }

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/SE554DB",
                    "APP", "APP");

        } catch (Exception e2) {
            e2.printStackTrace();
        } finally {
            out.close();
        }
    }

}
