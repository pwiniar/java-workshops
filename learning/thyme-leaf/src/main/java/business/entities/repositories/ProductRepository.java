package business.entities.repositories;

import business.entities.Product;

import java.util.List;

/**
 * Created by Winiar on 02.07.2017.
 */
public interface ProductRepository {

    public List<Product> findAll();

    public Product findById(final Integer id);
}
