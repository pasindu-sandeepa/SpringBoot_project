package com.SpringBoot.Point_of_Sale.dto.request;

import com.SpringBoot.Point_of_Sale.entity.enums.MeasuringUnitType;

public class ItemSaveRequestDTO {

    private int itemId;
    private String itemName;
    private MeasuringUnitType measuringUnitType;
    private double balanceQty;
    private double supplierPrice;
    private double sellingPrice;
    private boolean activeState;

    public ItemSaveRequestDTO() {
    }

    public ItemSaveRequestDTO(int itemId, String itemName, MeasuringUnitType measuringUnitType, double balanceQty, double supplierPrice, double sellingPrice, boolean activeState) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.measuringUnitType = measuringUnitType;
        this.balanceQty = balanceQty;
        this.supplierPrice = supplierPrice;
        this.sellingPrice = sellingPrice;
        this.activeState = activeState;
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

    public double getSupplierPrice() {
        return supplierPrice;
    }

    public void setSupplierPrice(double supplierPrice) {
        this.supplierPrice = supplierPrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
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
        return "ItemSaveRequestDTO{" +
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
