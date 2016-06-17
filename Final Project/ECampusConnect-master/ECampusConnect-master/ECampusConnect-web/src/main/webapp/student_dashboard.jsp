<%-- 
    Document   : student_dashboard
    Created on : 9 Jun, 2016, 4:00:28 AM
    Author     : Advait
--%>
<%@ page import="java.sql.*" %>
<%ResultSet resultset1 = null;%>
<%ResultSet resultset2 = null;%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome Home</title>
    </head>
    <body>
        <%
            try {
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/SE554DB",
                        "APP", "APP");
                Statement statement1 = con.createStatement();
                resultset1 = statement1.executeQuery("select * from INCLASSCOURSE");

                Statement statement2 = con.createStatement();
                resultset2 = statement2.executeQuery("select * from ONLINECOURSE");
        %>
        
        <h1>Hello Student!</h1>
    <center>
        <h1> Please Select Your Course from here </h1>
    </center>
    <form align = "left" name="trial" action="add_courses.jsp" method="GET">
        <h2>List of available In Class Courses</h2>
        <select name="inclass_course_id">
            <%  while (resultset1.next()) {%>
            <option size="50"><%= resultset1.getString(2)%></option>
            <% } %>
        </select>
        Enter Username: <input type="text" name="username" required="required"/>
        <INPUT type="submit" value="ADD"/>
    </form>

    <form align="right" name="online" action="add_courses.jsp" method="GET">
        <h2>List of available Online Courses</h2>
        <select name="online_course_id">
            <%  while (resultset2.next()) {%>
            <option size="50"><%= resultset2.getString(2)%></option>
            <% } %>
        </select>
        Enter Username: <input type="text" name="username" required="required"/>
        <INPUT type="submit" value="ADD"/>
    </form>



    <%
            //**Should I input the codes here?**
        } catch (Exception e) {
            out.println("wrong entry" + e);
        }
    %>
</body>
</html>
