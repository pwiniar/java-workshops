package hooks;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import nicebank.support.KnowsTheDomain;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;

/**
 * Created by Winiar on 04.06.2017.
 */
public class WebDriverHooks {

    private final KnowsTheDomain helper = new KnowsTheDomain();

    @After("@sever")
    public void finish(Scenario scenario) {
        try {
            byte[] screenshot = helper.getWebDriver().getScreenshotAs(OutputType.BYTES);

            scenario.embed(screenshot, "image/png");

        } catch (WebDriverException somePlatformsDontSupportScreenshots) {
            System.err.println(somePlatformsDontSupportScreenshots.getMessage());
        }
        finally {
            helper.getWebDriver().close();
        }
    }

}
