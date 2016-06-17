<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Calculator</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  </head>
  <body>
      <!-- CalculatorServlet -->
      <!-- CalculatorSBServlet -->
      <!-- CalculatorMSServlet -->
      <form action="CalculatorServlet">
          <input name="lhs" type="text"/>
          <select name="operator">
                <option>+</option>
                <option>-</option>
                <option>*</option>
                <option>/</option>
            </select>

          <input name="rhs" type="text" />
          <input type="submit" value="="/>
      </form>
      
      <br>SOAP</br>
      <a href="${pageContext.request.contextPath}/CalculatorService?wsdl">WSDL</a>
      <br>Addressable SOAP</br>
      <a href="${pageContext.request.contextPath}/AddressedCalculatorService?wsdl">Addressable WSDL</a>
      <br>REST</br>
      <br><a href="${pageContext.request.contextPath}/webresources/application.wadl">WADL</a></br>
      
      <a href="${pageContext.request.contextPath}/webresources/calculator/add?lhs=10&rhs=20">As Text</a>
      <br>
      <a href="${pageContext.request.contextPath}/webresources/calculator/subtract?lhs=10&rhs=20">As XML</a>
  </body>
</html>

