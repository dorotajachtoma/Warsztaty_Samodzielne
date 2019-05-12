<%--
  Created by IntelliJ IDEA.
  User: dorotajachtoma
  Date: 03.05.19
  Time: 21:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Wyszukiwanie zarejestrowanych pojazdow</title>
</head>
<body>
<%@include file="header.jsp"%>

<h1>Wyszukiwarka pojazdow. Wybierz nazwę producenta</h1>
<form action="searchvehicle" method="post">
    <br/>  Nazwa producenta
    <input type="text" name="brand">
    <input type="submit" value="Wyszukaj" class="btn btn-primary">
</form>

<%@include file="footer.jsp"%>

</body>
</html>
