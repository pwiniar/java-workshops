package com.pluralsight.purejava.java;

import com.pluralsight.purejava.java.service.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Pawel on 2016-11-22.
 */
public class Application {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        CustomerService service = applicationContext.getBean("customerService", CustomerService.class);

        print(service);
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
                    System.out.format("Hi Customer %s %s \n",
                            s.getFirstName(), s.getLastName());
                });
    }

}
