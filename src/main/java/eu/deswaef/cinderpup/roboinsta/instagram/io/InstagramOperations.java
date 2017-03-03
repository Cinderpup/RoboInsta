package eu.deswaef.cinderpup.roboinsta.instagram.io;

import eu.deswaef.cinderpup.roboinsta.instagram.context.InstagramContextHolder;
import eu.deswaef.cinderpup.roboinsta.instagram.context.InstagramSecurityUtils;
import eu.deswaef.cinderpup.roboinsta.instagram.io.internal.InstagramFetchHeadersRequest;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.cookie.Cookie;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.IOException;
import java.util.Optional;

public class InstagramOperations {

    public <T> T sendRequest(InstagramRequest<T> request) throws ClientProtocolException, IOException {
        if (!InstagramSecurityUtils.isLoggedIn()
            && request.requiresLogin()) {
            throw new IllegalStateException("Need to login first!");
        }
        return request.execute();
    }

    public String getOrFetchCsrf() throws ClientProtocolException, IOException {
        Optional<Cookie> checkCookie = getCsrfCookie();
        if (!checkCookie.isPresent()) {
            sendRequest(new InstagramFetchHeadersRequest());
            checkCookie = getCsrfCookie();
        }
        return checkCookie.get().getValue();
    }

    public Optional<Cookie> getCsrfCookie() {
        return InstagramContextHolder.getContext().getCookieStore().getCookies()
            .stream()
            .filter(cookie -> cookie.getName().equalsIgnoreCase("csrftoken"))
            .findFirst();
    }

}
