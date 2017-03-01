package eu.deswaef.cinderpup.roboinsta.instagram.io;

import eu.deswaef.cinderpup.roboinsta.instagram.InstagramConstants;
import eu.deswaef.cinderpup.roboinsta.instagram.InstagramHashing;
import eu.deswaef.cinderpup.roboinsta.instagram.io.internal.InstagramFetchHeadersRequest;
import eu.deswaef.cinderpup.roboinsta.instagram.io.login.InstagramLoginPayload;
import eu.deswaef.cinderpup.roboinsta.instagram.io.login.InstagramLoginRequest;
import eu.deswaef.cinderpup.roboinsta.instagram.io.login.InstagramLoginResult;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.client.params.CookiePolicy;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

public class Instagram4j {
    protected String deviceId;

    protected String uuid;

    protected String username;

    protected String password;

    protected long userId;

    protected String rankToken;

    protected boolean isLoggedIn;

    protected HttpResponse lastResponse;

    protected boolean debug;

    protected DefaultHttpClient client;

    /**
     * @param username Username
     * @param password Password
     */
    public Instagram4j(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }

    /**
     * Setup some variables
     */
    public void setup() {

        if (StringUtils.isEmpty(this.username)) {
            throw new IllegalArgumentException("Username is mandatory.");
        }

        if (StringUtils.isEmpty(this.password)) {
            throw new IllegalArgumentException("Password is mandatory.");
        }

        this.deviceId = InstagramHashing.generateDeviceId(this.username, this.password);
        this.uuid = randomUUID();

        this.client = new DefaultHttpClient();
        this.client.getParams().setParameter(ClientPNames.COOKIE_POLICY, CookiePolicy.BROWSER_COMPATIBILITY);
        this.client.setCookieStore(new BasicCookieStore());

    }

    private String randomUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }


    /**
     * @return
     * @throws IOException
     * @throws ClientProtocolException
     */
    public InstagramLoginResult login() throws ClientProtocolException, IOException {

        InstagramLoginPayload loginRequest = new InstagramLoginPayload().setUsername(username)
            .setPassword(password)
            .setGuid(uuid)
            .setDevice_id(deviceId)
            .setPhone_id(randomUUID())
            .setLogin_attempt_account(0)
            .set_csrftoken(getOrFetchCsrf());

        InstagramLoginResult loginResult = this.sendRequest(new InstagramLoginRequest(loginRequest));
        if (loginResult.getStatus().equalsIgnoreCase("ok")) {
            this.userId = Long.valueOf(loginResult.getLogged_in_user().get("pk").toString());
            this.rankToken = this.userId + "_" + this.uuid;
            this.isLoggedIn = true;

//            InstagramSyncFeaturesPayload syncFeatures = InstagramSyncFeaturesPayload.builder()
//                ._uuid(uuid)
//                ._csrftoken(getOrFetchCsrf())
//                ._uid(userId)
//                .id(userId)
//                .experiments(InstagramConstants.DEVICE_EXPERIMENTS)
//                .build();
        }


        return loginResult;
    }

    /**
     * @return
     * @throws ClientProtocolException
     * @throws IOException
     */
    public String getOrFetchCsrf() throws ClientProtocolException, IOException {
        Optional<Cookie> checkCookie = getCsrfCookie();
        if (!checkCookie.isPresent()) {
            sendRequest(new InstagramFetchHeadersRequest());
            checkCookie = getCsrfCookie();
        }
        String csrfToken = checkCookie.get().getValue();
        return csrfToken;
    }

    public Optional<Cookie> getCsrfCookie() {
        return client.getCookieStore().getCookies().stream().filter(cookie -> cookie.getName().equalsIgnoreCase("csrftoken")).findFirst();
    }

    /**
     * Send request to endpoint
     *
     * @param request Request object
     * @return success flag
     * @throws IOException
     * @throws ClientProtocolException
     */
    public <T> T sendRequest(InstagramRequest<T> request) throws ClientProtocolException, IOException {


        if (!this.isLoggedIn
            && request.requiresLogin()) {
            throw new IllegalStateException("Need to login first!");
        }

        request.setApi(this);
        T response = request.execute();

        return response;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public Instagram4j setDeviceId(String deviceId) {
        this.deviceId = deviceId;
        return this;
    }

    public String getUuid() {
        return uuid;
    }

    public Instagram4j setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public Instagram4j setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Instagram4j setPassword(String password) {
        this.password = password;
        return this;
    }

    public long getUserId() {
        return userId;
    }

    public Instagram4j setUserId(long userId) {
        this.userId = userId;
        return this;
    }

    public String getRankToken() {
        return rankToken;
    }

    public Instagram4j setRankToken(String rankToken) {
        this.rankToken = rankToken;
        return this;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public Instagram4j setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
        return this;
    }

    public HttpResponse getLastResponse() {
        return lastResponse;
    }

    public Instagram4j setLastResponse(HttpResponse lastResponse) {
        this.lastResponse = lastResponse;
        return this;
    }

    public boolean isDebug() {
        return debug;
    }

    public Instagram4j setDebug(boolean debug) {
        this.debug = debug;
        return this;
    }

    public DefaultHttpClient getClient() {
        return client;
    }

    public Instagram4j setClient(DefaultHttpClient client) {
        this.client = client;
        return this;
    }
}
