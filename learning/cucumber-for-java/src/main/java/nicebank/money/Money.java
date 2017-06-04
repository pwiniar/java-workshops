package nicebank.money;

/**
 * Created by Winiar on 29.05.2017.
 */
public class Money {

    private int dollars;
    private int cents;
    private CURRENCY currency;

    public Money(CURRENCY currency) {
        this.currency = currency;
    }

    public Money(CURRENCY currency, int dollars, int cents) {
        this.dollars = dollars;
        this.cents = cents;
        this.currency = currency;
    }

    public Money add(Money amount) {
        if (!amount.currency.equals(this.currency)) {
            this.dollars += amount.dollars / 0.5;
            this.cents += amount.cents / 0.5;
        } else {
            this.dollars += amount.dollars;
            this.cents += amount.cents;
        }

        return this;
    }

    public void minus(int money) {
        dollars = this.dollars - money;
    }

    public enum CURRENCY {
        DOLLAR, EURO, PLN
    }

    public int getDollars() {
        return dollars;
    }

    public int getCents() {
        return cents;
    }

    public CURRENCY getCurrency() {
        return currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Money money = (Money) o;

        if (dollars != money.dollars) return false;
        if (cents != money.cents) return false;
        return currency == money.currency;

    }

    @Override
    public String toString() {
        return "Money{" +
                "dollars=" + dollars +
                ", cents=" + cents +
                ", currency=" + currency +
                '}';
    }
}


//    public Money(String amount) {
//        String[] split = amount.substring(1).split("\\.");
//        this.dollars = Integer.parseInt(split[0]);
//        this.cents = Integer.parseInt(split[1]);
//    }

//    private final String PATTERN = "^[^\\d]*([\\d]+)\\.([\\d][\\d])$";
//    public Money(String amount) {
//        Pattern pattern = Pattern.compile(PATTERN);
//        Matcher matcher = pattern.matcher(amount);
//        this.dollars = Integer.parseInt(matcher.group(1));
//        this.cents = Integer.parseInt(matcher.group(2));
//    }
