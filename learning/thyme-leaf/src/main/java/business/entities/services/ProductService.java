package business.entities.services;

import business.entities.Product;

import java.util.List;

/**
 * Created by Winiar on 02.07.2017.
 */
public interface ProductService {
    List<Product> findAll();

    Product findById(Integer id);
}
