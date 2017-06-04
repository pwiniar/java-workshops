package nicebank.money;

import cucumber.api.Transformer;

/**
 * Created by Winiar on 29.05.2017.
 */
public class MoneyConverter extends Transformer<Money> {

    @Override
    public Money transform(String amount) {
        char currency = amount.charAt(0);
        String[] split = amount.substring(1).split("\\.");
        return new Money(getCurrency(currency), Integer.parseInt(split[0]),
                Integer.parseInt(split[1]));
    }

    private Money.CURRENCY getCurrency(char currency) {
        switch (currency) {
            case '$':
                return Money.CURRENCY.DOLLAR;
            default:
                return Money.CURRENCY.PLN;
        }
    }
}
