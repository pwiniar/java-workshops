package formTemplateMethod;

import lombok.Value;

/**
 * Created by Pawel on 2017-04-02.
 */
@Value
public class Loan {

    private double commitment;
    private double unusedPercentage;

    public double outstandingRiskAmount() {
        return 3;
    }

    public double unusedRiskAmount() {
        return 4;
    }
}
