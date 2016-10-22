package workshop.java.beginner.designpatterns;

import org.testng.annotations.Test;

import java.math.BigDecimal;

/**
 * Created by michal on 15.06.2016.
 */
public class TaxCalculatorTest {

    public void processOrder(Order o) {
        BigDecimal tax = o.calculateTax();
    }

    private TaxCalculator calcuForCountry(String country) {
        return null;
    }

    @Test
    public void testName() throws Exception {


    }
}
