package com.SpringBoot.Point_of_Sale.dto.request;

import java.util.Date;
import java.util.List;

public class RequestOrderSaveDTO {


    private int customers;
    private Date date;
    private List<RequestOrderDetailsSave> orderDetails;
    private double total;

    public RequestOrderSaveDTO() {
    }

    public RequestOrderSaveDTO(int customers, Date date, double total, List<RequestOrderDetailsSave> orderDetails) {
        this.customers = customers;
        this.date = date;
        this.total = total;
        this.orderDetails = orderDetails;
    }

    public int getCustomers() {
        return customers;
    }

    public void setCustomers(int customers) {
        this.customers = customers;
    }

    public List<RequestOrderDetailsSave> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<RequestOrderDetailsSave> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
