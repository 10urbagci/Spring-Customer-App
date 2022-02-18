package com.aselsis.aselmanager.controller;

import com.aselsis.aselmanager.dto.SaveCustomerDto;
import com.aselsis.aselmanager.dto.UpdateCustomerDto;
import com.aselsis.aselmanager.model.Customer;
import com.aselsis.aselmanager.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {
    private final CustomerService customerService;


    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;

    }

    @GetMapping("/all")
    public List<Customer> findAll() {
        return customerService.findAll();
    }

    @PostMapping("/save")
    public Customer saveCustomer(@RequestBody SaveCustomerDto saveCustomerDto) {

        return customerService.addCustomer(saveCustomerDto);
    }

    @PutMapping("/{id}")
    public Customer replaceCustomer(@RequestBody UpdateCustomerDto customerDto, @PathVariable Integer id) {
        return customerService.updateCustomer(id, customerDto);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Integer id) {
        customerService.deleteById(id);
    }

    @GetMapping("/{id}")
    Customer findById(@PathVariable Integer id) {
        return customerService.findById(id);
    }
}