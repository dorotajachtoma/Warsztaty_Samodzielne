<%--
  Created by IntelliJ IDEA.
  User: dorotajachtoma
  Date: 03.05.19
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dodawanie nowego pojazdu</title>
</head>
<body>
<%@ include file="header.jsp"%>
<div class="form-group">
<form method="post" action="addvehicle">
    <label for="formGroupExampleInput">ID</label>
    <input class="form-control" id="formGroupExampleInput" type="number" name="vehicleID">
    <label for="formGroupExampleInput">Model</label>
    <input class="form-control" id="formGroupExampleInput2" type="text" name="model">
    <label for="formGroupExampleInput">Marka</label>
    <input class="form-control" id="formGroupExampleInput3" type="text" name="brand">
    <label for="formGroupExampleInput">Rok produkcji</label>
    <input class="form-control" id="formGroupExampleInput4" type="text" name="dateOfProduction">
    <label for="formGroupExampleInput">Numer tablicy rejestracyjnej</label>
    <input class="form-control" id="formGroupExampleInput5" type="text" name="numberPlate">
    <label for="formGroupExampleInput">Data nastepnego serwisu</label>
    <input class="form-control" id="formGroupExampleInput6" type="date" name="dateOfService">
    <label for="formGroupExampleInput">ID wlasciciela(Klienta)</label>
    <input class="form-control" id="formGroupExampleInput7" type="number" name="customerID">
    <input type="submit" class="btn btn-primary" value="Dodaj pojazd">
</form>
</div>
<br/>
<br/>


<%@include file="footer.jsp"%>


</body>
</html>
