package com.pluralsight.purejava.java.repository;

import com.pluralsight.purejava.java.model.Customer;

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

        Customer customer1 = new Customer();
        customer1.setFirstName("Jola");
        customer1.setLastName("Bartos-Winiarska");

        customers.add(customer);
        customers.add(customer1);

        return customers;
    }

}
