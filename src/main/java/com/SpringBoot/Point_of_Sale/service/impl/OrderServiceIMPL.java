package com.SpringBoot.Point_of_Sale.service.impl;

import com.SpringBoot.Point_of_Sale.dto.request.RequestOrderSaveDTO;
import com.SpringBoot.Point_of_Sale.dto.request.ResponseOrderDetailsDTO;
import com.SpringBoot.Point_of_Sale.dto.paginated.PaginatedResponseOrderDetails;
import com.SpringBoot.Point_of_Sale.entity.OrderDetails;
import com.SpringBoot.Point_of_Sale.repo.CustomerRepo;
import com.SpringBoot.Point_of_Sale.repo.ItemRepo;
import com.SpringBoot.Point_of_Sale.repo.OrderDetailsRepo;
import com.SpringBoot.Point_of_Sale.repo.OrderRepo;
import com.SpringBoot.Point_of_Sale.service.OrderService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.SpringBoot.Point_of_Sale.entity.Order;
import java.util.List;
import com.fasterxml.jackson.core.type.TypeReference;
import com.SpringBoot.Point_of_Sale.dto.queryinterfaces.OrderDetailsInterface;
import java.util.ArrayList;

@Service
@Transactional
public class OrderServiceIMPL implements OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private OrderDetailsRepo orderDetailRepo;

    // Add Order
    @Override
    @Transactional
    public String addOrder(RequestOrderSaveDTO requestOrderSaveDTO) {
        Order order = new Order(
            customerRepo.getById(requestOrderSaveDTO.getCustomers()),
                requestOrderSaveDTO.getDate(),
                requestOrderSaveDTO.getTotal()
        );
        orderRepo.save(order);

        if(orderRepo.existsById(order.getOrderId())){
            List<OrderDetails> orderDetails = modelMapper.map(
                    requestOrderSaveDTO.getOrderDetails(),
                    new TypeReference<List<OrderDetails>>() {}.getType()
            );
            for(int i=0; i < orderDetails.size(); i++){
                orderDetails.get(i).setOrders(order);
                orderDetails.get(i).setItems(itemRepo.getById(requestOrderSaveDTO.getOrderDetails().get(i).getItems()));
            }

            if(orderDetails.size() > 0){
            orderDetailRepo.saveAll(orderDetails);
        }
            return "Saved";
        }
        return null;
    }

    // Get Order Details
    @Override
    public PaginatedResponseOrderDetails getAllOrderDetails(boolean status, int page, int size) {
    List<OrderDetailsInterface> orderDetailsDTOS = orderRepo.getAllOrderDetails(status, PageRequest.of(page,size));

    List<ResponseOrderDetailsDTO> list = new ArrayList<>();
    for(OrderDetailsInterface orderDetailsInterface : orderDetailsDTOS){
        ResponseOrderDetailsDTO responseOrderDetailsDTO = new ResponseOrderDetailsDTO(
                orderDetailsInterface.getCustomerName(),
                orderDetailsInterface.getCustomerAddress(),
                orderDetailsInterface.getCustomerContact(),
                orderDetailsInterface.getDate(),
                orderDetailsInterface.getTotal()
        );
        list.add(responseOrderDetailsDTO);
    }
    PaginatedResponseOrderDetails paginatedResponseOrderDetails = new PaginatedResponseOrderDetails(
            list,
            orderRepo.countAllOrderDetails(status)
    );
    return paginatedResponseOrderDetails;
    }

}