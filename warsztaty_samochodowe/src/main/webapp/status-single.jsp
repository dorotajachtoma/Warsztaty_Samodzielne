<%--
  Created by IntelliJ IDEA.
  User: dorotajachtoma
  Date: 12.05.19
  Time: 12:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Status zamówienia</title>
</head>
<body>
<%@ include file="header.jsp"%>
<table class="table table-striped">
    <th>Opis statusu</th>



    <c:forEach items="${status}" var="status" varStatus="status">

        <tr class="table-primary">
            <td align="center">${status.status}</td>

        </tr>
    </c:forEach>
</table>

<br/>
<br/>



<%@include file="footer.jsp"%>


</body>
</html>
