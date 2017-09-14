package chain.of.responsibility.one.roles;

import chain.of.responsibility.one.request.PurchaseRequest;

/**
 * Created by Winiar on 27.08.2017.
 */
public abstract class PurchasePower {

    protected static final double BASE = 500;
    protected PurchasePower successor;

    abstract protected double getAllowable();

    abstract protected String getRole();

    public void setSuccessor(PurchasePower successor) {
        this.successor = successor;
    }

    public void processRequest(PurchaseRequest request) {
        if (request.getAmount() < this.getAllowable()) {
            System.out.println(this.getRole() + " will approve $" +
                    request.getAmount());
        } else if (successor != null) {
            System.out.println("Successor " + getRole());
            successor.processRequest(request);
        } else if (successor == null) {
            System.out.println("No one can accept");
        }
    }
}
