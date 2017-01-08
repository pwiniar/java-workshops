package currency.calulcator.strategies;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * Created by Pawel on 2016-11-24.
 */
public class RoundingStrategy2Down implements RoundingStrategy {

    @Override
    public int round(BigDecimal value) {
        DecimalFormat decimalFormat = RoundingStrategy.decimalFormat;

        return decimalFormat.getGroupingSize();
    }


//    zawsze w górę do dwóch miejsc po przecinku (domyślna)
//    zawsze w dół do dwóch miejsc po przecinku



}
