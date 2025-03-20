package com.SpringBoot.Point_of_Sale.dto.paginated;

import com.SpringBoot.Point_of_Sale.dto.request.ResponseOrderDetailsDTO;
import java.util.List;

public class PaginatedResponseOrderDetails {
    private List<ResponseOrderDetailsDTO> orderDetails;
    private long totalElements;

    public PaginatedResponseOrderDetails() {
    }

    public PaginatedResponseOrderDetails(List<ResponseOrderDetailsDTO> orderDetails, long totalElements) {
        this.orderDetails = orderDetails;
        this.totalElements = totalElements;
    }

    // Getters and setters

    public List<ResponseOrderDetailsDTO> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<ResponseOrderDetailsDTO> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }
}