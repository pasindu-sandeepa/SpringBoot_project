package com.SpringBoot.Point_of_Sale.entity;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="Orders")
public class Order {

    @Id
    @Column(name="order_id", length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;

    @ManyToOne
    @JoinColumn(name= "customer_id", nullable = false)
    private Customer customers;

    @Column(name="order_date", columnDefinition = "DATETIME")
    private Date date;

    @Column(name="total", nullable = false)
    private double total;

    @OneToMany(mappedBy = "orders")
    private Set<OrderDetails> orderDetails;

    public Order() {
    }

    public Order(int orderId, Set<OrderDetails> orderDetails, double total, Date date, Customer customers) {
        this.orderId = orderId;
        this.orderDetails = orderDetails;
        this.total = total;
        this.date = date;
        this.customers = customers;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Customer getCustomers() {
        return customers;
    }

    public void setCustomers(Customer customers) {
        this.customers = customers;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Set<OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Set<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
