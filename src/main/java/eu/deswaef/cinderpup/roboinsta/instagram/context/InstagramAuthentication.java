package eu.deswaef.cinderpup.roboinsta.instagram.context;

import org.apache.http.client.CookieStore;

public class InstagramAuthentication {
    private String username;
    private String password;
    private String userId;

    public String getUsername() {
        return username;
    }

    public InstagramAuthentication setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public InstagramAuthentication setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public InstagramAuthentication setUserId(String userId) {
        this.userId = userId;
        return this;
    }
}
