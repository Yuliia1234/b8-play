package StepDefinishion;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.Matchers;


import static org.hamcrest.Matchers.*;
import static utils.Constants.*;

public class StarWorsStepDef {

    Response response;


    @Given("i have a valid Star Wars characters endpoint")
    public void i_have_a_valid_star_wars_characters_endpoint() {
        RestAssured.baseURI = "https://swapi.dev";
        RestAssured.basePath = "api/people";
    }

    @When("i send GET request")
    public void i_send_get_request() {
       response = RestAssured.given().header(ACCEPT,APPLICATION_JSON).header(CONTENT_TYPE,APPLICATION_JSON)
                .when().get();

    }

    @Then("I should get {int} status code")
    public void i_should_get_status_code(Integer statusCode) {
        response.then().assertThat().statusCode(statusCode);

    }

    @Then("I should get response in JSON format")
    public void i_should_get_response_in_json_format() {

        response.then().assertThat().contentType(APPLICATION_JSON);

    }

    @Then("I should get Luke in the response")
    public void i_should_get_luke_in_the_response() {

        //our value under array json object

        response.then().assertThat().body("results[0].name", Matchers.equalTo("Luke Skywalker"));
        response.then().body("results.name", hasItem("Luke Skywalker"));
    }

}
