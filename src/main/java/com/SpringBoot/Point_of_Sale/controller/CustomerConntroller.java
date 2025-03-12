package com.SpringBoot.Point_of_Sale.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/customer")
public class CustomerConntroller {

    @GetMapping(path = "/customer1")
    public String getMyText(){
        String myTest = "adoooo";
        return myTest;
    }
    @GetMapping(path = "/customer2")
    public String getMyText1(){
        String myTest = "carima happy";
        return myTest;
    }
}
