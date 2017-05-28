package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created by Winiar on 09.05.2017.
 */
public class MyStepdefs {

    private Map<String, Integer> priceForFruit = new HashMap<>();
    private Integer finalPrice = 0;


    private int bananaPrice;
    private Checkout checkout = new Checkout();
//    public steps.MyStepdefs() {
//        Given("^the price of a \"([^\"]*)\" is (\\d+)c$", (String arg0, Integer arg1) -> {
//            int priceForFruit = arg1;
//        });
//    }


    @Given("^the price of a \"(.*?)\" is (\\d+)c$")
    public void the_price_of_a_is_c(String arg1, int arg2) throws Throwable {
        priceForFruit.put(arg1, arg2);
    }

    @When("^I checkout (\\d+) \"(.*?)\"$")
    public void i_checkout(int arg1, String arg2) throws Throwable {
        Optional<Integer> price = Optional.ofNullable(priceForFruit.get(arg2));

        if (!price.isPresent()) {
            throw new RuntimeException("Fruit not found");
        }

        finalPrice += arg1 * price.get();

    }

    @Then("^the total price should be (\\d+)c$")
    public void theTotalPriceShouldBeC(int arg0) throws Throwable {
        Assertions.assertThat(finalPrice).isEqualTo(arg0);
    }

    @Given("^A the price of a \"([^\"]*)\" is (\\d+)c$")
    public void aThePriceOfAIsC(String name, int price) throws Throwable {
        bananaPrice = price;
    }

    @When("^A I checkout (\\d+) \"([^\"]*)\"$")
    public void aICheckout(int itemCount, String itemName) throws Throwable {
        checkout.add(itemCount, bananaPrice);
    }

    @Then("^A the total price should be (\\d+)c$")
    public void aTheTotalPriceShouldBeC(int total) throws Throwable {
        Assertions.assertThat(total).isEqualTo(checkout.total());
    }
}
