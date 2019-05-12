<%--
  Created by IntelliJ IDEA.
  User: dorotajachtoma
  Date: 12.05.19
  Time: 08:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Lista Klienta</title>
</head>
<body>
<%@ include file="header.jsp"%>
<table class="table table-striped">
    <th>ID klienta</th>
    <th>Imie</th>
    <th>Nazwisko</th>
    <th>Data urodzin</th>
    <th>Usuwanie</th>
    <th>Edycja</th>


    <c:forEach items="${customer}" var="customer" varStatus="status">

        <tr class="table-primary">
            <td>${customer.id}</td>
            <td>${customer.name}</td>
            <td>${customer.surname}</td>
            <td>${customer.dateOfBirth}</td>
            <td><a href="http://localhost:8080/warsztaty_samochodowe_war_exploded/deletecustomer?id=${customer.id}" onclick="return confirm('Jestes pewny, ze chcesz usunac klienta?');">Usun</a></td>
            <td><a href="http://localhost:8080/warsztaty_samochodowe_war_exploded/updatecustomer?id=${customer.id}" onclick="return confirm('Jestes pewny, ze chcesz edytowac klienta?');">Edytuj</a></td>

        </tr>
    </c:forEach>
</table>

<br/>
<br/>



<%@include file="footer.jsp"%>

</body>
</html>
