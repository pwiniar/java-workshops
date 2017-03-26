package views.over.maps;

import plural.colec.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by Pawel on 2017-02-26.
 */
public class Benchmark {

    // java features
    // just in time compiler
    // runtime optimization

    private static final int NUMBER_OF_PRODUCTS = 20_000;
    private static final int ITERATIONS = 5;

    private static final List<Product> products = generateProducts();

    public static void main(String[] args) {
        runLookups(new MapProductLookupTable());
        runLookups(new NaiveProductLookupTable());
    }

    private static List<Product> generateProducts() {
        final List<Product> products = new ArrayList<>();
        final Random weightGenerator = new Random();

        for (int i = 0; i < NUMBER_OF_PRODUCTS; i++) {
            products.add(new Product("Product" + 1, weightGenerator.nextInt(10), i));
        }

        Collections.shuffle(products);
        Collections.shuffle(products);
        Collections.shuffle(products);

        return products;
    }

    private static void runLookups(ProductLookupTable lookupTable) {
        final List<Product> products = Benchmark.products;
        System.out.println("Running lookups with " + lookupTable.getClass().getSimpleName());

        for (int i = 0; i < ITERATIONS; i++) {
            final long startTime = System.currentTimeMillis();

            for (Product product : products) {
                lookupTable.addProduct(product);
            }

            for (Product product : products) {
                final Product result = lookupTable.lookupById(product.getId());
                if (result != product) {
                    throw new IllegalArgumentException("Lookup returned wrong object for id: " + product.getId());
                }
            }

            lookupTable.clear();

            System.out.println(System.currentTimeMillis() - startTime + " ms");
        }
    }
}
