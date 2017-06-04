package hooks;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

/**
 * Created by Winiar on 04.06.2017.
 */
public class SomeTestHooks {

    @Before("@manual")
    public void beforeCallingScenario() {
        System.out.println("*********** About to start the scenario.");
    }

    @After("@manual")
    public void afterRunningScenario(Scenario scenario) {
        System.out.println("*********** Just finished running scenario: " + scenario.getStatus());

    }


}
