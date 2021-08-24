package com.aselsis.aselmanager.controller;


import com.aselsis.aselmanager.dto.UpdateCustomerDto;
import com.aselsis.aselmanager.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.aselsis.aselmanager.dto.SaveCustomerDto;
import com.aselsis.aselmanager.model.Customer;
import com.aselsis.aselmanager.service.CustomerService;

import java.util.List;


@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {
    private final CustomerService customerService;

    private final CustomerRepository customerRepository;


    @Autowired
    public CustomerController(CustomerService customerService, CustomerRepository customerRepository){
        this.customerService = customerService;
        this.customerRepository = customerRepository;
    }
    @GetMapping("/all")
    public List<Customer> findAll(){
        return customerService.findAll();
    }
    @PostMapping("/save")
    public Customer saveCustomer(@RequestBody SaveCustomerDto saveCustomerDto){

        return customerService.addCustomer(saveCustomerDto);
    }
    @PutMapping("/customer/{id}")
    public Customer replaceCustomer(@RequestBody UpdateCustomerDto customerDto, @PathVariable Integer id){
        return customerService.updateCustomer(id,customerDto);
    }

    @DeleteMapping("/customer/{id}")
    public void deleteCustomer(@PathVariable Integer id){
        customerRepository.deleteById(id);
    }
    @GetMapping("/customer/{id}")
    public List<Customer> findAll(@PathVariable Integer id){
        return customerService.findAll();
    }
}