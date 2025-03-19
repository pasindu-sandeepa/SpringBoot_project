package com.SpringBoot.Point_of_Sale.controller;


import com.SpringBoot.Point_of_Sale.dto.request.RequestOrderSaveDTO;
import com.SpringBoot.Point_of_Sale.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/order")
@CrossOrigin
public class OrderController {

    // Save Item
    @PostMapping(
            path = "/save"
    )
    public ResponseEntity<StandardResponse> saveItem(@RequestBody RequestOrderSaveDTO requestOrderSaveDTO){
       System.out.println(requestOrderSaveDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"success",1),
                HttpStatus.CREATED
        );
    }
}
