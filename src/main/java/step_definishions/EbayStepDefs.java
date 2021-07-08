package step_definishions;

import Utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.EbayHomePage;
import pages.EbayResearchPage;

import java.util.concurrent.TimeUnit;

public class EbayStepDefs {
    private WebDriver driver;

    @Given("user navigates to {string}")
    public void user_navigates_to_ebay_com(String web) {
        driver= Driver.getDriver();
        driver.get(web);

    }

    @When("user searches for {string}")
    public void user_searches_for_java_for_dummies(String searchCriteria) {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        EbayHomePage ebayHomePage = new EbayHomePage(driver);
        ebayHomePage.search(searchCriteria);
    }


    @Then("user validates the numbers of results more then {int}")
    public void user_validates_the_number_of_results_more_then(Integer number){
        EbayResearchPage ebayResearchPage = new EbayResearchPage(driver);
        boolean correct_number = ebayResearchPage.compareResults(number);
        Assert.assertTrue(correct_number);
    }



}
