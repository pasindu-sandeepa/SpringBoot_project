package com.SpringBoot.Point_of_Sale.dto;

public class CustomerDTO {
    private int customerID;
    private String customerName;
    private String customerAddress;
    private int contactNumber;
    private String email;
    private double customerSalary;
    private String nic;
    private boolean active;

    public CustomerDTO() {
    }

    public CustomerDTO(boolean active, String nic, double customerSalary, String email, int contactNumber, String customerAddress, String customerName, int customerID) {
        this.active = active;
        this.nic = nic;
        this.customerSalary = customerSalary;
        this.email = email;
        this.contactNumber = contactNumber;
        this.customerAddress = customerAddress;
        this.customerName = customerName;
        this.customerID = customerID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public int getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(int contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getCustomerSalary() {
        return customerSalary;
    }

    public void setCustomerSalary(double customerSalary) {
        this.customerSalary = customerSalary;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "customerID=" + customerID +
                ", customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", contactNumber=" + contactNumber +
                ", email='" + email + '\'' +
                ", customerSalary=" + customerSalary +
                ", nic='" + nic + '\'' +
                ", active=" + active +
                '}';
    }
}
