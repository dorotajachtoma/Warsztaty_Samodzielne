<%@ page contentType="text/html;charset=UTF-8" language= "java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Strona Glowna Panelu</title>
</head>
<body>
<%@ include file="header.jsp"%>
<table class="table table-striped">
    <th>ID zamowienia</th>
    <th>Akceptacja naprawy</th>
    <th>Planowana data naprawy</th>
    <th>Data naprawy</th>
    <th>ID przypisanego pracownika</th>
    <th>Opis problemu</th>
    <th>Opis naprawy</th>
    <th>ID pojazdu</th>
    <th>Koszt naprawy</th>
    <th>Koszt czesci</th>
    <th>Koszt pracownika</th>
    <th>Ilosc roboczogodzin</th>
    <th>ID statusu</th>
    <th>Usuwanie</th>
    <th>Edycja</th>

    <c:forEach items="${order}" var="order" varStatus="status">

        <tr class="table-primary">
            <td align="center">${order.getId()}</td>
            <td align="center">${order.getAcceptedtoRepair()}</td>
            <td align="center">${order.getPlannedDateOfRepair()}</td>
            <td align="center">${order.getStartOfRepair()}</td>
            <td align="center"><a href="http://localhost:8080/warsztaty_samochodowe_war_exploded/selectemployee?id=${order.getEmployeeId()}">${order.getEmployeeId()}</a></td>
            <td align="center">${order.getDescriptionOfProblem()}</td>
            <td align="center">${order.getDescriptionOfFixing()}</td>
            <td align="center"><a href="http://localhost:8080/warsztaty_samochodowe_war_exploded/selectvehicle?id=${order.getIdOfVehicle()}">${order.getIdOfVehicle()}</a></td>
            <td align="center">${order.getCostOfFixing()}</td>
            <td align="center">${order.getCostOfCarParts()}</td>
            <td align="center">${order.getCostOfEmployee()}</td>
            <td align="center">${order.getQuantityOfWorkByHour()}</td>
            <td align="center"><a href="http://localhost:8080/warsztaty_samochodowe_war_exploded/selectstatus?id=${order.getStatusId()}">${order.getStatusId()}</a></td>
            <td align="center"><a href="http://localhost:8080/warsztaty_samochodowe_war_exploded/deleteorder?id=${order.id}" onclick="return confirm('Jestes pewny, ze chcesz usunac zlecenie?');">Usun</a></td>
            <td align="center"><a href="http://localhost:8080/warsztaty_samochodowe_war_exploded/updateorder?id=${order.id}" onclick="return confirm('Jestes pewny, ze chcesz edytowac zlecenie?');">Edytuj</a></td>
        </tr>
    </c:forEach>
</table>

<%@include file="footer.jsp"%>
</body>
</html>