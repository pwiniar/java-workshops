package currency.calulcator.repository.hardcoded;

import currency.calulcator.repository.CurrencyRepository;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Pawel on 2016-11-24.
 */
public class HardcodedCurrencyRepository implements CurrencyRepository {

    @Override
    public BigDecimal getCurrency(Currency currency, Date date) {
        BigDecimal value = new BigDecimal(0);

        switch (currency) {
            case PLN:
                value = BigDecimal.valueOf(1);
                break;
            case USD:
                value = BigDecimal.valueOf(2);
                break;
            case EUR:
                value = BigDecimal.valueOf(3.0f);
                break;
            default:
                throw new IllegalArgumentException(String.format("Currency: %s doesen't exist", currency));
        }
        return value;
    }
}
