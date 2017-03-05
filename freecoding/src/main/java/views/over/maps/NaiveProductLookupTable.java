package views.over.maps;

import plural.colec.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pawel on 2017-02-26.
 */
public class NaiveProductLookupTable implements ProductLookupTable {

    private List<Product> products = new ArrayList<>();

    @Override
    public Product lookupById(int id) {
//        return products.get(id);

        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }

        return null;
    }

    @Override
    public void addProduct(Product productToAdd) {

        for (Product product : products) {
            if (product.getId() == productToAdd.getId()) {
                throw new IllegalArgumentException("duplicated id");
            }
        }
        products.add(productToAdd);
    }

    @Override
    public void clear() {
        products.clear();

    }
}
