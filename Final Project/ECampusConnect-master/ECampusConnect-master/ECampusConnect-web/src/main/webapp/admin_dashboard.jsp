<%-- 
    Document   : admin_dashboard
    Created on : 8 Jun, 2016, 3:43:28 PM
    Author     : Advait
--%>
<%@ page import="java.sql.*" %>
<%ResultSet resultset = null;%>

<%
    try {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        java.sql.Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/SE554DB",
                "APP", "APP");

        String stud_id = request.getParameter("stud_id");
        String query1 = "delete from student where ID = ?";
        PreparedStatement preparedStmt1 = con.prepareStatement(query1);
        preparedStmt1.setString(1, stud_id);
        preparedStmt1.execute();
        
        String prof_id = request.getParameter("prof_id");
        String query2 = "delete from Instructor where ID = ?";
        PreparedStatement preparedStmt2 = con.prepareStatement(query2);
        preparedStmt2.setString(1, prof_id);
        preparedStmt2.execute();
        
        String course_id = request.getParameter("course_id");
        String query3 = "delete from INCLASSCOURSE where ID = ?";
        PreparedStatement preparedStmt3 = con.prepareStatement(query3);
        preparedStmt3.setString(1, course_id);
        preparedStmt3.execute();
        
        String event_id = request.getParameter("event_id");
        String query4 = "delete from EVENT where ID = ?";
        PreparedStatement preparedStmt4 = con.prepareStatement(query4);
        preparedStmt4.setString(1, event_id);
        preparedStmt4.execute();

    } catch (Exception e) {
        out.println("wrong entry" + e);
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Dashboard</title>
        <style>
            .student {width:400px;
                      margin:auto;
                      font-size:15px;
                      border:1px solid #000;     border-collapse:collapse; }
            .professor {width:400px;
                        margin:auto;
                        font-size:15px;
                        border:1px solid #000;     border-collapse:collapse; }
            .course {width:400px;
                     margin:auto;
                     font-size:15px;
                     border:1px solid #000;     border-collapse:collapse; }
            </style>
        </head>
        <body>
        <marquee><h1>Welcome to the Admin Dashboard</h1></marquee>

        <h2><a href="ViewStudent">View Student Records</a></h2>
        <h2><a href="ViewProfessor">View Professor Records</a></h2>
        <h2><a href="ViewCourses">View Courses Records</a></h2>
        <h2><a href="ViewEvents">View Event Records</a></h2>

        <br><br><br>

        <fieldset>
            <legend><h2>Delete Student Records</h2></legend>
            <form name="delete_student" action="admin_dashboard.jsp" method="POST">
                Enter Student ID: <input type="text" name="stud_id" placeholder="Enter here..." required/><br>
                <input type="SUBMIT" value="DELETE RECORD"/>
            </form>
        </fieldset>
        <fieldset>
            <legend><h2>Delete Professor Records</h2></legend>
            <form name="delete_professor" action="admin_dashboard.jsp" method="POST">
                Enter Professor ID: <input type="text" name="prof_id" placeholder="Enter here..." required/><br>
                <input type="SUBMIT" value="DELETE RECORD"/>
            </form>
        </fieldset>
        <fieldset>
            <legend><h2>Delete Course Records</h2></legend>
            <form name="delete_course" action="admin_dashboard.jsp" method="POST">
                Enter Course ID: <input type="text" name="course_id" placeholder="Enter here..." required/><br>
                <input type="SUBMIT" value="DELETE RECORD"/>
            </form>
        </fieldset>
        <fieldset>
            <legend><h2>Delete Events Records</h2></legend>
            <form name="delete_events" action="admin_dashboard.jsp" method="POST">
                Enter Event ID: <input type="text" name="event_id" placeholder="Enter here..." required/><br>
                <input type="SUBMIT" value="DELETE RECORD"/>
            </form>
        </fieldset>
        

        <fieldset>
            <legend>Create a new Student Record</legend>
            <form name="new_student" class = "student" action="NewStudent" method="POST">
            Enter Id: <input type="text" name="id"/></br>
            Enter Name: <input type="text" name="name"/></br>
            Enter Email: <input type="text" name="email"/></br>
            Enter Level: <input type="text" name="level"/></br>
            Enter Username: <input type="text" name="username"/></br>
            Enter Password: <input type="password" name="password"/></br>
            <input type="SUBMIT" value="CREATE NEW STUDENT"/>
        </form>
    </fieldset>
    <br>

    <fieldset>
        <legend>Create a new Professor Record</legend>
        <form name="new_professor" class = "professor" action="NewProfessor" method="POST">
            Enter Id: <input type="text" name="id"/></br>
            Enter Name: <input type="text" name="name"/></br>
            Enter Email: <input type="text" name="email"/></br>
            Enter Department: <input type="text" name="department"/><br>
            Enter Username: <input type="text" name="username"/></br>
            Enter Password: <input type="password" name="password"/></br>
            <input type="SUBMIT" value="CREATE NEW PROFESSOR"/>
        </form>
    </fieldset>

    <br>
    
    <fieldset>
        <legend>Create a new Online Course Record</legend>
        <form name="new_course" class = "course" action="NewOnlinceCourse" method="POST">
            Enter Id: <input type="text" name="id"/></br>
            Enter Code: <input type="text" name="code"/></br>
            Enter Credits: <input type="text" name="credit"/></br>
            Enter Professor: <input type="text" name="professor"/></br>
            Enter Course URL: <input type="text" name="url"/></br>
            <input type="SUBMIT" value="CREATE NEW ONLINE COURSE"/>
        </form>
    </fieldset>
    
    <fieldset>
        <legend>Create a new In class Course Record</legend>
        <form name="new_course" class = "course" action="NewInclassCourse" method="POST">
            Enter Id: <input type="text" name="id"/></br>
            Enter Code: <input type="text" name="code"/></br>
            Enter Credits: <input type="text" name="credit"/></br>
            Enter Professor: <input type="text" name="professor"/></br>
            Enter Location: <input type="text" name="location"/></br>
            <input type="SUBMIT" value="CREATE NEW INCLASS COURSE"/>
        </form>
    </fieldset>
    
    <fieldset>
        <legend>Create a new Event Record</legend>
        <form name="new_course" class = "course" action="NewEvent" method="POST">
            Enter Id: <input    type="text"  name="id"/></br>
            Enter Name: <input  type="text"  name="name"/></br>
            Enter Place: <input type="text"  name="place"/></br>
            Enter Date: <input  type="text"  name="date"/></br>
            
            <input type="SUBMIT" value="CREATE NEW EVENT"/>
        </form>
    </fieldset>

</body>

</html>
