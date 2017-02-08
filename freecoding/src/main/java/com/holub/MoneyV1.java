package com.holub;

/**
 * Created by Pawel on 2017-02-02.
 */

enum Currency {
    USD, EURO;

    public double conversioinRateTo(Currency target) {
        return 1.0;
    }
}

public class MoneyV1 {
    private final Currency currency;
    private double value;

    public MoneyV1(double value, Currency currency) {
        this.value = value;
        this.currency = currency;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Currency getCurrency() {
        return currency;
    }

        double normalize(){
        return currency == Currency.USD
                ? value
                : value * currency.conversioinRateTo(Currency.USD);
    }
}
