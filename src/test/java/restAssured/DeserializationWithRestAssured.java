package restAssured;

import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static utils.Constants.*;

public class DeserializationWithRestAssured {

    @Before
    public void setUP(){
        RestAssured.baseURI = "https://petstore.swagger.io";//automatically sending to post
        RestAssured.basePath = "v2/pet";


    }

    @Test
    public void test1(){
        File petJsonFile = new File("pet.json");
        RestAssured.given().header(ACCEPT,APPLICATION_JSON).header(CONTENT_TYPE,APPLICATION_JSON)
                .body(petJsonFile).when().put()
                .then().assertThat()
                .statusCode(HttpStatus.SC_OK)
                .assertThat().body("name", Matchers.equalTo("java pet")).and().assertThat()
                .body("status" ,Matchers.is("good to go"))
                .body("category.name",Matchers.is("string"));
    }
}
