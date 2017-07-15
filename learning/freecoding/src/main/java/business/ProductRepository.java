package business;

import java.util.List;

/**
 * Created by Winiar on 02.07.2017.
 */
public interface ProductRepository {
    public List<Product> findAll();

    public Product findById(int id);

    public Product findByName(String name);

    public Product findByPrice(double price);

}
