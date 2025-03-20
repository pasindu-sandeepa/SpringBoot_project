package com.SpringBoot.Point_of_Sale.controller;


import com.SpringBoot.Point_of_Sale.dto.request.RequestOrderSaveDTO;
import com.SpringBoot.Point_of_Sale.service.OrderService;
import com.SpringBoot.Point_of_Sale.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/order")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;

    // Save Item
    @PostMapping(
            path = "/save"
    )
    public ResponseEntity<StandardResponse> saveItem(@RequestBody RequestOrderSaveDTO requestOrderSaveDTO){
        String id = orderService.addOrder(requestOrderSaveDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"success",id),
                HttpStatus.CREATED
        );
    }
}
