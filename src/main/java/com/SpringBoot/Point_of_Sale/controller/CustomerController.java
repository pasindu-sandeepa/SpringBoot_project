package com.SpringBoot.Point_of_Sale.controller;


import com.SpringBoot.Point_of_Sale.dto.CustomerDTO;
import com.SpringBoot.Point_of_Sale.dto.request.CustomerUpdateDTO;
import com.SpringBoot.Point_of_Sale.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
@CrossOrigin

public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @PostMapping("/save")
    public String saveCustomer(@RequestBody CustomerDTO customerDTO){
    customerService.saveCustomer(customerDTO);
       return "saved";
    }

    @PutMapping("/update")
    public String updateCustomer(@RequestBody CustomerUpdateDTO customerUpdateDTO){
    String message = customerService.updateCustomer(customerUpdateDTO);
    return(message);
    }

    @GetMapping(
            path = "/get-by-id",
            params = {"id"}
    )
    public CustomerDTO getCustomerById(@RequestParam(value = "id") int customerId){
      CustomerDTO customerDTO = customerService.getCustomerById(customerId);
      return customerDTO;
    }
}
