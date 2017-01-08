package com.pluralsight.purejava.java.service;

import com.pluralsight.purejava.java.model.Customer;
import com.pluralsight.purejava.java.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Pawel on 2016-11-22.
 */
public class HardcodedCustomerService implements CustomerService {

    private CustomerRepository customerRepository;

    public HardcodedCustomerService() {
    }

    public HardcodedCustomerService(CustomerRepository customerRepository) {
        System.out.println("We are using constructor injection code");
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        System.out.println("We are using setter injection code");
        this.customerRepository = customerRepository;
    }
}

