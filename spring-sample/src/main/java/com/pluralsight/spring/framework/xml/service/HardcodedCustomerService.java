package com.pluralsight.spring.framework.xml.service;

import com.pluralsight.spring.framework.xml.model.Customer;
import com.pluralsight.spring.framework.xml.repository.CustomerRepository;
import com.pluralsight.spring.framework.xml.repository.HibernateCustomerRepository;

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
