package com.pluralsight.annot.service;

import com.pluralsight.annot.model.Customer;
import com.pluralsight.annot.repository.CustomerRepository;
import com.pluralsight.annot.repository.HibernateCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Pawel on 2016-11-22.
 */

@Service("customerService")
public class HardcodedCustomerService implements CustomerService {

    //@Autowired
    private CustomerRepository customerRepository;

    @Autowired
    public HardcodedCustomerService(CustomerRepository customerRepository) {
        System.out.println("We are using constructor injection");
        this.customerRepository = customerRepository;
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    //@Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        System.out.println("We are using setter injection");
        this.customerRepository = customerRepository;
    }
}
