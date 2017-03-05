package views.over.maps;

import plural.colec.Product;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Pawel on 2017-02-26.
 */
public class MapProductLookupTable implements ProductLookupTable {

    //sorted map, navigable map

    private final Map<Integer, Product> idToProduct = new HashMap<>();

    @Override
    public Product lookupById(int id) {
        return idToProduct.get(id);
    }

    @Override
    public void addProduct(Product productToAdd) {
        int id = productToAdd.getId();

        if (idToProduct.containsKey(id)) {
            throw new IllegalArgumentException("duplicated id for " + productToAdd);
        }
        idToProduct.put(id, productToAdd);
    }

    @Override
    public void clear() {
        idToProduct.clear();
    }
}
