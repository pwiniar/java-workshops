package currency.calulcator.calculator;

import currency.calulcator.repository.CurrencyRepository;
import currency.calulcator.repository.open.exchange.UnavailableExchangeRateException;
import currency.calulcator.strategies.RoundingStrategy;
import currency.calulcator.strategies.RoundingStrategy2Down;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

/**
 * Created by Pawel on 2016-11-24.
 */
public class CurrencyCalculator {

    private final CurrencyRepository currencyRepository;

    public CurrencyCalculator(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    public void calculateCurrency(double amount, String expectedCurrency, String inputCurrency, Optional<RoundingStrategy> strategy) throws UnavailableExchangeRateException {
        if (!strategy.isPresent()) {
            strategy = Optional.of(new RoundingStrategy2Down());
        }

        BigDecimal currency = currencyRepository.getCurrency(CurrencyRepository.Currency.valueOf(expectedCurrency), new Date());
        int round = strategy.get().round(currency);
        System.out.println(String.format("currency is: %s, amount is: %s, you will get %s:", currency, amount, currency.multiply(BigDecimal.valueOf(amount))));

    }


    public void calculateCurrency(double amount, String expectedCurrency, String inputCurrency, RoundingStrategy strategy) throws UnavailableExchangeRateException {
        BigDecimal currency = currencyRepository.getCurrency(CurrencyRepository.Currency.valueOf(expectedCurrency), new Date());
        int round = strategy.round(currency);
        System.out.println(String.format("currency is: %s, amount is: %s, you will get %s:", currency, amount, currency.multiply(BigDecimal.valueOf(amount))));
    }



}
