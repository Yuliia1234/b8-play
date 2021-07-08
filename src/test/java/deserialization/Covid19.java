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
import java.util.List;
import java.util.Map;

public class Covid19 {


    @Test
    public void getCountryTest() throws URISyntaxException, IOException {

        HttpClient httpClient = HttpClientBuilder.create().build();

        URIBuilder uriBuilder = new URIBuilder();
        //https://corona.lmao.ninja/v2/countries/
        uriBuilder.setScheme("https");
        uriBuilder.setHost("corona.lmao.ninja");
        uriBuilder.setPath("v2/countries/");

        HttpGet getting = new HttpGet(uriBuilder.build());
        //headers Accept
        getting.setHeader("Accept", "application/json");
        //execute request
        HttpResponse httpResponse = httpClient.execute(getting);

        Assert.assertEquals(HttpStatus.SC_OK, httpResponse.getStatusLine().getStatusCode());

        ObjectMapper objectMapper = new ObjectMapper();

        //deserialization
        List<Map<String, Object>> parseResponce = objectMapper.readValue(httpResponse.getEntity().
                getContent(), new TypeReference<List<Map<String, Object>>>() {

        });

        System.out.println("Total number of county " + parseResponce.size());
        long maxCases = 0;
        String Maxcases_country = "";
        for (int i = 0; i < parseResponce.size(); i++) {

            Map<String, Object> countryMap = parseResponce.get(i);

            //down-casting
            String countryName = (String) countryMap.get("country");
            Integer total_cases = (Integer) countryMap.get("cases");
            if (total_cases > maxCases) {
                maxCases = total_cases;
                Maxcases_country = (String) countryMap.get("country");
            }
            System.out.println("Country name :" + countryName);
        }  System.out.println(maxCases + " Max cases" + " and country name :" + Maxcases_country);


    }
}
