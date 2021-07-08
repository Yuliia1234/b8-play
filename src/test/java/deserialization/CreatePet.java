package deserialization;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;
import pojo.PetPojo;
import utils.Constants;
import utils.PayloadUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.Map;

public class CreatePet {

    @Test
    public void createTestPet() throws URISyntaxException, IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();

        URIBuilder uriBuilder = new URIBuilder("https://petstore.swagger.io/v2/pet");


        HttpPost httpPost = new HttpPost(uriBuilder.build());

        httpPost.setHeader("Accept","application/json");
        httpPost.setHeader("Content-Type","application/json");

        String body = "{\n" +
                "    \"id\": 9000,\n" +
                "    \"category\": {\n" +
                "        \"id\": 700\n" +
                "    },\n" +
                "    \"name\": \"Doggy\",\n" +
                "    \"photoUrls\": [],\n" +
                "    \"tags\": [],\n" +
                "    \"status\": \"java code\"\n" +
                "}";
        HttpEntity requestBody = new StringEntity(body);
        httpPost.setEntity(requestBody);//request body

       HttpResponse httpResponse =  httpClient.execute(httpPost);

        Assert.assertEquals(HttpStatus.SC_OK,httpResponse.getStatusLine().getStatusCode());


        ObjectMapper objectMapper = new ObjectMapper();

        PetPojo parseResponse = objectMapper.readValue(httpResponse.getEntity().getContent(),
                PetPojo.class);

        Assert.assertEquals(parseResponse.getId(),0);
           Assert.assertEquals(parseResponse.getStatus(),"java code");



//        HttpClient httpClient1 = HttpClientBuilder.create().build();
//        URIBuilder URI = new URIBuilder();
//
//        URI.setScheme("https").setHost("petstore.swagger.io").setPath("v2/pet");
//        HttpGet httpGet = new HttpGet(uriBuilder.build());
//
//        httpGet.setHeader("Accept", "application/json");
//        HttpResponse response1 = httpClient1.execute(httpGet);
//
//        Assert.assertEquals(HttpStatus.SC_OK, response1.getStatusLine().getStatusCode());


        }


    }

