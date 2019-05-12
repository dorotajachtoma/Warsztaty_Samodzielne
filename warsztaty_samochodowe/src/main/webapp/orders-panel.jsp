<%--
  Created by IntelliJ IDEA.
  User: dorotajachtoma
  Date: 03.05.19
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Panel zamówień</title>
</head>
<body>
<%@include file="header.jsp"%>
<nav class="navbar navbar-expand-lg justify-content-around">
    <ul class="nav nav-pills nav-justified">
<li class="nav-item ml-4">
    <a class="list-group-item list-group-item-action list-group-item-primary" href="http://localhost:8080/warsztaty_samochodowe_war_exploded/orderlist">Lista aktualnych zlecen</a>
</li>
<li class="nav-item ml-4">
    <a class="list-group-item list-group-item-action list-group-item-primary" href="http://localhost:8080/warsztaty_samochodowe_war_exploded/addorder">Dodaj zlecenie</a>
</li>
<li class="nav-item ml-4">
    <a class="list-group-item list-group-item-action list-group-item-primary" href="http://localhost:8080/warsztaty_samochodowe_war_exploded/searchorder">Wyszukaj zlecenie</a>
</li>
</ul>
</nav>
<%@include file="footer.jsp"%>



</body>
</html>
