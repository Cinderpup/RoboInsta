package eu.deswaef.cinderpup.roboinsta.instagram.io.login;

import eu.deswaef.cinderpup.roboinsta.instagram.context.InstagramAuthentication;
import eu.deswaef.cinderpup.roboinsta.instagram.context.InstagramContextHolder;
import eu.deswaef.cinderpup.roboinsta.instagram.io.InstagramOperations;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;


public class LoginOperations extends InstagramOperations {

    private String username;
    private String password;
    private List<Consumer<InstagramLoginResult>> resultConsumers;
    private List<Consumer<Exception>> exceptionConsumers;

    public LoginOperations() {
        this.resultConsumers = new LinkedList<>();
        this.exceptionConsumers = new LinkedList<>();
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
        try {
            if (StringUtils.isEmpty(this.username)) {
                throw new IllegalArgumentException("Username is mandatory.");
            }

            if (StringUtils.isEmpty(this.password)) {
                throw new IllegalArgumentException("Password is mandatory.");
            }
            final InstagramLoginPayload loginRequest = constructLogin();
            final InstagramLoginResult loginResult = sendRequest(new InstagramLoginRequest(loginRequest));
            if (loginResult.getStatus().equalsIgnoreCase("ok")) {
                populateAuthentication();
                this.resultConsumers.forEach(consumer -> consumer.accept(loginResult));
            } else {
                throw new RuntimeException("Unable to login, status was " + loginResult.getStatus());
            }
        } catch (Exception ex) {
            this.exceptionConsumers.forEach(consumer -> consumer.accept(ex));
        }
    }

    private InstagramLoginPayload constructLogin() throws IOException {
        return new InstagramLoginPayload().setUsername(username)
            .setPassword(password)
            .setGuid(InstagramContextHolder.getContext().getDevice().getGuid())
            .setDevice_id(InstagramContextHolder.getContext().getDevice().getDeviceId())
            .setPhone_id(InstagramContextHolder.getContext().getDevice().getPhoneId())
            .setLogin_attempt_account(0)
            .set_csrftoken(getOrFetchCsrf());
    }

    private void populateAuthentication() {
        InstagramContextHolder.getContext().setAuthentication(
            new InstagramAuthentication()
                .setPassword(this.password)
                .setUsername(this.username)
        );
    }

}
