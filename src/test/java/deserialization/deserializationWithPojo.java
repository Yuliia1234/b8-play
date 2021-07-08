package deserialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;
import pojo.PetPojo;

import java.io.IOException;
import java.net.URISyntaxException;

public class deserializationWithPojo {

    @Test
    public void PetTest() throws URISyntaxException, IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();

        //https://petstore.swagger.io/v2/pet/1

        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("http").setHost("petstore.swagger.io").setPath("v2/pet/1");

        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.setHeader("Accept","application/json");

        HttpResponse httpResponse = httpClient.execute(httpGet);
        Assert.assertEquals(HttpStatus.SC_OK,httpResponse.getStatusLine().getStatusCode());

        ObjectMapper objectMapper = new ObjectMapper();
        PetPojo petPojo = objectMapper.readValue(httpResponse.getEntity().getContent(), PetPojo.class);
        int id = petPojo.getId();
        String name = petPojo.getName();
        System.out.println("id " + id);
        System.out.println(" name " + name);
        Assert.assertEquals(petPojo.getId(),1);
    }


}
