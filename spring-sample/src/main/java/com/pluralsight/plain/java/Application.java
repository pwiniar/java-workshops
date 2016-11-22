package com.pluralsight.plain.java;

import com.pluralsight.plain.java.service.CustomerService;
import com.pluralsight.plain.java.service.HardcodedCustomerService;

/**
 * Created by Pawel on 2016-11-22.
 */
public class Application {

    public static void main(String[] args) {

        CustomerService service = new HardcodedCustomerService();

        service.findAll().stream()
                .map(s -> {
                    //map for transformation purposes
                    for (int i = 0; i < service.findAll().size(); i++) {
                        s.setLastName(s.getLastName().toUpperCase());
                        s.setFirstName(s.getFirstName().toUpperCase());
                    }
                    return s;
                })
                .forEach(s -> {
                    System.out.format("Hi Customer %s %s",
                            s.getFirstName(), s.getLastName());
                });


    }

}
