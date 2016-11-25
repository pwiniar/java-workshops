package currency.calulcator.repository;

import currency.calulcator.repository.hardcoded.HardcodedCurrencyRepository;
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
        Assert.assertEquals(String.valueOf(hardcodedCurrencyRepository.getCurrency(CurrencyRepository.Currency.PLN, new Date())), 1.0f, 0);
    }

    @Test
    public void whenUSDCurrencyIsUsedThenFloatValueWillBeReturned() throws Exception {
        Assert.assertEquals(String.valueOf(hardcodedCurrencyRepository.getCurrency(CurrencyRepository.Currency.USD, new Date())), 5.0f, 0);
    }
}