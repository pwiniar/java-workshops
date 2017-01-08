package com.pluralsight.purejava.java.repository;

import com.pluralsight.purejava.java.model.Customer;

import java.util.List;

/**
 * Created by Pawel on 2016-11-22.
 */
public interface CustomerRepository {
    List<Customer> findAll();
}
