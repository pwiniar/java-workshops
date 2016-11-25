package com.pluralsight.spring.framework.xml;

import com.pluralsight.spring.framework.xml.service.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Pawel on 2016-11-22.
 */
public class Application {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//
//        CustomerService service = applicationContext.getBean("customerServiceSetterInjection", CustomerService.class);
//
//        printResult(service);
//
//        CustomerService service1 = applicationContext.getBean("customerServiceConstructIndjection", CustomerService.class);
//
//        printResult(service1);

        CustomerService service2 = applicationContext.getBean("customerServiceAutowire1", CustomerService.class);

        printResult(service2);

    }

    private static void printResult(CustomerService service) {
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
                    System.out.format("Hi Customer %s %s\n",
                            s.getFirstName(), s.getLastName());
                });
    }
}
