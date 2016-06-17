<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Deposit</title>
    </head>
    <body>

    <h1>Deposit</h1>
    <form id="depositAccountForm" action="DepositAccount" method="post">
    <table>
        <tr><td>Account:</td><td><input type="text" id = "id" name="id" /></td></tr>
        <tr><td>Deposit Amount:</td><td><input type="text" id = "amount" name="amount" /></td></tr>
    </table>
    <input type="submit" id="UpdateRecord" value="UpdateRecord" />
    </form>
    <jsp:include page="footer.jspf"/>
</body>
</html>
