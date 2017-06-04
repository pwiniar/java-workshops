import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Winiar on 14.05.2017.
 */

//@RunWith(Cucumber.class)
//@CucumberOptions(
//        monochrome = false,
//        features = "src/test/resource/cash_withdraw/",
//        format = {"pretty", "html: cucumber-html-reports", "json: cucumber-html-reports/cucumber.json"},
//        dryRun = false,
//)

@RunWith(Cucumber.class)
@CucumberOptions(plugin={"pretty", "html:out"}, snippets=SnippetType.CAMELCASE,
        features = "src/test/resource/cash_withdraw/")
public class CucumberRunner {
}


//@CucumberOptions(  monochrome = true,
//        tags = "@tags",
//        features = "src/test/resources/features/",
//        format = { "pretty","html: cucumber-html-reports",
//                "json: cucumber-html-reports/cucumber.json" },
//        dryRun = false,
//        glue = "fr.tlasnier.cucumber" )
