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
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CovidTest3 {
    @Test
    public void test1() throws URISyntaxException, IOException {

        HttpClient httpClient = HttpClientBuilder.create().build();

        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("corona.lmao.ninja");
        uriBuilder.setPath("v2/countries/");

        HttpGet httpGet = new HttpGet(uriBuilder.build());

        httpGet.setHeader("Accept", "application/json");
        HttpResponse response = httpClient.execute(httpGet);

        Assert.assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());
        //Validate if response format in Json
        Assert.assertTrue(response.getEntity().getContentType().getValue().contains("json"));

        ObjectMapper objectMapper = new ObjectMapper();
        List<Map<String, Object>> countryList = objectMapper.readValue(response.getEntity().getContent(),
                new TypeReference<List<Map<String, Object>>>() {
                });

        try {

            for (int i = 0; i < countryList.size(); i++) {
                Map<String, Object> countryMap = countryList.get(i);
                String countryName = (String) countryMap.get("country");
                Object recoveredCases =  countryMap.get("recoveredPerOneMillion");


                System.out.println(countryName + ":" + " recovered cases: " + recoveredCases);


            }

        } catch (ArithmeticException e) {
            System.out.println("Something went wrong. This country doesn't have country code ");
            e.printStackTrace();
            System.exit (0);
        }
        int maxRecovery = 0;
        int minRecovery=5;
        Map<String,Integer> map = new HashMap<>();

    }
}
