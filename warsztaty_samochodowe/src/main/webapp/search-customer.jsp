<%--
  Created by IntelliJ IDEA.
  User: dorotajachtoma
  Date: 03.05.19
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Wyszukiwarka klientow</title>
</head>
<body>
<%@include file="header.jsp"%>

<h1>Wyszukiwarka klientow. Wpisz nazwisko klienta</h1>
<form action="searchcustomer" method="post">
    <br/>  Nazwisko
    <input type="text" name="surname">
    <input type="submit" value="Wyszukaj" class="btn btn-primary">
</form>

<%@include file="footer.jsp"%>
</body>
</html>
