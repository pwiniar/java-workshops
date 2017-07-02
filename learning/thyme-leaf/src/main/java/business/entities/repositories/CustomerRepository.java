package business.entities.repositories;

import business.entities.Customer;

import java.util.List;

/**
 * Created by Winiar on 02.07.2017.
 */
public interface CustomerRepository {
    List<Customer> findAll();

    Customer findById(Integer id);
}
