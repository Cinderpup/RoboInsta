package eu.deswaef.cinderpup.roboinsta.instagram.context;

import eu.deswaef.cinderpup.roboinsta.instagram.device.Device;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public class InstagramContext {

    private CookieStore cookieStore;
    private InstagramAuthentication authentication;
    private HttpClient httpClient;
    private Device device;


    public InstagramAuthentication getAuthentication() {
        return authentication;
    }

    public InstagramContext setAuthentication(InstagramAuthentication authentication) {
        this.authentication = authentication;
        return this;
    }

    public String getRankToken() {
        if (getDevice() == null) {
            throw new IllegalArgumentException("Device has not been generated yet");
        }
        if (getAuthentication() == null) {
            throw new IllegalArgumentException("Authentication is not yet populated, log in first");
        }
        return getAuthentication().getUserId() + "_" + getDevice().getGuid();
    }

    public CookieStore getCookieStore() {
        if (cookieStore == null) {
            cookieStore = new BasicCookieStore();
        }
        return cookieStore;
    }

    public InstagramContext setCookieStore(CookieStore cookieStore) {
        this.cookieStore = cookieStore;
        return this;
    }

    public HttpClient getHttpClient() {
        if (httpClient == null) {
            httpClient = createHttpClient();
        }
        return httpClient;
    }

    public InstagramContext setHttpClient(HttpClient httpClient) {
        this.httpClient = httpClient;
        return this;
    }

    private CloseableHttpClient createHttpClient() {
        final RequestConfig requestConfig = RequestConfig.custom()
            .setCookieSpec(CookieSpecs.DEFAULT)
            .setAuthenticationEnabled(true)
            .setRedirectsEnabled(true)
            .build();
        return HttpClientBuilder.create()
            .setDefaultCookieStore(cookieStore)
            .setDefaultRequestConfig(requestConfig)
            .build();
    }

    public Device getDevice() {
        return device;
    }

    public InstagramContext setDevice(Device device) {
        this.device = device;
        return this;
    }
}
