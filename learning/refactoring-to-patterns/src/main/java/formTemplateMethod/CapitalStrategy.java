package formTemplateMethod;

/**
 * Created by Pawel on 2017-04-02.
 */
public abstract class CapitalStrategy {
    public abstract double capital(Loan loan);
    public abstract double riskAmountFor(Loan loan);

    public static double riskFactorFor(Loan loan) {
        return 1;
    }

    public static double duration(Loan loan) {
        return 2;
    }

    public static double unusedRiskFactor(Loan loan) {
        return 3;
    }
}
