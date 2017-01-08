package com.pluralsight.annot.spring.service;

import com.pluralsight.spring.framework.xml.model.Customer;
import com.pluralsight.spring.framework.xml.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Pawel on 2016-11-22.
 */
@Service("customerServiceAnnot")
public class HardcodedCustomerService implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

}
