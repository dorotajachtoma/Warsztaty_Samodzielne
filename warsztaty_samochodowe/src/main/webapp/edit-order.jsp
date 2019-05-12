<%--
  Created by IntelliJ IDEA.
  User: dorotajachtoma
  Date: 06.05.19
  Time: 22:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edycja zamówienia</title>
</head>
<body>
<%@ include file="header.jsp"%>

<div class="form-group">
    <form method="post" action="updateorder">
        <label for="formGroupExampleInput">ID</label>
        <input class="form-control" id="formGroupExampleInput" type="number" name="id" value="${order.getId()}">
        <label for="formGroupExampleInput">Data zaakceptowania zlecenia</label>
        <input class="form-control" id="formGroupExampleInput2" type="date" name="acceptedToRepair" value="${order.getAcceptedtoRepair()}">
        <label for="formGroupExampleInput">Data planowanej naprawy</label>
        <input class="form-control" id="formGroupExampleInput3" type="date" name="plannedDate" value="${order.getPlannedDateOfRepair()}">
        <label for="formGroupExampleInput">Data rozpoczęcia naprawy</label>
        <input class="form-control" id="formGroupExampleInput4" type="date" name="dateOfRepair" value="${order.getStartOfRepair()}">
        <label for="formGroupExampleInput">ID pracownika</label>
        <input class="form-control" id="formGroupExampleInput5" type="number" name="employeeID" value="${order.getEmployeeId()}">
        <label for="formGroupExampleInput">Opis problemu</label>
        <input class="form-control" id="formGroupExampleInput6" type="text" name="descriptionProblem" value="${order.getDescriptionOfProblem()}">
        <label for="formGroupExampleInput">Opis naprawy</label>
        <input class="form-control" id="formGroupExampleInput7" type="text" name="descriptionFixing" value="${order.getDescriptionOfFixing()}" >
        <label for="formGroupExampleInput">ID pojazdu</label>
        <input class="form-control" id="formGroupExampleInput8" type="number" name="vehicleID" value="${order.getIdOfVehicle()}">
        <label for="formGroupExampleInput">Koszt naprawy</label>
        <input class="form-control" id="formGroupExampleInput9" type="text" name="costOfRepair" value="${order.getCostOfFixing()}">
        <label for="formGroupExampleInput">Koszt czesci uzytych do naprawy</label>
        <input class="form-control" id="formGroupExampleInput10" type="text" name="costOfParts" value="${order.getCostOfCarParts()}">
        <label for="formGroupExampleInput">Koszt roboczogodziny pracownika</label>
        <input class="form-control" id="formGroupExampleInput11" type="text" name="costOfEmployee" value="${order.getCostOfEmployee()}">
        <label for="formGroupExampleInput">Liczba godzin naprawy</label>
        <input class="form-control" id="formGroupExampleInput12" type="number" name="quantityOfHours" value="${order.getQuantityOfWorkByHour()}">
        <label for="formGroupExampleInput">ID statusu</label>
        <input class="form-control" id="formGroupExampleInput13" type="number" name="statusID" value="${order.getStatusId()}" >
        <br/>      <input type="submit" class="btn btn-primary" value="Dodaj zlecenie">

    </form>
</div>

<%@include file="footer.jsp"%>

</body>
</html>
