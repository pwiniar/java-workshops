package chain.of.responsibility.one.roles;

/**
 * Created by Winiar on 27.08.2017.
 */
public class ManagerPPower extends PurchasePower {

    @Override
    protected double getAllowable() {
        return BASE * 10;
    }

    @Override
    protected String getRole() {
        return "Manager";
    }
}
