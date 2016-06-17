<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>MessageBean Calculator</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  </head>
  <body>
      <form action="CalculatorMSServlet ">
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

