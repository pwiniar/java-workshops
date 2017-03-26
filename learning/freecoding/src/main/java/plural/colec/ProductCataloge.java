package plural.colec;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by winiar on 17/02/2017.
 */
public class ProductCataloge implements Iterable<Product>{


    private final Set<Product> products = new HashSet<>();

    public void isSupplayedBy(Supplayer supplayer) {

        products.addAll(supplayer.products());
    }

    @Override
    public Iterator<Product> iterator() {
        return products.iterator();
    }



}
