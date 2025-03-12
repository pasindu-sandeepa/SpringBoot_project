package com.SpringBoot.Point_of_Sale.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/test")
public class TestController {

    @GetMapping(path = "/get1")
    public String getMyText(){
        String myTest = "This is my first spring";
        return myTest;
    }
    @GetMapping(path = "/get2")
    public String getMyText1(){
        String myTest = "This is my second spring";
        return myTest;
    }

}
