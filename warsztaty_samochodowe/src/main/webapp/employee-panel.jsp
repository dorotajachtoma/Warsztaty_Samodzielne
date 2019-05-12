<%--
  Created by IntelliJ IDEA.
  User: dorotajachtoma
  Date: 03.05.19
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Panel pracownikow</title>
</head>
<body>
<%@include file="header.jsp"%>
<nav class="navbar navbar-expand-lg justify-content-around">
    <ul class="nav nav-pills nav-justified">
<li class="nav-item ml-4">
    <a class="list-group-item list-group-item-action list-group-item-primary" href="http://localhost:8080/warsztaty_samochodowe_war_exploded/employeelist">Lista pracownikow</a>
</li>
<li class="nav-item ml-4">
    <a class="list-group-item list-group-item-action list-group-item-primary" href="http://localhost:8080/warsztaty_samochodowe_war_exploded/addemployee">Dodaj pracownika</a>
</li>

<li class="nav-item ml-4">
    <a class="list-group-item list-group-item-action list-group-item-primary" href="http://localhost:8080/warsztaty_samochodowe_war_exploded/searchemployee">Wyszukaj pracownika</a>
</li>
</ul>
</nav>
<%@include file="footer.jsp"%>



</body>
</html>
