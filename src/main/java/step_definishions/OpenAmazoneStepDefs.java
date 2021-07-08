package step_definishions;

import Utils.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.OpenAmazoneHomePage;

import java.util.concurrent.TimeUnit;




public class OpenAmazoneStepDefs {
    private WebDriver driver;
    @Given("user navigates to amazon.com")
    public void search_button() {
        driver= Driver.getDriver();
        driver.get("https://www.amazon.com/");

    }

    @When("user searches for selenium cookbook")
    public void user_search_with_valid_name() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        OpenAmazoneHomePage openAmazoneHomePage=new OpenAmazoneHomePage(driver);
        openAmazoneHomePage.search("selenium cookbook");

    }

    @Then("user validates the number of results more then {int}")
    public void user_validates_the_number_of_results_more_then(Integer numOfResults) {
        OpenAmazoneHomePage openAmazoneHomePage=new OpenAmazoneHomePage(driver);
       boolean areNumberCorect = openAmazoneHomePage.checkItemNumber(numOfResults);
       Assert.assertTrue(areNumberCorect);



    }
    @And("user validates the search criteria")
    public void user_validates_the_search_criteria() throws InterruptedException {

        OpenAmazoneHomePage openAmazoneHomePage = new OpenAmazoneHomePage(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        boolean validMassage = openAmazoneHomePage.validateAmazoneMassage("\"selenium cookbook\"");
        org.junit.Assert.assertTrue(validMassage);

    }

}
