package replace.constructors.with.creation.methods;


import java.util.Date;

/**
 * Created by Winiar on 27.08.2017.
 */
public class Loan {
    private CapitalStrategy capitalStrategy;
    private final Date expiry;
    private final double commitment;
    private final double outstanding;
    private final int riskRating;
    private final Date maturity;

    public Loan(double commitment, int riskRating, Date maturity) {
        this(commitment, 0.00, riskRating, maturity, null);
    }

    public Loan(double commitment, int riskRating, Date maturity, Date expiry) {
        this(commitment, 0.00, riskRating, maturity, expiry);
    }

    public Loan(double commitment, double outstanding, int riskRating, Date maturity, Date expiry) {
        this(null, commitment, outstanding, riskRating, maturity, expiry);
    }

    public Loan(CapitalStrategy capitalStrategy, double commitment,
                int riskRating, Date maturity, Date expiry) {
        this(capitalStrategy, commitment, 0.00, riskRating, maturity, expiry);
    }

    public Loan(CapitalStrategy capitalStrategy, double commitment, double outstanding, int riskRating,
                Date maturity, Date expiry) {
        this.commitment = commitment;
        this.outstanding = outstanding;
        this.riskRating = riskRating;
        this.maturity = maturity;
        this.expiry = expiry;
        this.capitalStrategy = capitalStrategy;

        if (capitalStrategy == null) {
            if (expiry == null)
                this.capitalStrategy = new CapitalStrategyTermLoan();
            else if (maturity == null)
                this.capitalStrategy = new CapitalStrategyRevolver();
            else
                this.capitalStrategy = new CapitalStrategyRCTL();
        }
    }

    public CapitalStrategy getCapitalStrategy() {
        return capitalStrategy;
    }

    public void setCapitalStrategy(CapitalStrategy capitalStrategy) {
        this.capitalStrategy = capitalStrategy;
    }

    public Date getExpiry() {
        return expiry;
    }

    public double getCommitment() {
        return commitment;
    }

    public double getOutstanding() {
        return outstanding;
    }

    public int getRiskRating() {
        return riskRating;
    }

    public Date getMaturity() {
        return maturity;
    }
}
