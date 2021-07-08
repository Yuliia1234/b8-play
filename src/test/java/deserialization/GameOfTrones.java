package deserialization;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

public class GameOfTrones {

    HttpClient httpClient;
    URIBuilder uriBuilder;
    HttpGet httpGet;
    ObjectMapper objectMapper;

    @Before
    public void setUp() throws URISyntaxException {
        httpClient = HttpClientBuilder.create().build();
        uriBuilder = new URIBuilder();
        //https://pokeapi.co/api/v2/ability/
        uriBuilder.setScheme("https").setHost("api.got.show").setPath("api/show/characters");

        httpGet = new HttpGet(uriBuilder.build());
        objectMapper = new ObjectMapper();
    }

    @Test
    public void GetAbility() throws IOException {

         httpGet.setHeader("Accept", "application/json");
        HttpResponse response = httpClient.execute(httpGet);

        Assert.assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());

        List<Map<String, Object>> maps = objectMapper.readValue(response.getEntity().getContent(), new TypeReference<List<Map<String, Object>>>() {
        });
        System.out.println(maps.size());

        for (int i = 0; i < maps.size(); i++) {

            Map<String, Object> mapsize = (Map<String, Object>) maps.get(i);
            Object name =( Object) mapsize.get("name");
            Object gender = mapsize.get("gender");

            System.out.println("Name of actor " + name + " gender : " + gender);


        }

    }
}
