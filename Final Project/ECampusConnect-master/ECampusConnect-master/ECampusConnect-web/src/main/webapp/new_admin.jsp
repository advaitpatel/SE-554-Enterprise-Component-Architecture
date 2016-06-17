<%-- 
    Document   : new_admin
    Created on : 8 Jun, 2016, 12:30:13 PM
    Author     : Advait
--%>
<%@ page import ="java.sql.*" %>
<%@ page import ="javax.sql.*" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Admin</title>
    </head>
    <body>
        <form name="new_admin" action="NewAdmin" method="POST">
            Enter Id: <input type="text" name="id"/></br>
            Enter Name: <input type="text" name="name"/></br>
            Enter Email: <input type="text" name="email"/></br>
            Enter Username: <input type="text" name="username"/></br>
            Enter Password: <input type="password" name="password"/></br>
            <input type="SUBMIT" value="CREATE NEW ACCOUNT"/>
        </form>
    </body>
</html>
