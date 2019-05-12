<%--
  Created by IntelliJ IDEA.
  User: dorotajachtoma
  Date: 29.04.19
  Time: 07:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%@ include file="header.jsp"%>
<div class="form-group">
<form method="post" action="addorder">
    <label for="formGroupExampleInput">ID</label>
    <input class="form-control" id="formGroupExampleInput" type="number" name="id">
    <label for="formGroupExampleInput">Data zaakceptowania zlecenia</label>
    <input class="form-control" id="formGroupExampleInput2" type="date" name="acceptedToRepair">
    <label for="formGroupExampleInput">Data planowanej naprawy</label>
    <input class="form-control" id="formGroupExampleInput3" type="date" name="plannedDate">
    <label for="formGroupExampleInput">Data rozpoczęcia naprawy</label>
    <input class="form-control" id="formGroupExampleInput4" type="date" name="dateOfRepair">
    <label for="formGroupExampleInput">ID pracownika</label>
    <input class="form-control" id="formGroupExampleInput5" type="number" name="employeeID">
    <label for="formGroupExampleInput">Opis problemu</label>
    <input class="form-control" id="formGroupExampleInput6" type="text" name="descriptionProblem">
    <label for="formGroupExampleInput">Opis naprawy</label>
    <input class="form-control" id="formGroupExampleInput7" type="text" name="descriptionFixing" >
    <label for="formGroupExampleInput">ID pojazdu</label>
    <input class="form-control" id="formGroupExampleInput8" type="number" name="vehicleID">
    <label for="formGroupExampleInput">Koszt naprawy</label>
    <input class="form-control" id="formGroupExampleInput9" type="text" name="costOfRepair">
    <label for="formGroupExampleInput">Koszt czesci uzytych do naprawy</label>
    <input class="form-control" id="formGroupExampleInput10" type="text" name="costOfParts">
    <label for="formGroupExampleInput">Koszt roboczogodziny pracownika</label>
    <input class="form-control" id="formGroupExampleInput11" type="text" name="costOfEmployee">
    <label for="formGroupExampleInput">Liczba godzin naprawy</label>
    <input class="form-control" id="formGroupExampleInput12" type="number" name="quantityOfHours">
    <label for="formGroupExampleInput">ID statusu</label>
    <input class="form-control" id="formGroupExampleInput13" type="number" name="statusID" >
  <br/>      <input type="submit" class="btn btn-primary" value="Dodaj zlecenie">

</form>
</div>
<br/>
<br/>


<%@include file="footer.jsp"%>

</body>
</html>
