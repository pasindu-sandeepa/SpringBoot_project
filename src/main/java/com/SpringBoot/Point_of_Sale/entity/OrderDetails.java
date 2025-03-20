package com.SpringBoot.Point_of_Sale.entity;
import jakarta.persistence.*;

@Entity
@Table(name="Order_details")

public class OrderDetails {

    @Id
    @Column(name="order_details_id",length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderDetailsId;

    @Column(name="item_name",length = 100,nullable = false)
    private String itemName;

    @Column(name="qty",length = 100,nullable = false)
    private double qty;

    @Column(name="amount",length = 100,nullable = false)
    private double amount;

    @ManyToOne
    @JoinColumn(name="order_id",nullable = false)
    private Order orders;

    @ManyToOne
    @JoinColumn(name="item_id",nullable = false)
    private Item items;

    public OrderDetails() {
    }

    public OrderDetails(int orderDetailsId, Item items, Order orders, double amount, double qty, String itemName) {
        this.orderDetailsId = orderDetailsId;
        this.items = items;
        this.orders = orders;
        this.amount = amount;
        this.qty = qty;
        this.itemName = itemName;
    }

    public int getOrderDetailsId() {
        return orderDetailsId;
    }

    public void setOrderDetailsId(int orderDetailsId) {
        this.orderDetailsId = orderDetailsId;
    }

    public Item getItems() {
        return items;
    }

    public void setItems(Item items) {
        this.items = items;
    }

    public Order getOrders() {
        return orders;
    }

    public void setOrders(Order orders) {
        this.orders = orders;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
