package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

/**
 * Created by Winiar on 21.05.2017.
 */
public class departureSteps {
    @Given("^the flight ([A-Z]+[0-9]+) is leaving today$")
    public void theFlightEZYIsLeavingToday(int arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^I have deposited \\$([0-9]+) in my (\\w+) Account$")
    public void iHaveDeposited$InMyCheckingAccount(int arg0, String accountType) throws Throwable {

    }

    @When("^I transfer \\$(\\d+) from my (\\w+) Account into my (\\w+) Account$")
    public void iTransfer$FromMySavingsAccountIntoMyCheckingAccount(int arg0, String oneAccount, String seconAccount) throws Throwable {
        System.out.println(String.format("I send three argument %d, %s, %s", arg0, oneAccount, seconAccount));
        throw new PendingException("Under development");
    }

    @Given("^I have (\\d+) cucumbers? in my basket$")
    public void iHaveCucumberInMyBasket(int arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I (?:visit|go to) the homepage$")
    public void iVisitTheHomepage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
