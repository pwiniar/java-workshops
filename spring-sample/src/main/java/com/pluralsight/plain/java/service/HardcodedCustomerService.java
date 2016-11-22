package com.pluralsight.plain.java.service;

import com.pluralsight.plain.java.model.Customer;
import com.pluralsight.plain.java.repository.CustomerRepository;
import com.pluralsight.plain.java.repository.HibernateCustomerRepository;

import java.util.List;

/**
 * Created by Pawel on 2016-11-22.
 */
public class HardcodedCustomerService implements CustomerService {

    private CustomerRepository customerRepository =  new HibernateCustomerRepository();

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

}
