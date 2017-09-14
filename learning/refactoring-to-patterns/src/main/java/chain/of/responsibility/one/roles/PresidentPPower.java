package chain.of.responsibility.one.roles;

/**
 * Created by Winiar on 27.08.2017.
 */
public class PresidentPPower extends PurchasePower {
    @Override
    protected double getAllowable() {
        return BASE * 60;
    }

    @Override
    protected String getRole() {
        return "President";
    }
}
