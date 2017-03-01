package eu.deswaef.cinderpup.roboinsta.instagram.io;

import eu.deswaef.cinderpup.roboinsta.instagram.InstagramConstants;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public abstract class InstagramGetRequest<T> extends InstagramRequest<T> {

    @Override
    public String getMethod() {
        return "GET";
    }

    @Override
    public T execute() throws ClientProtocolException, IOException {
        HttpGet get = new HttpGet(InstagramConstants.apiUrl + getUrl());
        get.addHeader("Connection", "close");
        get.addHeader("Accept", "*/*");
        get.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        get.addHeader("Cookie2", "$Version=1");
        get.addHeader("Accept-Language", "en-US");
        get.addHeader("User-Agent", InstagramConstants.userAgent);

        HttpResponse response = api.getClient().execute(get);
        api.setLastResponse(response);

        int resultCode = response.getStatusLine().getStatusCode();
        String content = EntityUtils.toString(response.getEntity());

        get.releaseConnection();

        return parseResult(resultCode, content);
    }

    @Override
    public String getPayload() {
        return null;
    }


}
