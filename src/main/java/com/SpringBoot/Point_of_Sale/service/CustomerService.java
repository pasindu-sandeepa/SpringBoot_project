package com.SpringBoot.Point_of_Sale.service;

import com.SpringBoot.Point_of_Sale.dto.CustomerDTO;
import com.SpringBoot.Point_of_Sale.dto.request.CustomerUpdateDTO;

public interface CustomerService {
  public String saveCustomer(CustomerDTO customerDTO);

  String updateCustomer(CustomerUpdateDTO customerUpdateDTO);

  CustomerDTO getCustomerById(int customerId);
}
