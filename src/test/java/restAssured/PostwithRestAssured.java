package restAssured;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pojo.PetPojo;
import utils.Constants;
import utils.PayloadUtils;

import java.io.File;
import java.io.IOException;

import static utils.Constants.*;

public class PostwithRestAssured {


    @Before
    public void setup() {


        RestAssured.baseURI = "https://petstore.swagger.io";//automatically sending to post
        RestAssured.basePath = "v2/pet";

    }

    @Test
    public void createPetTest() {

        //https://petstore.swagger.io/v2/pet

        Response response = RestAssured.given().header(ACCEPT, APPLICATION_JSON)
                .header(CONTENT_TYPE, APPLICATION_JSON)
                .body(PayloadUtils.getPayload(9000, "zoo", "available")).when()
                .post("https://petstore.swagger.io/v2/pet")
                .then().assertThat().statusCode(HttpStatus.SC_OK)
                .and().assertThat().contentType(APPLICATION_JSON).log().body().extract().response();


        PetPojo pojo = response.as(PetPojo.class);
        Assert.assertEquals("zoo", pojo.getName());
        Assert.assertEquals("available", pojo.getStatus());


    }

    @Test
    public void createPetTest2() throws IOException {

        RestAssured.baseURI = "https://petstore.swagger.io";//automatically sending to post
        RestAssured.basePath = "v2/pet";

        PetPojo pet = new PetPojo();
        pet.setName("java pet");
        pet.setId(4385);
        pet.setStatus("good to go");
        RestAssured.given().header(ACCEPT, APPLICATION_JSON)
                .header(CONTENT_TYPE, APPLICATION_JSON).body(pet).when()
                .post().then().assertThat().statusCode(HttpStatus.SC_OK)
                .and().assertThat().contentType(APPLICATION_JSON);
//
//        File file = new File("pet.json");
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        objectMapper.writeValue(file,pet);


    }

    @Test
    public void createTestPet3() {

        File petJsonFile = new File("pet.json");
         RestAssured.given().header(ACCEPT, APPLICATION_JSON)
                .header(CONTENT_TYPE, APPLICATION_JSON)
                .body(petJsonFile).when().post()
                .then().assertThat().statusCode(HttpStatus.SC_OK).and().assertThat()
                 .contentType(APPLICATION_JSON).log().all();



    }


}

