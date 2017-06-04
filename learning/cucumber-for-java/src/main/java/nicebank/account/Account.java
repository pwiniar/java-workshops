package nicebank.account;

import nicebank.money.Money;

/**
 * Created by Winiar on 29.05.2017.
 */
public class Account {

    private final Owner owner;
    private Money balance = new Money(Money.CURRENCY.DOLLAR);

    public Account(Owner owner) {
        this.owner = owner;
    }

    public void credit(Money amount) {
        balance.add(amount);
    }

    public void debit(int dollars) {
        balance.minus(dollars);
    }

    public Money getBalance() {
        return this.balance;
    }

}
