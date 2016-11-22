package com.pluralsight.plain.java.repository;

import com.pluralsight.plain.java.model.Customer;

import java.util.List;

/**
 * Created by Pawel on 2016-11-22.
 */
public interface CustomerRepository {
    List<Customer> findAll();
}
