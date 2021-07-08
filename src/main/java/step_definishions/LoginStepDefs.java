package step_definishions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefs {


    @Given("user on home page")
    public void user_on_home_page() {
        System.out.println("User navigates to home page");
    }
    @When("user log in with valid username and password")
    public void user_log_in_with_valid_username_and_password(){
        System.out.println("User log in");
        System.out.println("Username: Tech");
        System.out.println("Password:tech123");
    }

    @Then("user sees the welcome massage")
    public void user_sees_the_welcome_massage(){
        System.out.println("There is welcome massage");

    }
}
