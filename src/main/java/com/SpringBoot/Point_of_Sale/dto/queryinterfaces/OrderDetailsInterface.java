package com.SpringBoot.Point_of_Sale.dto.queryinterfaces;

import java.util.Date;

public interface OrderDetailsInterface {
    String getCustomerName();
    String getCustomerAddress();
    String getCustomerContact();
    Date getDate();
    double getTotal();
}