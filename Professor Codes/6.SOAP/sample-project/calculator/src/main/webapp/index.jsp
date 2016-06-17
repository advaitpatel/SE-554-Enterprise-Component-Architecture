<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>SOAPy Calculator</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  </head>
  <body>
      <h1>SOAPy Calculator</h1>
      <br>SOAP</br>
      <a href="${pageContext.request.contextPath}/CalculatorService?wsdl">WSDL</a>
      <br>Addressable SOAP</br>
      <a href="${pageContext.request.contextPath}/AddressedCalculatorService?wsdl">Addressable WSDL</a>
  </body>
</html>

