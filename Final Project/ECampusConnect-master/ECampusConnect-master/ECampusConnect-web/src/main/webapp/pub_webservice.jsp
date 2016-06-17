<%-- 
    Document   : pub_webservice
    Created on : 9 Jun, 2016, 2:04:06 AM
    Author     : Advait
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
 function getCities() {
       var selectOb = document.getElementById("country");
       var country = selectOb.options[selectOb.selectedIndex].value;
       if (country == "-1") {
              alert("Invalid selection");
              return false;
       }
  var xmlHttp;
  xmlHttp = new XMLHttpRequest();
  var url = "GetCities.jsp";
  url += "?country=" + country;
  xmlHttp.onreadystatechange = function() {
  if (xmlHttp.readyState == 4 || xmlHttp.readyState == "complete") {
         document.getElementById("cities").innerHTML = xmlHttp.responseText
   }

  };
  xmlHttp.open("GET", url, true);
  xmlHttp.send(null);

 }
 function getTemp(x) {

             var selectOb = document.getElementById("country");
             var country = selectOb.options[selectOb.selectedIndex].value;
             if (country == "-1" || x == "select") {
             alert("Invalid selection");
             return false;
  }
  var xmlHttp;
  xmlHttp = new XMLHttpRequest();
  var url = "GetWeather.jsp";
  url += "?country=" + country + "&city=" + x;
  xmlHttp.onreadystatechange = function() {
            if (xmlHttp.readyState == 4 || xmlHttp.readyState == "complete") {
            document.getElementById("weather").innerHTML = xmlHttp.responseText
  }

  };
  xmlHttp.open("GET", url, true);
  xmlHttp.send(null);

 }
</script>
</head>
<body>
 Country &nbsp;
 <select onchange="getCities()" id="country">
  <option value="-1">--select--</option>
  <option value="India">India</option>
  <option value="United States">US</option>
 </select>
 <br>
 <br>
 <div id="cities">
  Cities &nbsp;&nbsp;&nbsp;&nbsp; <select onChange="getTemp(this)"
   id="city">
   <option value="-1">--select--</option>
  </select>
 </div>
 <div id="weather"></div>
</body>
</html>
