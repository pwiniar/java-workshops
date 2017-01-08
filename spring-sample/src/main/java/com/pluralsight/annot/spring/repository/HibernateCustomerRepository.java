package com.pluralsight.annot.spring.repository;

import com.pluralsight.spring.framework.xml.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pawel on 2016-11-22.
 */

@Repository("customerRepository")
public class HibernateCustomerRepository implements CustomerRepository {

    public List<Customer> findAll() {
        List<Customer> customers = new ArrayList();

        Customer customer = new Customer();

        customer.setFirstName("Pawel");
        customer.setLastName("Winiarski");

        customers.add(customer);

        return customers;
    }
}
