package com.aselsis.aselmanager.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.aselsis.aselmanager.dto.SaveCustomerDto;
import com.aselsis.aselmanager.model.Customer;
import com.aselsis.aselmanager.service.CustomerService;
import java.util.List;


@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }
    @GetMapping("/all")
    public List<Customer> findAll(){
        return customerService.findAll();
    }
    @PostMapping("/save")
    public Customer saveCustomer(@RequestBody SaveCustomerDto saveCustomerDto){

        return customerService.addCustomer(saveCustomerDto);
    }
}