package com.pluralsight.annot.repository;

import com.pluralsight.annot.model.Customer;

import java.util.List;

/**
 * Created by Pawel on 2016-11-22.
 */
public interface CustomerRepository {
    List<Customer> findAll();
}
