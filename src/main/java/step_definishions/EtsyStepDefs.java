package step_definishions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class EtsyStepDefs {

    private WebDriver driver;

    @Given("user is on etsy home page")
    public void user_is_on_etsy_home_page(){
        System.out.println("User navigated to Etsy home page");

    }
    @When("user searches for following:")
    public void user_searches_for_following(DataTable dataTable) {
     Map<String,String> map = dataTable.asMap(String.class,String.class);
        System.out.println("Result " + map);
     //{search phrase" => "java oca book"}
        String value = map.get("search phrase");
        System.out.println("Value retrieved from data table " +value);

    }




    @Then("user should see results about java only")
    public void user_should_see_results_about_java_only() {
        System.out.println("User sees the result page");
    }


    @Given("user is on amazon page")
    public void user_is_on_amazon_page() {
        System.out.println("User navigated to amazon home page");
    }




    @When("user searches for :")
    public void user_searches_for(DataTable dataTable) {
    List<Map<String,String>> mapList= dataTable.asMaps();
        System.out.println("List of maps " +mapList);

        Map<String,String > map = mapList.get(0);
        String value = map.get("product");
        System.out.println("Value from 0 th element from map " + value);




    }
    @Then("the result is valid")
    public void the_result_is_valid() {
        System.out.println("Result is valid ");
    }


    @When("user log in  using credential:")
    public void user_log_in_using_credential(DataTable dataTable) {
        System.out.println(dataTable);
        Map<String,String> map = dataTable.asMap(String.class,String.class);
        System.out.println("Result " + map);
        String username = map.get("username");
        String password = map.get("password");
        System.out.println("Username: " +username + " and password: " + password);

    }

    @Then("result is valid")
    public void result_is_valid() {
        System.out.println("Valid result ");

    }


    //=================================================================



    @Given("user is on ecommerce page")
    public void user_is_on_ecommerce_page() {
        System.out.println("User in profile page");

    }

    @When("user searches for multiple products:")
    public void user_searches_for_multiple_products(DataTable dataTable) {
        List<Map<String, String>> mapList = dataTable.asMaps(String.class,String.class);
        System.out.println(mapList);
        //[{product=iphone}, {product=samsung}, {product=tablet}] --->List of Maps

    }
    @Then("user sees different results")
    public void user_sees_different_results() {

    }

    }
