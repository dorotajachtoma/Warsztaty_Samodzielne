<%--
  Created by IntelliJ IDEA.
  User: dorotajachtoma
  Date: 12.05.19
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Raport I</title>
</head>
<body>

<%@ include file="header.jsp"%>
<table class="table table-striped">
    <th>Imie </th>
    <th>Nazwisko</th>
    <th align="center">Ilosc przepracowanych godzin w ciagu ostatnich 30 dni</th>

    <c:forEach items="${sum}" var="sum" varStatus="status">

        <tr class="table-primary">
            <td>${employee.name}</td>
            <td >${employee.surname}</td>
            <td>${sum}</td>
        </tr>
    </c:forEach>
</table>

<br/>
<br/>



<%@include file="footer.jsp"%>

</body>
</html>
