package com.pluralsight.annot;

import com.pluralsight.annot.model.Customer;
import com.pluralsight.annot.service.CustomerService;
import com.pluralsight.annot.service.HardcodedCustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Pawel on 2016-11-22.
 */
public class Application {

    private static ApplicationContext applicationContext;

    public static void main(String[] args) {

        applicationContext = new ClassPathXmlApplicationContext("annotapplicationContext.xml");
        CustomerService customerService = applicationContext.getBean("customerService", CustomerService.class);

        System.out.println("Application Name=" + applicationContext.getApplicationName());
        System.out.println("Display Name="+ applicationContext.getDisplayName());

        print(customerService);
    }

    private static void print(CustomerService service) {
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
