package views.over.maps;

import plural.colec.Product;

/**
 * Created by Pawel on 2017-02-26.
 */
public interface ProductLookupTable {

    Product lookupById(int id);

    void addProduct(Product productToAdd);

    void clear();

}
