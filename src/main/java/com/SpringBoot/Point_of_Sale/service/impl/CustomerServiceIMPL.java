package com.SpringBoot.Point_of_Sale.service.impl;

import com.SpringBoot.Point_of_Sale.dto.CustomerDTO;
import com.SpringBoot.Point_of_Sale.dto.request.CustomerUpdateDTO;
import com.SpringBoot.Point_of_Sale.entity.Customer;
import com.SpringBoot.Point_of_Sale.repo.CustomerRepo;
import com.SpringBoot.Point_of_Sale.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public String saveCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer(
               customerDTO.getCustomerID(),
                customerDTO.isActive(),
                customerDTO.getNic(),
                customerDTO.getEmail(),
                customerDTO.getCustomerSalary(),
                customerDTO.getContactNumber(),
                customerDTO.getCustomerName(),
                customerDTO.getCustomerAddress()
        );
        customerRepo.save(customer);
        return customerDTO.getCustomerName();
    }

    @Override
    public String updateCustomer(CustomerUpdateDTO customerUpdateDTO) {
      if(customerRepo.existsById(customerUpdateDTO.getCustomerID())){
          Customer customer = customerRepo.getReferenceById(customerUpdateDTO.getCustomerID());

          customer.setCustomerName(customerUpdateDTO.getCustomerName());
          customer.setCustomerSalary(customerUpdateDTO.getCustomerSalary());
          customer.setContactNumber(customerUpdateDTO.getContactNumber());
          customer.setEmail(customerUpdateDTO.getEmail());
          customer.setCustomerAddress(customerUpdateDTO.getCustomerAddress());

          customerRepo.save(customer);
          return customerUpdateDTO.getCustomerName() + "updated Succesfull";

      }else{
          throw new RuntimeException("Customer not found");
      }

    }

    @Override
    public CustomerDTO getCustomerById(int customerId) {
        if(customerRepo.existsById(customerId)) {
            Customer customer = customerRepo.getReferenceById(customerId);
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.isActive(),
                    customer.getNic(),
                    customer.getCustomerSalary(),
                    customer.getEmail(),
                    customer.getContactNumber(),
                    customer.getCustomerAddress(),
                    customer.getCustomerName(),
                    customer.getCustomerID()
            );
            return customerDTO;
        }  else {
            throw new RuntimeException("Customer not found");

        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> getAllCustomers = customerRepo.findAll();
        List<CustomerDTO> customerDTOList = new ArrayList<>();

       for(Customer customer : getAllCustomers){
           CustomerDTO customerDTO = new CustomerDTO(
                   customer.isActive(),
                   customer.getNic(),
                   customer.getCustomerSalary(),
                   customer.getEmail(),
                   customer.getContactNumber(),
                   customer.getCustomerAddress(),
                   customer.getCustomerName(),
                   customer.getCustomerID()
           );
           customerDTOList.add(customerDTO);
       }
        return customerDTOList;
    }

    @Override
    public String deletedCustomer(int customerId) {
        if(customerRepo.existsById(customerId)){
            customerRepo.deleteById(customerId);
            return "Customer Deleted Succesfull" + customerId;
            }else {
            throw new RuntimeException("Customer not found");
        }

    }


}
