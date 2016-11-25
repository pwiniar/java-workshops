package currency.calulcator.repository;

import java.util.Date;

/**
 * Created by Pawel on 2016-11-24.
 */
public class HardcodedCurrencyRepository implements CurrencyRepository {

    @Override
    public float getCurrency(Currency currency, Date date) {
        float value = 0;

        switch (currency) {
            case PLNUSD:
                value = 1.0f;
                break;
            case USDPLN:
                value = 2.0f;
                break;
            case EURPLN:
                value = 3.0f;
                break;
            case PLNEUR:
                value = 4.0f;
                break;
            case USDEUR:
                value = 5.0f;
                break;
            case EURUSD:
                value = 6.0f;
                break;
            default:
                throw new IllegalArgumentException(String.format("Currency: %s doesen't exist", currency));
        }
        return value;
    }
}
