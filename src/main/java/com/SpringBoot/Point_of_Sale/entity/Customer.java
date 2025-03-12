package com.SpringBoot.Point_of_Sale.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer")

public class Customer {
    @Id
    @Column(name = "customer_id",length = 40)
    private int customerID;

    @Column(name = "customer_name",length = 40,nullable = false)
    private String customerName;

    @Column(name = "customer_address",length = 250)
    private String customerAddress;

    @Column(name = "contact_number",length = 15)
    private int contactNumber;

    @Column(name = "email",length = 40)
    private String email;

    @Column(name = "customer_salary")
    private double customerSalary;

    @Column(name = "nic",length = 15)
    private String nic;

    @Column(name = "active_state",columnDefinition = "TINYINT default 1")
    private boolean active;

    public Customer() {
    }

    public Customer(int customerID, boolean active, String nic, String email, double customerSalary, int contactNumber, String customerName, String customerAddress) {
        this.customerID = customerID;
        this.active = active;
        this.nic = nic;
        this.email = email;
        this.customerSalary = customerSalary;
        this.contactNumber = contactNumber;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public double getCustomerSalary() {
        return customerSalary;
    }

    public void setCustomerSalary(double customerSalary) {
        this.customerSalary = customerSalary;
    }

    @Override
    public String toString() {
        return "Customer{" +
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

