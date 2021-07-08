package deserialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import pojo.PetPojo2;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.ClientInfoStatus;

public class PokemonDeserilazition {

    HttpClient httpClient;
    URIBuilder uriBuilder;
    HttpGet httpGet;
    ObjectMapper objectMapper;

    @Before
    public void setUp() throws URISyntaxException {
        httpClient = HttpClientBuilder.create().build();
        uriBuilder = new URIBuilder();
        //https://pokeapi.co/api/v2/ability/
        uriBuilder.setScheme("https").setHost("pokeapi.co").setPath("api/v2/ability");
        httpGet = new HttpGet(uriBuilder.build());
        objectMapper = new ObjectMapper();
    }

    @Test
    public void GetAbility() throws IOException {
        HttpResponse response = httpClient.execute(httpGet);

        Assert.assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());
        PetPojo2 petPojo2 = objectMapper.readValue(response.getEntity().getContent(), PetPojo2.class);
        int count = petPojo2.getCount();

        Assert.assertEquals("Failed to get a valid respond",327,count);



    }


}
