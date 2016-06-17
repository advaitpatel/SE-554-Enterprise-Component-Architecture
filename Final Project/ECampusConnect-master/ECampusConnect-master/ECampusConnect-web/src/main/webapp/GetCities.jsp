<%-- 
    Document   : GetCities
    Created on : 9 Jun, 2016, 2:04:41 AM
    Author     : Advait
--%>

<%@page import="pub.web.services.GlobalWeatherDelegate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 import="java.util.*" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <%
           String cities = "Cities &nbsp;&nbsp;&nbsp;&nbsp;  <select name='cityselect'                                               onChange=getTemp(this.value);>  <option value='-1'>Select</option>";
           GlobalWeatherDelegate globalWeatherbd = new GlobalWeatherDelegate();
           ArrayList<String> cityList = (ArrayList<String>) globalWeatherbd
                                                                 .getCities(request.getParameter("country"));
           Iterator<String> cityIerator = cityList.iterator();
           while (cityIerator.hasNext()) {
                     String city = cityIerator.next();
                     cities += "<option value=" + city + ">" + city + "</option>";
            }
           cities += "</select>";
           System.out.println(cities);
           out.println(cities);
 %>
</body>
</html>