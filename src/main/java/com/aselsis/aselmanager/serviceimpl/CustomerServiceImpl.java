package com.aselsis.aselmanager.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aselsis.aselmanager.dto.SaveCustomerDto;
import com.aselsis.aselmanager.model.Customer;
import com.aselsis.aselmanager.repository.CustomerRepository;
import com.aselsis.aselmanager.service.CustomerService;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    @Override
    public Customer addCustomer(SaveCustomerDto saveCustomerDto) {
        Customer customer = new Customer();

        customer.setName(saveCustomerDto.getName());
        customer.setSurname(saveCustomerDto.getSurname());
        customer.setAge(saveCustomerDto.getAge());
        customer.setEmail(saveCustomerDto.getEmail());

        customer = customerRepository.save(customer);

        return customer;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
