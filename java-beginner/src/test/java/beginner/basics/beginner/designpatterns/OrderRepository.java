package beginner.basics.beginner.designpatterns;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by michal on 15.06.2016.
 */
public class OrderRepository {

    Map<String, TaxCalculator> calculators = chooseTaxCalculator();
    TaxCalculator defaultCalculator = new TaxCalculatorForPL();

    public Order forId(String id) {
        // repository read from database for given id
        String country = "PL";
        String sum = "123.00";
        TaxCalculator calculator = calculators.getOrDefault(country, defaultCalculator);

        return new Order(country, new BigDecimal(sum), calculator);
    }

    private Map<String, TaxCalculator> chooseTaxCalculator() {
        Map<String, TaxCalculator> calculators = new HashMap<>(2);
        calculators.put("PL", new TaxCalculatorForPL());
        calculators.put("UK", new TaxCalculatorForUK());

        return Collections.unmodifiableMap(calculators);
    }

}
