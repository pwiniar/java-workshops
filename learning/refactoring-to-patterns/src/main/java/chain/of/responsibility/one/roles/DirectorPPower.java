package chain.of.responsibility.one.roles;

/**
 * Created by Winiar on 27.08.2017.
 */
public class DirectorPPower extends PurchasePower {
    @Override
    protected double getAllowable() {
        return BASE * 20;
    }

    @Override
    protected String getRole() {
        return "Director";
    }
}
