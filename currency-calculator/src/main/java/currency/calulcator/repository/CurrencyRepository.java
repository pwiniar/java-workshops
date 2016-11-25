package currency.calulcator.repository;

import java.util.Date;

/**
 * Created by Pawel on 2016-11-24.
 */
public interface CurrencyRepository {
    float getCurrency(Currency currency, Date date);

    enum Currency {
        PLNUSD, USDPLN, USDEUR, EURUSD, PLNEUR, EURPLN
    }
}
