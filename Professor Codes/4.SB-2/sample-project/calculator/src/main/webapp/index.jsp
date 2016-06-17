<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Secure Calculator</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  </head>
  <body>
      <h2>Be sure to define admin and user role in server realm definition</h2>
      <form action="CalculatorSBServlet">
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
  </body>
</html>

