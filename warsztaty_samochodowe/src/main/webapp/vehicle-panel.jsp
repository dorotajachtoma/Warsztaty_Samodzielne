<%--
  Created by IntelliJ IDEA.
  User: dorotajachtoma
  Date: 03.05.19
  Time: 20:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Panel zarejestrowanych pojazdów</title>
</head>
<body>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<%@include file="header.jsp"%>
<nav class="navbar navbar-expand-lg justify-content-around">
    <ul class="nav nav-pills nav-justified">
<li class="nav-item ml-4">
    <a class="list-group-item list-group-item-action list-group-item-primary" href="http://localhost:8080/warsztaty_samochodowe_war_exploded/vehiclelist">Lista zarejrestowanych pojazdow</a>
</li>
<li class="nav-item ml-4">
    <a class="list-group-item list-group-item-action list-group-item-primary" href="http://localhost:8080/warsztaty_samochodowe_war_exploded/addvehicle">Dodaj pojazd</a>
</li>
<li class="nav-item ml-4">
    <a class="list-group-item list-group-item-action list-group-item-primary" href="http://localhost:8080/warsztaty_samochodowe_war_exploded/searchvehicle">Wyszukaj pojazd</a>
</li>
</ul>
</nav>
<%@include file="footer.jsp"%>

</body>
</html>
