package currency.calulcator.main;

import currency.calulcator.repository.CurrencyRepository;
import currency.calulcator.strategies.RoundingStrategy;
import currency.calulcator.strategies.RoundingStrategy2Down;

import java.util.Date;
import java.util.Optional;

/**
 * Created by Pawel on 2016-11-24.
 */
public class CurrencyCalculator {

    private final CurrencyRepository currencyRepository;
    private Optional<RoundingStrategy> strategy;

    public CurrencyCalculator(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    public void calculateCurrency(double amount, String expectedCurrency, String inputCurrency) {
        if (strategy == null) {
            strategy = Optional.of(new RoundingStrategy2Down());
        }

        float currency = currencyRepository.getCurrency(CurrencyRepository.Currency.valueOf(expectedCurrency + inputCurrency), new Date());
        int round = strategy.get().round(currency);
        System.out.println(String.format("currency is: %s, amount is: %s, you will get %s:", currency, amount, currency*amount));

    }


    public void calculateCurrency(double amount, String expectedCurrency, String inputCurrency, RoundingStrategy strategy) {
        float currency = currencyRepository.getCurrency(CurrencyRepository.Currency.valueOf(expectedCurrency + inputCurrency), new Date());
        int round = strategy.round(currency);
        System.out.println(String.format("currency is: %s, amount is: %s, you will get %s:", currency, amount, currency*amount));

    }



}
