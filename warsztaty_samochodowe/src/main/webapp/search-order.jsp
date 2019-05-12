<%--
  Created by IntelliJ IDEA.
  User: dorotajachtoma
  Date: 03.05.19
  Time: 20:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Wyszukiwanie zamowien</title>
</head>
<body>
<%@include file="header.jsp"%>

<h1>Wyszukiwarka zlecen. Wybierz date rozpoczecia naprawy</h1>
<form action="searchorder" method="post">
    <br/>  Data
    <input type="date" name="date">
    <input type="submit" class="btn btn-primary" value="Wyszukaj">
</form>

<%@include file="footer.jsp"%>

</body>
</html>
