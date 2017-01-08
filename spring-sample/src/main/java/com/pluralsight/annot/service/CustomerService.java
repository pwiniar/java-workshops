package com.pluralsight.annot.service;

import com.pluralsight.annot.model.Customer;

import java.util.List;

/**
 * Created by Pawel on 2016-11-22.
 */
public interface CustomerService {
    List<Customer> findAll();
}
