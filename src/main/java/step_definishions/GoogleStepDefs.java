package step_definishions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleStepDefs {

    @Given("I am on google search page")
    public void i_am_on_google_search_page() {
        System.out.println("User is google search page");
    }


    @When("I am search for {string}")
    public void i_am_search_for(String searchCriteria) {
        System.out.println("User searches for :" + searchCriteria);
    }

    @Then("i get results about {string}")
    public void i_get_results_about_java_oca(String result) {
        System.out.println("User see search result :" + result);
    }





    @Given("user is ongmail login page")
    public void user_is_ongmail_login_page() {
        System.out.println("i navigate to gmail login page");
    }


    @When("user tries to login with invalid {string} and {string}")
    public void user_tries_to_login_with_invalid_and(String username, String password) {
        System.out.println("User used invalid username:" +username );
        System.out.println("User used invalid password:" +password );
    }
    @Then("user should see error massage")
    public void user_should_see_error_massage() {
        System.out.println("Some error massage");
    }
    @Then("should not be on mail box page")
    public void should_not_be_on_mail_box_page() {
        System.out.println("User is still on login page");


    }


}
