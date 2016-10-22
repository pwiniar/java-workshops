package workshop.java.beginner.designpatterns;

import java.math.BigDecimal;

/**
 * Created by michal on 15.06.2016.
 */
public interface TaxCalculator {

    BigDecimal calculateTax(Order o);
}
