package com.SpringBoot.Point_of_Sale.service;

import com.SpringBoot.Point_of_Sale.dto.paginated.PaginatedResponseOrderDetails;
import com.SpringBoot.Point_of_Sale.dto.request.RequestOrderSaveDTO;

public interface OrderService {
    String addOrder(RequestOrderSaveDTO requestOrderSaveDTO);

    PaginatedResponseOrderDetails getAllOrderDetails(boolean status, int page, int size);
}
