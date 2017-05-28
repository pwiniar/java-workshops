package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by Winiar on 21.05.2017.
 */
public class changePin {
    @Given("^I have been issued a new card$")
    public void iHaveBeenIssuedANewCard() throws Throwable {
    }

    @And("^I insert the card, entering the correct PIN$")
    public void iInsertTheCardEnteringTheCorrectPIN() throws Throwable {
    }

    @And("^I choose \"([^\"]*)\" from the menu$")
    public void iChooseFromTheMenu(String arg0) throws Throwable {
    }

    @When("^I change the PIN to (\\d+)$")
    public void iChangeThePINTo(int arg0) throws Throwable {
    }

    @Then("^the system should remember my PIN is now (\\d+)$")
    public void theSystemShouldRememberMyPINIsNow(int arg0) throws Throwable {
    }

    @When("^I try to change the PIN to the original PIN number$")
    public void iTryToChangeThePINToTheOriginalPINNumber() throws Throwable {
    }

    @Then("^I should see a warning message$")
    public void iShouldSeeAWarningMessage() throws Throwable {
    }

    @And("^the system should not have changed my PIN$")
    public void theSystemShouldNotHaveChangedMyPIN() throws Throwable {
    }

    @Given("^these Users:$")
    public void theseUsers(DataTable dataTable) throws Throwable {
        dataTable.raw().forEach(System.out::println);


    }

}
