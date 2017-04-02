package beginner.basics.beginner.designpatterns;

import java.math.BigDecimal;

/**
 * Created by michal on 15.06.2016.
 */
public class Order {

    private String country;
    private BigDecimal sum;
    private TaxCalculator calculator;

    public Order(String country, BigDecimal sum, TaxCalculator calculator) {
        this.country = country;
        this.sum = sum;
        this.calculator = calculator;
    }

    public BigDecimal calculateTax() {
        return calculator.calculateTax(this);
    }

    public String country() {
        return country;
    }

    public BigDecimal getSum() {
        return sum;
    }
}
