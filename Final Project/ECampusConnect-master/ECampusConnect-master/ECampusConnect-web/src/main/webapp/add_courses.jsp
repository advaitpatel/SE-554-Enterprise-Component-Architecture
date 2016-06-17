<%--
    Document   : add_courses
    Created on : 9 Jun, 2016, 12:47:36 PM
    Author     : Advait
--%>
<%@page import="java.util.Random"%>
<%@ page import="java.sql.*" %>
<%ResultSet resultset1 = null;%>
<%ResultSet resultset2 = null;%>
<%
    String inclass_id = request.getParameter("inclass_course_id");
    String online_id = request.getParameter("online_course_id");
    String username = request.getParameter("username");

    try {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/SE554DB",
                "APP", "APP");

        Random r = new Random();
        int Low = 50;
        int High = 500;
        int Result = r.nextInt(High - Low) + Low;
        
        Random r2 = new Random();
        int Low2 = 501;
        int High2 = 1000;
        int Result2 = r2.nextInt(High2 - Low2) + Low2;

        String query = "INSERT into ENROLLMENT (ID, COURSE_NAME, USER_NAME) values (?,?,?)";
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setString(2, inclass_id);
        preparedStmt.setString(3, username);
        preparedStmt.setInt(1, Result);

        String query2 = "INSERT into ENROLLMENT (ID, COURSE_NAME, USER_NAME) values (?,?,?)";
        PreparedStatement preparedStmt2 = con.prepareStatement(query2);
        preparedStmt2.setString(2, online_id);
        preparedStmt2.setString(3, username);
        preparedStmt2.setInt(1, Result2);
        
        preparedStmt.execute();
        preparedStmt2.execute();
        
    } catch (Exception e) {
        out.println("wrong entry" + e);
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Course Catalog</title>
    </head>
    <body>
        <%
            try {
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/SE554DB",
                        "APP", "APP");
                Statement statement1 = con.createStatement();
                resultset1 = statement1.executeQuery(
                        "select * from ENROLLMENT WHERE USER_NAME = '" +  username + "'");

                
        %>
        <h1>Your course catalog</h1>
        <select name="online_course_id">
            <%  while (resultset1.next()) {%>
            <option size="50"><%= resultset1.getString(2)%></option>
            <% } %>
        </select>
        

    </body>
    <%
            //**Should I input the codes here?**
        } catch (Exception e) {
            out.println("wrong entry" + e);
        }
    %>
</html>
