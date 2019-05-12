<%--
  Created by IntelliJ IDEA.
  User: dorotajachtoma
  Date: 03.05.19
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Lista pracownikow</title>
</head>
<body>

<%@ include file="header.jsp"%>
<table class="table table-striped">
    <th>ID pracownika</th>
    <th>Imie</th>
    <th>Nazwisko</th>
    <th>Adres</th>
    <th>Numer kontaktowy</th>
    <th>Notatka</th>
    <th>Koszt roboczogodziny</th>
    <th>Usuwanie</th>
    <th>Edycja</th>
    <th>Raport przepracowanych godzin</th>
    <th>Aktualne zlecenia</th>

    <c:forEach items="${employee}" var="employee" varStatus="status">

        <tr class="table-primary">
            <td align="center">${employee.id}</td>
            <td align="center">${employee.name}</td>
            <td align="center">${employee.surname}</td>
            <td align="center">${employee.address}</td>
            <td align="center">${employee.phoneNumber}</td>
            <td align="center">${employee.note}</td>
            <td align="center">${employee.salaryByHour}</td>
            <td align="center"><a href="http://localhost:8080/warsztaty_samochodowe_war_exploded/deleteemployee?id=${employee.id}" onclick="return confirm('Jestes pewny, ze chcesz usunac pracownika?');">Usun</a></td>
            <td align="center"><a href="http://localhost:8080/warsztaty_samochodowe_war_exploded/updateemployee?id=${employee.id}" onclick="return confirm('Jestes pewny, ze chcesz edytowac pracownika?');">Edytuj</a></td>
            <td align="center"><a href="http://localhost:8080/warsztaty_samochodowe_war_exploded/raport-sum-hours?id=${employee.id}">Przejdz</a> </td>
            <td align="center"><a href="http://localhost:8080/warsztaty_samochodowe_war_exploded/selectallorders?id=${employee.id}">Przejdz do zlecen</a> </td>

        </tr>
    </c:forEach>
</table>

<br/>
<br/>



<%@include file="footer.jsp"%>

</body>
</html>
