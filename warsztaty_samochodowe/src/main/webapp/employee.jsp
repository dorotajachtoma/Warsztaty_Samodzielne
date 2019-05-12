<%--
  Created by IntelliJ IDEA.
  User: dorotajachtoma
  Date: 03.05.19
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dodawanie nowego pracownika</title>
</head>
<body>
<%@ include file="header.jsp"%>
<div class="form-group">
<form method="post" action="addemployee">
    <label for="formGroupExampleInput">ID</label>
    <input class="form-control" id="formGroupExampleInput" type="number" name="id">
    <label for="formGroupExampleInput">Imie</label>
    <input class="form-control" id="formGroupExampleInput2" type="text" name="name">
    <label for="formGroupExampleInput">Nazwisko</label>
    <input class="form-control" id="formGroupExampleInput3" type="text" name="surname">
    <label for="formGroupExampleInput">Adres</label>
    <input class="form-control" id="formGroupExampleInput4" type="text" name="address">
    <label for="formGroupExampleInput">Numer kontaktowy</label>
    <input class="form-control" id="formGroupExampleInput5" type="text" name="numberPhone">
    <label for="formGroupExampleInput">Notatka</label>
    <input class="form-control" id="formGroupExampleInput6" type="text" name="note">
    <label for="formGroupExampleInput">Koszt roboczogodziny</label>
    <input class="form-control" id="formGroupExampleInput7" type="text" name="costByHour">
    <input type="submit" class="btn btn-primary" value="Dodaj pracownika">

</form>
</div>


<%@include file="footer.jsp"%>

</body>
</html>
