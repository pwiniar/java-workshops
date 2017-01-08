package com.pluralsight.purejava.java;

import com.pluralsight.purejava.java.repository.CustomerRepository;
import com.pluralsight.purejava.java.repository.HibernateCustomerRepository;
import com.pluralsight.purejava.java.service.CustomerService;
import com.pluralsight.purejava.java.service.HardcodedCustomerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by winiar on 08/01/2017.
 */

@Configuration
@ComponentScan({"com.pluralsight.purejava.java"})
public class AppConfig {

    @Bean(name = "customerService")
    public CustomerService getCustomerService(){
//        HardcodedCustomerService customerService = new HardcodedCustomerService(getCustomerRepository());

        HardcodedCustomerService customerService = new HardcodedCustomerService();
        //customerService.setCustomerRepository(getCustomerRepository());

        return customerService;
    }

    @Bean(name = "customerRepository")
    public CustomerRepository getCustomerRepository(){
        return new HibernateCustomerRepository();
    }



}
