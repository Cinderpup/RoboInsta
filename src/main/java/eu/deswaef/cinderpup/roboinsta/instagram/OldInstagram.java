package eu.deswaef.cinderpup.roboinsta.instagram;

import eu.deswaef.cinderpup.roboinsta.instagram.context.InstagramContextHolder;
import eu.deswaef.cinderpup.roboinsta.instagram.io.InstagramRequest;
import eu.deswaef.cinderpup.roboinsta.instagram.io.internal.InstagramFetchHeadersRequest;
import eu.deswaef.cinderpup.roboinsta.instagram.io.login.InstagramLoginPayload;
import eu.deswaef.cinderpup.roboinsta.instagram.io.login.InstagramLoginRequest;
import eu.deswaef.cinderpup.roboinsta.instagram.io.login.InstagramLoginResult;
import eu.deswaef.cinderpup.roboinsta.instagram.io.login.LoginOperations;
import eu.deswaef.cinderpup.roboinsta.instagram.utils.InstagramHashing;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

public class OldInstagram {
    protected String deviceId;

    protected String uuid;

    protected String username;

    protected String password;

    protected long userId;

    protected String rankToken;

    protected boolean isLoggedIn;

    protected HttpResponse lastResponse;

    protected boolean debug;

    protected HttpClient client;
    private CookieStore cookieStore;


    /**
     * @param username Username
     * @param password Password
     */
    public OldInstagram(String username, String password) {
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

        this.deviceId = InstagramHashing.generateDeviceId(this.username, "");
        this.uuid = randomUUID();

        this.cookieStore = InstagramContextHolder.getContext().getCookieStore();
        this.client = InstagramContextHolder.getContext().getHttpClient();
        // this.client.getParams().setParameter(ClientPNames.COOKIE_POLICY, CookiePolicy.BROWSER_COMPATIBILITY);

    }

    public String randomUUID() {
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

    public String getOrFetchCsrf() throws ClientProtocolException, IOException {
        Optional<Cookie> checkCookie = getCsrfCookie();
        if (!checkCookie.isPresent()) {
            sendRequest(new InstagramFetchHeadersRequest());
            checkCookie = getCsrfCookie();
        }
        return checkCookie.get().getValue();
    }

    public Optional<Cookie> getCsrfCookie() {
        return cookieStore.getCookies()
            .stream()
            .filter(cookie -> cookie.getName().equalsIgnoreCase("csrftoken"))
            .findFirst();
    }

    public <T> T sendRequest(InstagramRequest<T> request) throws ClientProtocolException, IOException {
        if (!this.isLoggedIn
            && request.requiresLogin()) {
            throw new IllegalStateException("Need to login first!");
        }
        return request.execute();
    }

    public String getDeviceId() {
        return deviceId;
    }

    public OldInstagram setDeviceId(String deviceId) {
        this.deviceId = deviceId;
        return this;
    }

    public String getUuid() {
        return uuid;
    }

    public OldInstagram setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public OldInstagram setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public OldInstagram setPassword(String password) {
        this.password = password;
        return this;
    }

    public long getUserId() {
        return userId;
    }

    public OldInstagram setUserId(long userId) {
        this.userId = userId;
        return this;
    }

    public String getRankToken() {
        return rankToken;
    }

    public OldInstagram setRankToken(String rankToken) {
        this.rankToken = rankToken;
        return this;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public OldInstagram setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
        return this;
    }

    public HttpResponse getLastResponse() {
        return lastResponse;
    }

    public OldInstagram setLastResponse(HttpResponse lastResponse) {
        this.lastResponse = lastResponse;
        return this;
    }

    public boolean isDebug() {
        return debug;
    }

    public OldInstagram setDebug(boolean debug) {
        this.debug = debug;
        return this;
    }

    public HttpClient getClient() {
        return client;
    }

    public OldInstagram setClient(HttpClient client) {
        this.client = client;
        return this;
    }
}
