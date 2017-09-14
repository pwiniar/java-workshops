package chain.of.responsibility.one.roles;

/**
 * Created by Winiar on 27.08.2017.
 */
public class VicePresidentPPower extends PurchasePower {
    @Override
    protected double getAllowable() {
        return BASE * 40;
    }

    @Override
    protected String getRole() {
        return "Vice President";
    }
}
