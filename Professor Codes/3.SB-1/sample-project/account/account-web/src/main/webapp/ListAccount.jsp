<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Of Accounts</title>
    </head>
    <body>

    <h1>List of Accounts currently in Database</h1>
    
<table id="accountListTable" border="3">
<tr >
    <th bgcolor=>ID</th>
    <th bgcolor=>Name</th>
    <th bgcolor=>Balance</th>
</tr>
<c:forEach var="account" begin="0" items="${requestScope.accountList}">
<tr>
    <td>${account.id}&nbsp;&nbsp;</td> 
    <td>${account.name}&nbsp;&nbsp;</td> 
    <td>${account.balance}&nbsp;&nbsp;</td> 
</tr> 

</c:forEach>

</table>
    <jsp:include page="footer.jspf"/>
</body>
</html>
