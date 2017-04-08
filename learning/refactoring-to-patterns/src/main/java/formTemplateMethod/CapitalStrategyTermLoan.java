package formTemplateMethod;

/**
 * Created by Pawel on 2017-04-02.
 */
public class CapitalStrategyTermLoan extends CapitalStrategy {

    @Override
    public double capital(Loan loan) {
        return riskAmountFor(loan) *
                CapitalStrategy.duration(loan) *
                CapitalStrategy.riskFactorFor(loan);
    }

    @Override
    public double riskAmountFor(Loan loan) {
        return loan.getCommitment();
    }
}
