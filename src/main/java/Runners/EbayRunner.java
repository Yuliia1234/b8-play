package Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/resources/features",
        glue = "step_definishions",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
         dryRun = false,
        tags = "@implemented"//we can use "and" or "or"
        , plugin = {"pretty", "json:target/report.json","rerun:target/failedScenarios.txt"})

public class EbayRunner {


}
