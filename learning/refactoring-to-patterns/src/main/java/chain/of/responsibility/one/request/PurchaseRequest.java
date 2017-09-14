package chain.of.responsibility.one.request;

/**
 * Created by Winiar on 27.08.2017.
 */
public class PurchaseRequest {
    private final double amount;
    private final String purpose;

    public PurchaseRequest(double amount, String purpose) {
        this.amount = amount;
        this.purpose = purpose;
    }

    public double getAmount() {
        return this.amount;
    }
}
