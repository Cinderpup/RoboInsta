package eu.deswaef.cinderpup.roboinsta.instagram.io.login;

import eu.deswaef.cinderpup.roboinsta.instagram.Instagram;
import eu.deswaef.cinderpup.roboinsta.instagram.context.InstagramAuthentication;
import eu.deswaef.cinderpup.roboinsta.instagram.context.InstagramContextHolder;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.CookieStore;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;


public class LoginOperations {

    private String username;
    private String password;
    private CookieStore cookieStore;
    private List<Consumer<InstagramLoginResult>> resultConsumers;
    private List<Consumer<Exception>> exceptionConsumers;
    private Instagram instagram;

    public LoginOperations(final CookieStore cookieStore, final Instagram instagram) {
        this.cookieStore = cookieStore;
        this.resultConsumers = new LinkedList<>();
        this.instagram = instagram;
    }

    public LoginOperations withCredentials(final String username, final String password) {
        this.username = username;
        this.password = password;
        return this;
    }

    public LoginOperations onResult(Consumer<InstagramLoginResult> resultConsumer) {
        this.resultConsumers.add(resultConsumer);
        return this;
    }

    public LoginOperations onError(Consumer<Exception> consumer) {
        this.exceptionConsumers.add(consumer);
        return this;
    }

    public void execute() {
        if (StringUtils.isEmpty(this.username)) {
            throw new IllegalArgumentException("Username is mandatory.");
        }

        if (StringUtils.isEmpty(this.password)) {
            throw new IllegalArgumentException("Password is mandatory.");
        }
        try {
            final InstagramLoginPayload loginRequest = constructLogin();
            final InstagramLoginResult loginResult = instagram.sendRequest(new InstagramLoginRequest(loginRequest));
            populateAuthentication();
            this.resultConsumers.forEach(consumer -> consumer.accept(loginResult));
        } catch (Exception ex) {
            this.exceptionConsumers.forEach(consumer -> consumer.accept(ex));
        }
    }

    private InstagramLoginPayload constructLogin() throws IOException {
        return new InstagramLoginPayload().setUsername(username)
            .setPassword(password)
            .setGuid(instagram.getUuid())
            .setDevice_id(instagram.getDeviceId())
            .setPhone_id(instagram.randomUUID())
            .setLogin_attempt_account(0)
            .set_csrftoken(instagram.getOrFetchCsrf());
    }

    private void populateAuthentication() {
        InstagramContextHolder.getContext().setAuthentication(
            new InstagramAuthentication().setCookieStore(this.cookieStore)
                .setPassword(this.password)
                .setUsername(this.username)
        );
    }

}
