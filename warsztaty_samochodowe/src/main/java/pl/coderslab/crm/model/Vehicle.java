package pl.coderslab.crm.model;


public class Vehicle {
    private int id;
    private String model;
    private String brand;
    private String dateOfProduction;
    private String numberPlate;
    private String dateOfNextService;
    private int customerId;

    public Vehicle() {
    }

    public Vehicle(int id, String model, String brand, String dateOfProduction, String numberPlate, String dateOfNextService, int customerId) {
        this.id = id;
        this.model = model;
        this.brand = brand;
        this.dateOfProduction = dateOfProduction;
        this.numberPlate = numberPlate;
        this.dateOfNextService = dateOfNextService;
        this.customerId = customerId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDateOfProduction() {
        return dateOfProduction;
    }

    public void setDateOfProduction(String dateOfProduction) {
        this.dateOfProduction = dateOfProduction;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public String getDateOfNextService() {
        return dateOfNextService;
    }

    public void setDateOfNextService(String dateOfNextService) {
        this.dateOfNextService = dateOfNextService;
    }
}
