package com.pluralsight.spring.framework.xml.service;

import com.pluralsight.spring.framework.xml.model.Customer;

import java.util.List;

/**
 * Created by Pawel on 2016-11-22.
 */
public interface CustomerService {
    List<Customer> findAll();
}