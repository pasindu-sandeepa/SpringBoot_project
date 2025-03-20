package com.SpringBoot.Point_of_Sale.controller;


import com.SpringBoot.Point_of_Sale.dto.paginated.PaginatedResponseOrderDetails;
import com.SpringBoot.Point_of_Sale.dto.request.RequestOrderSaveDTO;
import com.SpringBoot.Point_of_Sale.service.OrderService;
import com.SpringBoot.Point_of_Sale.util.StandardResponse;
import jakarta.validation.constraints.Max;
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



    //join query
    // Get All Items
    @GetMapping(
            params = {"stateType","page","size"},
            path = {"/get-order-details"}
    )
    public ResponseEntity<StandardResponse> getOrderDetails(
            @RequestParam("stateType") String stateType,
            @RequestParam("page") int page,
            @RequestParam("size") @Max(50) int size){

        PaginatedResponseOrderDetails p = null;
        if(stateType.equalsIgnoreCase("active") | stateType.equalsIgnoreCase("inactive")){
            boolean status = stateType.equalsIgnoreCase("active") ? true : false;
            p = orderService.getAllOrderDetails(status,page,size);
        }
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"success",p),
                HttpStatus.OK

        );
    }
}
