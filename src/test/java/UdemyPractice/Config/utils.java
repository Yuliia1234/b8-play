package UdemyPractice.Config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.BeforeClass;

import static utils.Constants.*;

public class utils {


    @BeforeClass
    public static void setup() {
       // RestAssured.proxy("localhost",8888);
        RestAssured.baseURI = "https://petstore.swagger.io";//automatically sending to post
        RestAssured.basePath = "v2/pet";

        RequestSpecification requestSpecification = new RequestSpecBuilder().addHeader(ACCEPT,APPLICATION_JSON)
                .addHeader(CONTENT_TYPE,APPLICATION_JSON).build();
        RestAssured.requestSpecification = requestSpecification;

        ResponseSpecification responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_OK).build();

        RestAssured.responseSpecification = responseSpecification;

    }
}

