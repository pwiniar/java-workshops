package plural.colec;

import java.util.Comparator;
import java.util.Objects;

/**
 * Created by winiar on 15/02/2017.
 */

public class Product {

    //        public static Comparator<Product> BY_WEIGHT = Comparator.comparing(Product::getWeight);
    public static Comparator<Product> BY_WEIGHT = new Comparator<Product>() {
        @Override
        public int compare(Product o1, Product o2) {
            return Integer.compare(o1.getWeight(), o2.getWeight());
        }
    };

    public static Comparator<Product> BY_NAME = Comparator.comparing(Product::getProductName);

    private final String productName;
    private final int weight;
    private int id;

    public Product(String productName, int weight, int id) {
        this.productName = productName;
        this.weight = weight;
        this.id = id;
    }

    public Product(String productName, int weight) {
        this.productName = productName;
        this.weight = weight;
    }

    public String getProductName() {
        return productName;
    }

    public int getWeight() {
        return weight;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", weight=" + weight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (weight != product.weight) return false;
        return Objects.equals(productName, product.getProductName());
    }

    @Override
    public int hashCode() {
//        int result = productName != null ? productName.hashCode() : 0;
//        result = 31 * result + weight;
        return Objects.hash(productName, weight);
    }
}
