package eu.deswaef.cinderpup.roboinsta.instagram.io;

import com.fasterxml.jackson.databind.ObjectMapper;
import eu.deswaef.cinderpup.roboinsta.instagram.Instagram;
import org.apache.commons.io.IOUtils;
import org.apache.http.client.ClientProtocolException;

import java.io.IOException;
import java.io.InputStream;

public abstract class InstagramRequest<T> {

    protected Instagram api;

    public abstract String getUrl();

    public abstract String getMethod();

    public String getPayload() {
        return null;
    }

    public abstract T execute() throws ClientProtocolException, IOException;

    public abstract T parseResult(int resultCode, String content);

    public boolean requiresLogin() {
        return true;
    }

    public <U> U parseJson(String str, Class<U> clazz) {
        try {
            return new ObjectMapper().readValue(str, clazz);
        } catch (Exception ex) {
            throw new RuntimeException("Unable to parse JSON", ex);
        }
    }

    public T parseJson(InputStream is, Class<T> clazz) {
        try {
            return parseJson(IOUtils.toString(is, "UTF-8"), clazz);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public Instagram getApi() {
        return api;
    }

    public InstagramRequest setApi(Instagram api) {
        this.api = api;
        return this;
    }
}
