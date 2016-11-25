package currency.calulcator;

import currency.calulcator.main.CurrencyCalculator;
import currency.calulcator.repository.HardcodedCurrencyRepository;
import currency.calulcator.strategies.RoundingStrategy2Up;

/**
 * Created by Pawel on 2016-11-24.
 */
public class Run {

    public static void main(String[] args) {

        CurrencyCalculator currencyCalculator = new CurrencyCalculator(new HardcodedCurrencyRepository());
        currencyCalculator.calculateCurrency(100, "USD", "PLN", new RoundingStrategy2Up());


        CurrencyCalculator currencyCalculator1 = new CurrencyCalculator(new HardcodedCurrencyRepository());
        currencyCalculator1.calculateCurrency(100, "EUR", "PLN");



    }

}
