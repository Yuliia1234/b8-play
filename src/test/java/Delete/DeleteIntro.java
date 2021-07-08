package Delete;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import utils.Constants;
import utils.PayloadUtils;

import java.io.IOException;
import java.net.URISyntaxException;

public class DeleteIntro {

    HttpClient httpClient;
    ObjectMapper objectMapper;
    HttpResponse response;
    HttpPost post;
    HttpDelete delete;
    URIBuilder uriBuilder;


    @Before
    public void setUp() throws URISyntaxException, IOException {
        httpClient = HttpClientBuilder.create().build();
        uriBuilder.setScheme("https").setHost("petstore.swagger.io").setPath("v2/pet");

        post=new HttpPost(uriBuilder.build());
        post.setHeader(Constants.CONTENT_TYPE,Constants.APPLICATION_JSON);
        post.setHeader(Constants.ACCEPT,Constants.APPLICATION_JSON);

        HttpEntity httpEntity = new StringEntity(PayloadUtils.getPayload(436,"zoo","ok"));
        post.setEntity(httpEntity);

        response=httpClient.execute(post);
    }
    @Test
    public void Delete() throws URISyntaxException, IOException {
        httpClient = HttpClientBuilder.create().build();

        uriBuilder.setPath("Whatever you will create ");

        delete = new HttpDelete(uriBuilder.build());

        delete.setHeader(Constants.ACCEPT,Constants.APPLICATION_JSON);

        Assert.assertEquals(HttpStatus.SC_OK,response.getStatusLine().getStatusCode());

        HttpGet get  = new HttpGet(uriBuilder.build());
        get.setHeader(Constants.ACCEPT,Constants.APPLICATION_JSON);

        httpClient.execute(get);

        Assert.assertEquals(HttpStatus.SC_NOT_FOUND,response.getStatusLine().getStatusCode());

    }
}
