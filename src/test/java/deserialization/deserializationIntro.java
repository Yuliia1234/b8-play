package deserialization;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

public class deserializationIntro {


    @Test
    public void test1() throws URISyntaxException, IOException {

        HttpClient httpClient = HttpClientBuilder.create().build();

        Base base = new Base("https", "petstore.swagger.io", "v2/pet/1");
        base.getMetod();
        HttpGet getting = new HttpGet(base.builder.build());//
        HttpResponse res = httpClient.execute(getting);

        //https://petstore.swagger.io/v2/pet/1

        Assert.assertEquals(200, res.getStatusLine().getStatusCode());
        System.out.println(res.getStatusLine().getStatusCode());

        ObjectMapper objectMapper = new ObjectMapper();

        Map<String, Object> deserialisation = objectMapper.readValue(base.getMetod().getEntity().getContent(),
                new TypeReference<Map<String, Object>>() {
                });

        System.out.println("id ="+deserialisation.get("id"));
        System.out.println("name = "+deserialisation.get("name"));
    }


}


