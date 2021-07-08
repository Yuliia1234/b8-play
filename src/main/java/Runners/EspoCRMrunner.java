package Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/resources/features", glue = "step_definishions",
        tags = "@Task2",plugin = {"pretty", "json:target/report.json"})
public class EspoCRMrunner {
}