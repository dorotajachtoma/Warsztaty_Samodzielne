<%--
  Created by IntelliJ IDEA.
  User: dorotajachtoma
  Date: 06.05.19
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edycja Pracownika</title>
</head>
<body>
<%@ include file="header.jsp"%>

<div class="form-group">
    <form method="post" action="updateemployee">
        <label for="formGroupExampleInput">ID</label>
        <input class="form-control" id="formGroupExampleInput" type="number" name="id" value="${employee.id}">
        <label for="formGroupExampleInput">Imie</label>
        <input class="form-control" id="formGroupExampleInput2" type="text" name="name" value="${employee.name}">
        <label for="formGroupExampleInput">Nazwisko</label>
        <input class="form-control" id="formGroupExampleInput3" type="text" name="surname" value="${employee.surname}">
        <label for="formGroupExampleInput">Adres</label>
        <input class="form-control" id="formGroupExampleInput4" type="text" name="address" value="${employee.address}">
        <label for="formGroupExampleInput">Numer kontaktowy</label>
        <input class="form-control" id="formGroupExampleInput5" type="text" name="numberPhone" value="${employee.phoneNumber}">
        <label for="formGroupExampleInput">Notatka</label>
        <input class="form-control" id="formGroupExampleInput6" type="text" name="note" value="${employee.note}">
        <label for="formGroupExampleInput">Koszt roboczogodziny</label>
        <input class="form-control" id="formGroupExampleInput7" type="text" name="costByHour" value="${employee.salaryByHour}">
        <input type="submit" class="btn btn-primary" value="Dodaj pracownika">

    </form>
</div>


<%@include file="footer.jsp"%>

</body>
</html>
