import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class APIintro {


    @Test
    public void apiCallTest() throws URISyntaxException, IOException {
        //1. HAVe/launch a client(postman/http client )
        HttpClient httpClient = HttpClientBuilder.create().build();

        //2Have valid URL https://corona.lmao.ninja/v2/states//Specify desired HTTP method
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("corona.lmao.ninja");
        uriBuilder.setPath("v2/states");
        //3. Specify desire /supported HTTP method
        HttpGet httpGet = new HttpGet(uriBuilder.build());

        //4. Execute /click on Send Button
       HttpResponse httpResponse = httpClient.execute(httpGet);
       int statusCode = httpResponse.getStatusLine().getStatusCode();

        System.out.println("Status code id :" + statusCode);
        Assert.assertEquals(200,statusCode);


    }
}
