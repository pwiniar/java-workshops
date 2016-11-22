import yahoofinance.YahooFinance;
import yahoofinance.quotes.fx.FxQuote;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * Created by Pawel on 2016-11-02.
 */
public class FxRates {

    public FxRates() {

    }

    public BigDecimal getFxForSymbol(String symbol) {
        FxQuote fx = null;

        try {
            fx = YahooFinance.getFx(symbol);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fx.getPrice();
    }
}
