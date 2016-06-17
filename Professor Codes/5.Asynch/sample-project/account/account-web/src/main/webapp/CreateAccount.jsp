<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Account</title>
    </head>
    <body>

    <h1>Create an Account record</h1>
    <form id="createAccountForm" action="CreateAccount" method="post">
    <table>
        <tr><td>Name:</td><td><input type="text" id = "id" name="name" /></td></tr>
        <tr><td>Balance:</td><td><input type="text" id = "balance" name="balance" /></td></tr>
    </table>
    <input type="submit" id="CreateRecord" value="CreateRecord" />
    </form>
    <jsp:include page="footer.jspf"/>
</body>
</html>
