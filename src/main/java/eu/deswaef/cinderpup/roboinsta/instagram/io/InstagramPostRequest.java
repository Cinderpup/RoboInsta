package eu.deswaef.cinderpup.roboinsta.instagram.io;

import eu.deswaef.cinderpup.roboinsta.instagram.InstagramConstants;
import eu.deswaef.cinderpup.roboinsta.instagram.InstagramHashing;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public abstract class InstagramPostRequest<T> extends InstagramRequest<T> {

    @Override
    public String getMethod() {
        return "POST";
    }

    @Override
    public T execute() throws ClientProtocolException, IOException {
        HttpPost post = new HttpPost(InstagramConstants.apiUrl + getUrl());
        post.addHeader("Connection", "close");
        post.addHeader("Accept", "*/*");
        post.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        post.addHeader("Cookie2", "$Version=1");
        post.addHeader("Accept-Language", "en-US");
        post.addHeader("User-Agent", InstagramConstants.userAgent);

        String parsedData = InstagramHashing.generateSignature(getPayload());
        post.setEntity(new StringEntity(parsedData));

        HttpResponse response = api.getClient().execute(post);
        api.setLastResponse(response);

        int resultCode = response.getStatusLine().getStatusCode();
        String content = EntityUtils.toString(response.getEntity());

        post.releaseConnection();

        return parseResult(resultCode, content);
    }

}
