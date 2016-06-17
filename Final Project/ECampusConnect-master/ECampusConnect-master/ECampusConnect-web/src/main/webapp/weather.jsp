<%-- 
    Document   : weather
    Created on : Jun 9, 2016, 4:04:56 AM
    Author     : Dhaval
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Public Web Services</title>
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
            document.getElementById("weather2").innerHTML = xmlHttp.responseText
  }

  };
  xmlHttp.open("GET", url, true);
  xmlHttp.send(null);

 }
</script>
    </head>
    <body onload="weatherLoader()">
        <h1><div id="weather">Weather Data</div></h1>
        
        <script>
            function weatherLoader() {
                var xmlhttp = new XMLHttpRequest();
                xmlhttp.onreadystatechange = function() {
                    if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                        var myArr = JSON.parse(xmlhttp.responseText);
                        myFunction(myArr);
                    }
                };
                xmlhttp.open("GET", "http://api.openweathermap.org/data/2.5/weather?id=4887398&units=metric&APPID=2775de66607d2596792c0e174f5f0b27", true);
                xmlhttp.send();
                function myFunction(arr) {
                    var temp = arr.main.temp;
                    document.getElementById("weather").innerHTML = "Weather in Chicago is " + temp + " degree Celsius.";
                }

                console.log(xmlhttp.status);
                console.log(xmlhttp.statusText);
            }

        </script>
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
 <div id="weather2"></div>
    </body>
</html>
