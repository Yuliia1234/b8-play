import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;

public class Petstore {

    //1. HAVe/launch a client(postman/http client )

    @Test
    public void getPetTest() throws URISyntaxException, IOException {


        HttpClient httpClient = HttpClientBuilder.create().build();

        URIBuilder uriBuilder = new URIBuilder();

        //https://petstore.swagger.io/v2/pet/1

        uriBuilder.setScheme("https");
        uriBuilder.setHost("petstore.swagger.io");
        uriBuilder.setPath("v2/pet/1");

        //Specify desire supported HTTP method
        HttpGet httpGet = new HttpGet(uriBuilder.build());

        HttpResponse httpResponse = httpClient.execute(httpGet);

        int status = httpResponse.getStatusLine().getStatusCode();

        System.out.println("Status code " +status);
        Assert.assertEquals(200,status);
        System.out.println(httpResponse + " response ");


        String  content = EntityUtils.toString(httpResponse.getEntity());//by default it is taking reference of
        // Object in this case we need to set to String method
        System.out.println(content);//We are getting all information which we are getting from Postman





    }

}
