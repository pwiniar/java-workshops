package currency.calulcator.repository;

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

/**
 * Created by Pawel on 2016-11-24.
 */
public class HardcodedCurrencyRepositoryTest {

    private final HardcodedCurrencyRepository hardcodedCurrencyRepository = new HardcodedCurrencyRepository();

    @Test
    public void whenEURCurrencyIsUsedThenFloatValueWillBeReturned() throws Exception {
        Assert.assertEquals(hardcodedCurrencyRepository.getCurrency(CurrencyRepository.Currency.PLNUSD, new Date()), 1.0f, 0);
    }

    @Test
    public void whenUSDCurrencyIsUsedThenFloatValueWillBeReturned() throws Exception {
        Assert.assertEquals(hardcodedCurrencyRepository.getCurrency(CurrencyRepository.Currency.USDEUR, new Date()), 5.0f, 0);
    }
}