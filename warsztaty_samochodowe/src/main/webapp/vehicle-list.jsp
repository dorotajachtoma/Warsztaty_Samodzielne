<%--
  Created by IntelliJ IDEA.
  User: dorotajachtoma
  Date: 03.05.19
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Lista zarejestrowanych pojazdow</title>
</head>
<body>

<%@ include file="header.jsp"%>
<table class="table table-striped">
    <th>ID pojazdu</th>
    <th>Model</th>
    <th>Marka</th>
    <th>Data produkcji</th>
    <th>Numer tablicy rejestracyjnej</th>
    <th>Data następnego serwisu</th>
    <th>ID wlasciciela(klienta)</th>
    <th>Usuwanie</th>
    <th>Edycja</th>
    <c:forEach items="${vehicle}" var="vehicle" varStatus="status">

        <tr class="table-primary">
            <td align="center">${vehicle.id}</td>
            <td align="center">${vehicle.model}</td>
            <td align="center">${vehicle.brand}</td>
            <td align="center">${vehicle.dateOfProduction}</td>
            <td align="center">${vehicle.numberPlate}</td>
            <td align="center">${vehicle.dateOfNextService}</td>
            <td align="center"><a href="http://localhost:8080/warsztaty_samochodowe_war_exploded/selectcustomer?id=${vehicle.customerId}">${vehicle.customerId}</a></td>
            <td align="center"><a href="http://localhost:8080/warsztaty_samochodowe_war_exploded/deletevehicle?id=${vehicle.id}" onclick="return confirm('Jestes pewny, ze chcesz usunac zarejestrowany pojazd?');">Usun</a></td>
            <td align="center"><a href="http://localhost:8080/warsztaty_samochodowe_war_exploded/updatevehicle?id=${vehicle.id}" onclick="return confirm('Jestes pewny, ze chcesz edytowac zarejestrowany pojazd?');">Edytuj</a></td>

        </tr>
    </c:forEach>
</table>

<br/>
<br/>

<%@include file="footer.jsp"%>

</body>
</html>
