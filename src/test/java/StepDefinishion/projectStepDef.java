package StepDefinishion;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.Assert;
import pojo.PetPojo;
import pojo.ProjectPojo;
import utils.PayloadUtils;

import static utils.Constants.*;
import static utils.Constants.APPLICATION_JSON;

public class projectStepDef {

    Response response;

    @Given("i have a valid gorest characters endpoint")
    public void i_have_a_valid_gorest_characters_endpoint() {
        RestAssured.baseURI = "https://gorest.co.in/public-api";
        RestAssured.basePath = "/posts/5/comments";
    }

    @When("I should get comment for post")
    public void i_should_get_comment_for_post() {
        response = RestAssured.given().header(ACCEPT, APPLICATION_JSON).header(CONTENT_TYPE, APPLICATION_JSON)
                .when().get().then().log().body().extract().response();

    }

    @Then("user validates there no comments for a post")
    public void user_validates_there_no_comments_for_a_post() {

        response.then().assertThat().body("data[0].body", Matchers.equalTo("Quisquam dolor non. Tempore magni non." +
                " Maxime quidem cupiditate. Consequatur a delectus."));

    }

    @When("user create a comment for a post")
    public void user_create_a_comment_for_a_post() {

        Response response = RestAssured.given().header(ACCEPT, APPLICATION_JSON)
                .header(CONTENT_TYPE, APPLICATION_JSON).header("Authorization", "Bearer 106b8f21995c73c87f315a314df2a751097151c10820b7bf28bed937c94a191f")
                .body(PayloadUtils.sendComment(45, "Chack", "hello@gmail.com", "Nice!")).when()
                .post("https://gorest.co.in/public-api//posts/5/comments").then().assertThat().statusCode(HttpStatus.SC_OK)
                .and().assertThat().contentType(APPLICATION_JSON).log().body().extract().response();
        ProjectPojo projectPojo = response.as(ProjectPojo.class);
        Assert.assertEquals("hello@gmail.com", projectPojo.getEmail());
        Assert.assertEquals("Nice", projectPojo.getBody());
    }

    @Then("user validate output comment")
    public void user_validate_output_comment() {


    }
}
