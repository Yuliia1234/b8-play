package Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "@target/failedScenarios.txt",
        glue = "step_definitions"
        ,plugin = {"pretty", "json:target/report.json","rerun:target/failedScenarios.txt"})
public class FaildScenariosRunner {


}
