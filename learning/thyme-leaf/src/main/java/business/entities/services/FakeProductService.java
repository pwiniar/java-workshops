package business.entities.services;

import business.entities.Product;
import business.entities.repositories.FakeProductRepository;

import java.util.List;

/**
 * Created by Winiar on 02.07.2017.
 */
public class FakeProductService implements ProductService {

    @Override
    public List<Product> findAll() {
        return FakeProductRepository.getInstance().findAll();
    }

    @Override
    public Product findById(Integer id) {
        return FakeProductRepository.getInstance().findById(id);
    }
}
