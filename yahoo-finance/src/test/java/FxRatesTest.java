import org.junit.Assert;
import org.junit.Test;
import yahoofinance.quotes.fx.FxSymbols;

import java.math.BigDecimal;

/**
 * Created by Pawel on 2016-11-02.
 */
public class FxRatesTest {

    @Test
    public void returnedValueIsGraterThenZero() throws Exception {
        final String symbol = FxSymbols.USDGBP;
        BigDecimal zero = new BigDecimal(0);
        FxRates fxRates = new FxRates();

        Assert.assertNotNull(fxRates.getFxForSymbol(symbol));
        Assert.assertTrue(fxRates.getFxForSymbol(symbol).compareTo(zero) == 1);
    }
}
