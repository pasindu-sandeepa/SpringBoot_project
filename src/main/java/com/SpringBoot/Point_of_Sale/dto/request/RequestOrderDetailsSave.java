package com.SpringBoot.Point_of_Sale.dto.request;

public class RequestOrderDetailsSave {
    private String itemName;
    private double qty;
    private double amount;
    private int orders;
    private int items;

    public RequestOrderDetailsSave() {
    }

    public RequestOrderDetailsSave(String itemName, int items, int orders, double amount, double qty) {
        this.itemName = itemName;
        this.items = items;
        this.orders = orders;
        this.amount = amount;
        this.qty = qty;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItems() {
        return items;
    }

    public void setItems(int items) {
        this.items = items;
    }

    public int getOrders() {
        return orders;
    }

    public void setOrders(int orders) {
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
}
