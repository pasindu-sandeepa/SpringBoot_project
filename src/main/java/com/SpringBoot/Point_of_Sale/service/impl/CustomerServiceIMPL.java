package com.SpringBoot.Point_of_Sale.service.impl;

import com.SpringBoot.Point_of_Sale.dto.CustomerDTO;
import com.SpringBoot.Point_of_Sale.dto.request.CustomerUpdateDTO;
import com.SpringBoot.Point_of_Sale.entity.Customer;
import com.SpringBoot.Point_of_Sale.repo.CustomerRepo;
import com.SpringBoot.Point_of_Sale.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;

import java.util.ArrayList;
import java.util.List;

@Service
public class  CustomerServiceIMPL implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper modelMapper;

    // Save Customer
    @Override
    public String saveCustomer(CustomerDTO customerDTO) {
        Customer customer = modelMapper.map(customerDTO, Customer.class);
        customerRepo.save(customer);
        return customerDTO.getCustomerName();
    }

    // Update Customer
    @Override
    public String updateCustomer(CustomerUpdateDTO customerUpdateDTO) {
        // Check if a customer with the given ID exists
        if (customerRepo.existsById(customerUpdateDTO.getCustomerID())) {
            // Retrieve the existing Customer entity
            Customer customer = customerRepo.getReferenceById(customerUpdateDTO.getCustomerID());

            // Map the properties of CustomerUpdateDTO to the retrieved Customer entity
            modelMapper.map(customerUpdateDTO, customer);

            // Save the updated Customer entity
            customerRepo.save(customer);

            // Return a confirmation message
            return customerUpdateDTO.getCustomerName() + " updated Successfully";

        } else {
            // Throw an exception if the customer is not found
            throw new RuntimeException("Customer not found");
        }
    }


    // Get Customer by ID
    @Override
    public CustomerDTO getCustomerById(int customerId) {
        if (customerRepo.existsById(customerId)) {
            // Retrieve the Customer entity
            Customer customer = customerRepo.getReferenceById(customerId);

            // Use ModelMapper to map Customer to CustomerDTO
            return modelMapper.map(customer, CustomerDTO.class);
        } else {
            // Throw an exception if the Customer is not found
            throw new RuntimeException("Customer not found");
        }
    }


    // Get all Customers
    @Override
    public List<CustomerDTO> getAllCustomers() {
        // Retrieve all customers from the database
        List<Customer> getAllCustomers = customerRepo.findAll();

        // Use ModelMapper to map the list of Customers to a list of CustomerDTOs
        List<CustomerDTO> customerDTOList = getAllCustomers.stream()
                .map(customer -> modelMapper.map(customer, CustomerDTO.class))
                .collect(Collectors.toList());

        return customerDTOList;
    }

    // Delete Customer
    @Override
    public String deletedCustomer(int customerId) {
        if(customerRepo.existsById(customerId)){
            customerRepo.deleteById(customerId);
            return "Customer Deleted Succesfull" + customerId;
            }else {
            throw new RuntimeException("Customer not found");
        }

    }


    // Get all Customers by Active State
   @Override
   public List<CustomerDTO> getAllCustomersByActiveState(boolean activeState) {
       List<Customer> getAllCustomers = customerRepo.findAllByActive(activeState);

       return getAllCustomers.stream()
               .map(customer -> modelMapper.map(customer, CustomerDTO.class))
               .collect(Collectors.toList());
   }


}