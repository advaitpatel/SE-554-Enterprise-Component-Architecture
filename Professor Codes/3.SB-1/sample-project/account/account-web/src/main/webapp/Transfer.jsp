<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Transfer</title>
    </head>
    <body>

    <h1>Transfer Funds</h1>
    <form id="transferAccountForm" action="TransferFunds" method="post">
    <table>
        <tr><td>From Account:</td><td><input type="text" id = "fromAccount" name="fromAccount" /></td></tr>
        <tr><td>To Account:</td><td><input type="text" id = "toAccount" name="toAccount" /></td></tr>
        <tr><td>Amount:</td><td><input type="text" id = "amount" name="amount" /></td></tr>
    </table>
    <input type="submit" id="UpdateRecord" value="UpdateRecord" />
    </form>
    <jsp:include page="footer.jspf"/>
</body>
</html>
