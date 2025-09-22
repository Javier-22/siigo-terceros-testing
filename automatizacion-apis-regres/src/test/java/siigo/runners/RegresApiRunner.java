package siigo.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;
import siigo.utils.BeforeSuite;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/feature/reqres_api.feature",
        glue = {"siigo.stepdefinitions", "siigo.hooks"},
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json"
        },
        stepNotifications = true,
        monochrome = true,
        tags = "@cp"
)


public class RegresApiRunner {
    @BeforeSuite
    public static void test() {
    }
}

