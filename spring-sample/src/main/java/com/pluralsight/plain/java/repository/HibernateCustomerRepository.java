package com.pluralsight.plain.java.repository;

import com.pluralsight.plain.java.model.Customer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pawel on 2016-11-22.
 */
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
