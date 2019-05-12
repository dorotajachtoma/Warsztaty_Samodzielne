package pl.coderslab.crm.model;


public class Order  {
    private int id;
    private String acceptedtoRepair;
    private String plannedDateOfRepair;
    private String startOfRepair;
    private int employeeId;
    private String descriptionOfProblem;
    private String descriptionOfFixing;
    private String idOfVehicle;
    private String costOfFixing;
    private String costOfCarParts;
    private String costOfEmployee;
    private int quantityOfWorkByHour;
    private int statusId;

    public Order() {
    }

    public Order(int id,String acceptedtoRepair, String plannedDateOfRepair, String startOfRepair, int employeeId, String descriptionOfProblem, String descriptionOfFixing, String idOfVehicle, String costOfFixing, String costOfCarParts, String costOfEmployee, int quantityOfWorkByHour, int statusId) {
        this.id = id;
        this.acceptedtoRepair = acceptedtoRepair;
        this.plannedDateOfRepair = plannedDateOfRepair;
        this.startOfRepair = startOfRepair;
        this.employeeId = employeeId;
        this.descriptionOfProblem = descriptionOfProblem;
        this.descriptionOfFixing = descriptionOfFixing;
        this.idOfVehicle = idOfVehicle;
        this.costOfFixing = costOfFixing;
        this.costOfCarParts = costOfCarParts;
        this.costOfEmployee = costOfEmployee;
        this.quantityOfWorkByHour = quantityOfWorkByHour;
        this.statusId = statusId;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAcceptedtoRepair() {
        return acceptedtoRepair;
    }

    public void setAcceptedtoRepair(String acceptedtoRepair) {
        this.acceptedtoRepair = acceptedtoRepair;
    }

    public String getPlannedDateOfRepair() {
        return plannedDateOfRepair;
    }

    public void setPlannedDateOfRepair(String plannedDateOfRepair) {
        this.plannedDateOfRepair = plannedDateOfRepair;
    }

    public String  getStartOfRepair() {
        return startOfRepair;
    }

    public void setStartOfRepair(String startOfRepair) {
        this.startOfRepair = startOfRepair;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getDescriptionOfProblem() {
        return descriptionOfProblem;
    }

    public void setDescriptionOfProblem(String descriptionOfProblem) {
        this.descriptionOfProblem = descriptionOfProblem;
    }

    public String getDescriptionOfFixing() {
        return descriptionOfFixing;
    }

    public void setDescriptionOfFixing(String descriptionOfFixing) {
        this.descriptionOfFixing = descriptionOfFixing;
    }


    public String getIdOfVehicle() {
        return idOfVehicle;
    }

    public void setIdOfVehicle(String idOfVehicle) {
        this.idOfVehicle = idOfVehicle;
    }

    public String getCostOfFixing() {
        return costOfFixing;
    }

    public void setCostOfFixing(String costOfFixing) {
        this.costOfFixing = costOfFixing;
    }

    public String getCostOfCarParts() {
        return costOfCarParts;
    }

    public void setCostOfCarParts(String costOfCarParts) {
        this.costOfCarParts = costOfCarParts;
    }

    public String getCostOfEmployee() {
        return costOfEmployee;
    }

    public void setCostOfEmployee(String costOfEmployee) {
        this.costOfEmployee = costOfEmployee;
    }

    public int getQuantityOfWorkByHour() {
        return quantityOfWorkByHour;
    }

    public void setQuantityOfWorkByHour(int quantityOfWorkByHour) {
        this.quantityOfWorkByHour = quantityOfWorkByHour;
    }
}
