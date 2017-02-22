package plural.colec;

import java.util.*;
import java.util.function.Consumer;

/**
 * Created by winiar on 15/02/2017.
 */
public class Shipment implements Iterable<Product> {

    private List<Product> products = new ArrayList<>();
    private final int ELEMENT_DOESNT_EXIST = -1;
    private static final int LIGHT_WEIGHT_V£AN = 20;
    private List<Product> heavyProducts = new ArrayList<>();
    private List<Product> lightProducts = new ArrayList<>();


    public void add(Product product) {
        products.add(product);
    }

    @Override
    public Iterator<Product> iterator() {
        return products.iterator();
    }

    @Override
    public void forEach(Consumer<? super Product> action) {

    }

    @Override
    public Spliterator<Product> spliterator() {
        return null;
    }

    public void replace(Product oldProduct, Product newProduct) {
        int indexOf = products.indexOf(oldProduct);

        if (indexOf != ELEMENT_DOESNT_EXIST) {
            products.set(indexOf, newProduct);
        }
    }

    public void prepare() {

        products.sort(Product.BY_WEIGHT);

        int splitPoint = findSplitPoint();

        lightProducts = products.subList(0, splitPoint);
        heavyProducts = products.subList(splitPoint, products.size());
    }

    private int findSplitPoint() {

        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            if (product.getWeight() > LIGHT_WEIGHT_V£AN) {
                return i;
            }
        }
        return 0;
    }

    public List<Product> getLightWeightProducts() {
        return lightProducts;
    }

    public List<Product> getHeavyWeightProducts() {
        return heavyProducts;
    }
}
