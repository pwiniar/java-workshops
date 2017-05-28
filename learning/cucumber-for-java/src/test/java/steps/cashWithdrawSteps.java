package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Winiar on 28.05.2017.
 */
public class cashWithdrawSteps {

    private class Account {
//        private Money balance = new Money();

        public void deposit(Money amount) {
//            balance = balance.add(amount);
        }

        public Money getBalance() {
            return new Money("0");
        }
    }

    private class Money {
        private final String PATTERN = "^[^\\d]*([\\d]+)\\.([\\d][\\d])$";
        private int dollars;
        private int cents;

        public Money(String amount) {
            Pattern pattern = Pattern.compile(PATTERN);
            Matcher matcher = pattern.matcher(amount);
            this.dollars = Integer.parseInt(matcher.group(1));
            this.cents = Integer.parseInt(matcher.group(2));
        }

        public Money add(Money amount) {
            return null;
        }
    }

    @Given("^I have deposited \\$(\\d+\\.\\d+) in my account$")
    public void iHaveDepositedInMyAccount(Money amount) throws Throwable {
        Account account = new Account();
        account.deposit(amount);

        Assertions.assertThat(amount).as("Account balance: ")
                .isEqualTo(account.getBalance());
    }

    @When("^I request \\$(\\d+)$")
    public void iRequest$(int arg1) throws Throwable {

    }

    @Then("^\\$(\\d+) should be dispensed$")
    public void $ShouldBeDispensed(int arg1) throws Throwable {

    }
}
