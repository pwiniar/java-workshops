package com.pluralsight.service;

import com.pluralsight.model.Customer;
import com.pluralsight.repository.CustomerRepository;
import com.pluralsight.repository.HibernateCustomerRepository;

import java.util.List;

/**
 * Created by Pawel on 2016-11-22.
 */
public class hardcodedCustomerService implements CustomerService {

    private CustomerRepository customerRepository =  new HibernateCustomerRepository();

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

}
