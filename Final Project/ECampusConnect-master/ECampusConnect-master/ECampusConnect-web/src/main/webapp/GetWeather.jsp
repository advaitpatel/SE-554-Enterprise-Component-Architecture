<%-- 
    Document   : GetWeather
    Created on : 9 Jun, 2016, 2:05:16 AM
    Author     : Advait
--%>

<%@page
 import="pub.web.services.GlobalWeatherDelegate,pub.web.services.CurrentWeather"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <%
               GlobalWeatherDelegate globalWeatherbd = new GlobalWeatherDelegate();
               CurrentWeather currentWeather = globalWeatherbd.getWeather(
               request.getParameter("city"),  request.getParameter("country"));
               if (currentWeather != null) {
               String responseXml = "<table border=\"0\" cellspacing=\"10\" cellpadding=\"10\"> <th><h2> "
              + request.getParameter("city")
              + "</h2></th> <tr> <td> Location </td> <td> "
              + currentWeather.getLocation()
              + "</td> </tr>"
              + "<tr> <td> Time </td> <td> "
              + currentWeather.getTime()
              + "</td> </tr>"
              + "<tr> <td> wind </td> <td> "
              + currentWeather.getWind()
              + "</td> </tr>"
              + "<tr> <td> Visibility </td> <td> "
              + currentWeather.getVisibility()
              + "</td> </tr>"
              + "<tr> <td> Temperature </td> <td> "
              + currentWeather.getTemperature()
              + "</td> </tr>"
              + "<tr> <td> Pressure </td> <td> "
              + currentWeather.getPressure()
              + "</td> </tr>"
              + "<tr> <td> Dewpoint </td> <td> "
              + currentWeather.getDewPoint()
              + "</td> </tr>"
              + "<tr> <td> Humidity </td> <td> "
              + currentWeather.getRelativeHumidity()
              + "</td> </tr>"
              + "</table>";

   out.print(responseXml);
  } else {
   out.print("<h3> No Data Found Try another City </h3>");
  }
 %>

 <table border="1" cellspacing="10" cellpadding="10">
 </table>
</body>
</html>