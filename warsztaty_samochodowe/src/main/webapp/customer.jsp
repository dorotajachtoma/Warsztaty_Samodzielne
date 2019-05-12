<%--
  Created by IntelliJ IDEA.
  User: dorotajachtoma
  Date: 03.05.19
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dodawanie nowego klienta</title>
</head>
<body>
<%@ include file="header.jsp"%>
<div class="form-group">
<form method="post" action="addcustomer">
    <label for="formGroupExampleInput">ID</label>
    <input class="form-control" id="formGroupExampleInput" type="number" name="id">
    <label for="formGroupExampleInput">Imie</label>
    <input class="form-control" id="formGroupExampleInput2" type="text" name="name">
    <label for="formGroupExampleInput">Nazwisko</label>
    <input class="form-control" id="formGroupExampleInput3" type="text" name="surname">
    <label for="formGroupExampleInput">Data urodzenia</label>
    <input class="form-control" id="formGroupExampleInput4" type="date" name="date"><br/>
    <input type="submit" class="btn btn-primary" value="Dodaj klienta">
</form>
</div>
<br/>
<br/>

<%@include file="footer.jsp"%>

</body>
</html>
