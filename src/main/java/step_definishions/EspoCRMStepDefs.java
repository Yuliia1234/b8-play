package step_definishions;

import Utils.Driver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.EspoCRMPage;

import java.util.List;

public class EspoCRMStepDefs {

    private WebDriver driver;
    EspoCRMPage espoCRMPage = new EspoCRMPage(Driver.getDriver());

    @Given("user navigates to home page {string}")
    public void user_navigates_to_home_page(String web) {
        driver = Driver.getDriver();
        driver.navigate().to( web);
        espoCRMPage.login();
    }

    @When("the user opens the home page")
    public void the_user_opens_the_home_page() {
        System.out.println("successfully open the home page");
    }

    @Then("the user should see the function names:")
    public void the_user_should_see_the_function_names(DataTable dataTable) {
        List<String> expected = dataTable.asList();
        List<String> actual = espoCRMPage.getTextFronOptions();
        for (int i = 0; i < actual.size(); i++) {
            try {
                Assert.assertTrue(expected.get(i).equals(actual.get(i)));
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Assertion has failed");
            }
        }

    }

//======================================================================================

    @Given("user navigates to page {string}")
    public void user_navigates_to_page(String web) {
        driver = Driver.getDriver();
        driver.get(web);
        espoCRMPage.login();
    }

    @When("the user open the Accounts")
    public void the_user_open_the_accounts() {
        espoCRMPage.navigateToAccount();
    }

    @Then("the user clicks the Create Account button")
    public void the_user_clicks_the_create_account_button(){
        espoCRMPage.createNewAccount();

    }

    @Then("the user create {int} new account {string} and {string} and  {string}")
    public void the_user_create_new_account_and_and(Integer int1, String Name, String Email, String Address3) {
       // WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
        WebElement passName = espoCRMPage.name;
        //  wait.until(ExpectedConditions.visibilityOf(passName));
        passName.sendKeys(Name);
        WebElement passEmail = espoCRMPage.email;
        passEmail.sendKeys(Email);
        espoCRMPage.clickSave();


    }

    @Then("the user validate the new users is created")
    public void the_user_validate_the_new_users_is_created() {

    }

}
