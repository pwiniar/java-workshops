package formTemplateMethod;

/**
 * Created by Pawel on 2017-04-02.
 */
public class CapitalStrategyRevolver extends CapitalStrategy {

    public double capital(Loan loan) {
        return (loan.unusedRiskAmount() *
                duration(loan) * unusedRiskFactor(loan));
    }

    @Override
    public double riskAmountFor(Loan loan) {
        return loan.outstandingRiskAmount();
    }
}
