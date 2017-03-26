package views.over.maps;

import plural.colec.Product;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Pawel on 2017-02-26.
 */
public class SetProdcutLookupTable implements ProductLookupTable {

    private final Comparator<Product> BY_NAME = Comparator.comparing(Product::getWeight);
    private final Set<Product> idToProduct = new HashSet<>();

    @Override
    public Product lookupById(int id) {
        for (Product product : idToProduct) {
            if (product.getId() == id) {
                return product;
            }
        }

        return null;
//
//        Iterator<Product> iterator = idToProduct.iterator();
//
//        while (iterator.hasNext()) {
//            if (iterator.next().getId() == id) {
//                return iterator.next();
//            }
//        }
    }

    @Override
    public void addProduct(Product productToAdd) {
        int id = productToAdd.getId();

        if (idToProduct.contains(id)) {
            throw new IllegalArgumentException("duplicated id for " + productToAdd);
        }
        idToProduct.add(productToAdd);
    }

    @Override
    public void clear() {
        idToProduct.clear();
    }
}
