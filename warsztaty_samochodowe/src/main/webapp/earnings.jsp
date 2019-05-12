<%--
  Created by IntelliJ IDEA.
  User: dorotajachtoma
  Date: 12.05.19
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Zarobki</title>
</head>
<body>


<%@ include file="header.jsp"%>
<table class="table table-striped" border="4">
    <th align="center">Koszt napraw</th>
    <th align="center">Koszt pracownikow</th>
    <th align="center">Zysk</th>




        <tr class="table-primary">
            <td>${costOfRepair}</td>
            <td>${costOfEmployees}</td>
            <td>${earnings}</td>
        </tr>

</table>

<br/>
<br/>



<%@include file="footer.jsp"%>

</body>
</html>
