package com.holub;

import org.junit.Test;

/**
 * Created by Pawel on 2017-02-02.
 */
public class MoneyV1Test {

    private static void getMoney(MoneyV1 MoneyV1){
        System.out.println("you got it");
    }

    @Test
    public void MoneyV1() throws Exception {
        MoneyV1 balance = new MoneyV1(0.9, Currency.EURO);
        MoneyV1 request = new MoneyV1(0.4, Currency.USD);


        double normalizeBalance = balance.getValue() * balance.getCurrency()
                .conversioinRateTo(Currency.USD);

        double normalizeRequest = request.getValue() * request.getCurrency()
                .conversioinRateTo(Currency.USD);


    }
}
