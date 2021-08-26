package com.aselsis.aselmanager.service;

import com.aselsis.aselmanager.dto.SaveCustomerDto;
import com.aselsis.aselmanager.dto.UpdateCustomerDto;
import com.aselsis.aselmanager.model.Customer;

import java.util.List;

public interface CustomerService {

    Customer addCustomer(SaveCustomerDto saveCustomerDto);

    List<Customer> findAll();

    Customer updateCustomer(Integer customerId, UpdateCustomerDto updateCustomerDto);

    void deleteById(Integer id);

    Customer findById(Integer id);


}
