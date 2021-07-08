package UdemyPractice.Config;

import org.junit.Test;

import static io.restassured.RestAssured.*;

public class FirstTest extends utils{

    @Test
    public void MyFirstTest(){
        given()
                .log().all().when().get()
                .then().log().all();
    }
}
