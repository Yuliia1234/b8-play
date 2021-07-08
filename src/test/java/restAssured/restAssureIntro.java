package restAssured;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;
import pojo.PetPojo;
import utils.Constants;

import java.util.List;
import java.util.Map;

public class restAssureIntro {


    @Test
    public void test1() {

        //https://swapi.dev/api/vehicles

        Response response = RestAssured.given().header(Constants.ACCEPT, Constants.APPLICATION_JSON)
                .when().get("https://swapi.dev/api/vehicles").then().statusCode(HttpStatus.SC_OK).
                        log().all().extract().response();

        Map<String, Object> parsedResponse = response.as(new TypeRef<Map<String, Object>>() {
        });
        Assert.assertEquals(39, parsedResponse.get("count"));


        List<Map<String, Object>> resultList = (List<Map<String, Object>>) parsedResponse.get("results");

        Assert.assertEquals("Sand Crawler", resultList.get(0).get("name"));


    }
    @Test
    public void test2(){
        Response response = RestAssured.given().header(Constants.ACCEPT,Constants.APPLICATION_JSON).when()
                .get("https://petstore.swagger.io/v2/pet/9000").then().assertThat()
                .statusCode(HttpStatus.SC_OK).and().assertThat().contentType(Constants.APPLICATION_JSON).extract().response();

        //extract.response helping us to convert it response

        PetPojo petPojo = response.as(PetPojo.class);

        Assert.assertEquals(9000,petPojo.getId());
        Assert.assertEquals("zoo",petPojo.getName());
        Assert.assertEquals("available",petPojo.getStatus());
    }
}
