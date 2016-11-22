package beginner.basics.beginner.designpatterns;

import java.math.BigDecimal;

/**
 * Created by michal on 15.06.2016.
 */
public class TaxCalculatorForPL implements TaxCalculator {
    @Override
    public BigDecimal calculateTax(Order o) {
        return new BigDecimal("0");
    }
}
