package currency.calulcator.strategies;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * Created by Pawel on 2016-11-24.
 */
public interface RoundingStrategy {
    public static DecimalFormat decimalFormat = new DecimalFormat("#.##");

    int round(BigDecimal value);
}
