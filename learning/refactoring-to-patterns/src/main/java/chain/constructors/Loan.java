package chain.constructors;


import java.util.Date;

/**
 * Created by Winiar on 27.08.2017.
 */
public class Loan {

    private Strategy strategy;
    private final float notional;
    private final float outstanding;
    private final int rating;
    private Date expiry;
    private Date maturity;

    public Loan(float notional, float outstanding, int rating, Date expiry) {
        this(notional, outstanding, rating);
        this.strategy = new TermROC();
        this.expiry = expiry;
    }

    public Loan(float notional, float outstanding, int rating, Date expiry, Date maturity) {
        this(notional, outstanding, rating);
        this.strategy = new RevolvingTermROC();
        this.expiry = expiry;
        this.maturity = maturity;
    }

    public Loan(Strategy strategy, float notional, float outstanding, int rating, Date expiry, Date maturity) {
        this(notional, outstanding, rating);
        this.strategy = strategy;
        this.expiry = expiry;
        this.maturity = maturity;
    }

    private Loan(float notional, float outstanding, int rating) {
        this.notional = notional;
        this.outstanding = outstanding;
        this.rating = rating;
    }

}
