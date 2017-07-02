package business.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Winiar on 02.07.2017.
 */
public class Product {

    private final int id;
    private final String name;
    private final boolean inStock;
    private final BigDecimal price;
    private List<Comment> comments = new ArrayList<>();

    public Product(int id, String name, boolean inStock, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.inStock = inStock;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public List<Comment> getComments() {
        return comments;
    }
}
