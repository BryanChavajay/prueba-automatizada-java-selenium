package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        glue = {"stepdefinitions"},
        features = "src/test/resources/features/google.feature",
        snippets = SnippetType.CAMELCASE)
public class GoogleRunner {


}
