package com.aselsis.aselmanager.service;

import com.aselsis.aselmanager.dto.SaveCustomerDto;
import com.aselsis.aselmanager.model.Customer;


import java.util.List;

public interface CustomerService {
    Customer addCustomer(SaveCustomerDto saveCustomerDto);

    List<Customer> findAll();
}
