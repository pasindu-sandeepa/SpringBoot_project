package com.SpringBoot.Point_of_Sale.entity;

import com.SpringBoot.Point_of_Sale.entity.enums.MeasuringUnitType;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="item")


public class Item {

    @Id
    @Column(name = "item_id",length = 40)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int itemId;

    @Column(name = "item_name",length = 40,nullable = false)
    private String itemName;

    @Enumerated(EnumType.STRING)
    @Column(name = "measure_type",length = 40,nullable = false)
    private MeasuringUnitType measuringUnitType;

    @Column(name = "balance_qty",length = 40,nullable = false)
    private double balanceQty;

    @Column(name = "supplier_price",length = 40,nullable = false)
    private double supplierPrice;

    @Column(name = "selling_price",length = 40,nullable = false)
    private double sellingPrice;

    @Column(name = "active_state",columnDefinition = "TINYINT default 1")
    private boolean activeState;

    @OneToMany(mappedBy = "items")
    private Set<OrderDetails> orderDetails;




    public Item() {
    }

    public Item(int itemId, boolean activeState, double sellingPrice, double supplierPrice, double balanceQty, MeasuringUnitType measuringUnitType, String itemName) {
        this.itemId = itemId;
        this.activeState = activeState;
        this.sellingPrice = sellingPrice;
        this.supplierPrice = supplierPrice;
        this.balanceQty = balanceQty;
        this.measuringUnitType = measuringUnitType;
        this.itemName = itemName;
    }

    public Item(int itemId, String itemName, MeasuringUnitType measuringUnitType, double balanceQty, double supplierPrice, double sellingPrice) {
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public boolean isActiveState() {
        return activeState;
    }

    public void setActiveState(boolean activeState) {
        this.activeState = activeState;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public double getSupplierPrice() {
        return supplierPrice;
    }

    public void setSupplierPrice(double supplierPrice) {
        this.supplierPrice = supplierPrice;
    }

    public double getBalanceQty() {
        return balanceQty;
    }

    public void setBalanceQty(double balanceQty) {
        this.balanceQty = balanceQty;
    }

    public MeasuringUnitType getMeasuringUnitType() {
        return measuringUnitType;
    }

    public void setMeasuringUnitType(MeasuringUnitType measuringUnitType) {
        this.measuringUnitType = measuringUnitType;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", measuringUnitType=" + measuringUnitType +
                ", balanceQty=" + balanceQty +
                ", supplierPrice=" + supplierPrice +
                ", sellingPrice=" + sellingPrice +
                ", activeState=" + activeState +
                '}';
    }
}
