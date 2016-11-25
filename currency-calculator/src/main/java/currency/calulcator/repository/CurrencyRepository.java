package currency.calulcator.repository;

import currency.calulcator.repository.open.exchange.UnavailableExchangeRateException;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Pawel on 2016-11-24.
 */
public interface CurrencyRepository {
    BigDecimal getCurrency(Currency currency, Date date) throws UnavailableExchangeRateException;

    enum Currency {
        PLN, USD, EUR
    }
}
