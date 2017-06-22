package steps;

import cucumber.api.Transform;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import nicebank.account.Account;
import nicebank.account.Owner;
import nicebank.money.Money;
import nicebank.money.MoneyConverter;
import nicebank.support.KnowsTheDomain;
import nicebank.teller.Teller;
import org.junit.Assert;

/**
 * Created by Winiar on 28.05.2017.
 */


public class CashWithdrawSteps {

    private KnowsTheDomain helper;
    private Owner owner;
    private Money money;
    private Account account;
    private Teller teller;

    public CashWithdrawSteps() {
        this.helper = new KnowsTheDomain();
        this.owner = helper.getOwner();
        this.account = helper.getAccount(owner);
    }

    @When("^I withdraw \\$(.+)$")
    public void iWithdraw$(int dollars) throws Throwable {
        teller.withdrawFrom(account, dollars);
    }

    @Then("^\\$(.+) should be dispensed$")
    public void $ShouldBeDispensed(int dollars) throws Throwable {
        Assert.assertEquals("Incorrect amount dispensed -",
                dollars, helper.getCashSlot().getContents());
    }

    @And("^The balance of my account should be (\\$\\d+\\.\\d+)$")
    public void theBalanceOfMyAccountShouldBe$(@Transform(MoneyConverter.class) Money amount) throws Throwable {
        Assert.assertEquals("Incorrect account balance -",
                account.getBalance(), amount);

        Assert.assertEquals(account.getBalance().getDollars(), account.getBalance().getDollars());
    }

    @Given("^Account has been credited with (\\$\\d+\\.\\d+)$")
    public void accountHasBeenCreditedWith$(@Transform(MoneyConverter.class) Money amount) throws Throwable {
        money = amount;
        account.credit(amount);

//        Assertions.assertThat(amount).as("Account balance: ")
//                .isEqualTo(account.getBalance());
    }

    @Given("^server (automated|server) teller$")
    public void serverAutomatedTeller(String arg1) throws Throwable {
        switch (arg1) {
            case "automated":
                this.teller = helper.getAutomatedTeller();
                break;
            case "server":
                this.teller = helper.getAtmUserInterfaceTeller();
                break;
        }

    }
}
