package business;

import lombok.Value;

import java.math.BigDecimal;

/**
 * Created by Winiar on 02.07.2017.
 */
@Value
public class Product {
    Integer id;
    String name;
    boolean inStock;
    BigDecimal price;
}
