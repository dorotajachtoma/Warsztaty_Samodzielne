<%--
  Created by IntelliJ IDEA.
  User: dorotajachtoma
  Date: 03.05.19
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Wyszukiwanie pracownikow</title>
</head>
<body>
<%@include file="header.jsp"%>

<h1>Wyszukiwarka praconikow. Wpisz nazwisko pracownika</h1>
<form action="searchemployee" method="post">
    <br/>  Nazwisko
    <input type="text" name="surname">
    <input type="submit" value="Wyszukaj" class="btn btn-primary">
</form>

<%@include file="footer.jsp"%>

</body>
</html>
