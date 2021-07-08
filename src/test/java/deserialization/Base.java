package deserialization;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.net.URISyntaxException;

public class Base {

    public  URIBuilder builder = new URIBuilder();

    public static HttpClient httpClient = HttpClientBuilder.create().build();


    public Base(String scheme, String host, String path) {
       //httpClient =  HttpClientBuilder.create().build();
        builder.setScheme(scheme).setHost(host).setPath(path);

    }
    public HttpResponse getMetod() throws URISyntaxException, IOException {
        HttpGet getting = new HttpGet(builder.build());
        HttpResponse res = httpClient.execute(getting);
        return res;
    }
}
