package pl.coderslab.crm.model;

public class Employee  {
    private int id;
    private String name;
    private String surname;
    private String address;
    private String phoneNumber;
    private String note;
    private String salaryByHour;

    public Employee() {
    }

    public Employee(int id, String name, String surname, String address, String phoneNumber, String note, String salaryByHour) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.note = note;
        this.salaryByHour = salaryByHour;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getSalaryByHour() {
        return salaryByHour;
    }

    public void setSalaryByHour(String salaryByHour) {
        this.salaryByHour = salaryByHour;
    }
}
