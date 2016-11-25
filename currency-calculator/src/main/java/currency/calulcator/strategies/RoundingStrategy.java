package currency.calulcator.strategies;

import java.math.BigDecimal;

/**
 * Created by Pawel on 2016-11-24.
 */
public interface RoundingStrategy {
     int round(BigDecimal value);
}
