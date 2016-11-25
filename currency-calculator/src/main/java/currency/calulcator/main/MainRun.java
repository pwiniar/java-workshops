package currency.calulcator.main;

import currency.calulcator.calculator.CurrencyCalculator;
import currency.calulcator.repository.CurrencyRepository;
import currency.calulcator.repository.hardcoded.HardcodedCurrencyRepository;
import currency.calulcator.repository.open.exchange.OpenExchangeRatesOrg;
import currency.calulcator.repository.open.exchange.UnavailableExchangeRateException;
import currency.calulcator.strategies.RoundingStrategy2Up;

import java.util.Optional;

/**
 * Created by Pawel on 2016-11-24.
 */
public class MainRun {

    private static final String id = "82aff2d0907042eba08c084043f05051";
    private static final CurrencyRepository currencyRepositoryHard = new HardcodedCurrencyRepository();
    private static final CurrencyRepository currencyRepositoryOpen = new OpenExchangeRatesOrg(id);

    public static void main(String[] args) throws UnavailableExchangeRateException {

        CurrencyCalculator currencyCalculator = new CurrencyCalculator(new HardcodedCurrencyRepository());
        currencyCalculator.calculateCurrency(100, "USD", "PLN", Optional.of(new RoundingStrategy2Up()));


        CurrencyCalculator currencyCalculator1 = new CurrencyCalculator(new HardcodedCurrencyRepository());
        currencyCalculator1.calculateCurrency(100, "EUR", "PLN", Optional.empty());

        CurrencyCalculator currencyCalculator3 = new CurrencyCalculator(currencyRepositoryOpen);
        currencyCalculator3.calculateCurrency(100, "EUR", "PLN", Optional.empty());







    }

}
