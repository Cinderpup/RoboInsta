package eu.deswaef.cinderpup.roboinsta.instagram.io.login;

import java.util.Map;

public class InstagramLoginResult {
    private String status;
    private Map<String, Object> logged_in_user;

    public String getStatus() {
        return status;
    }

    public InstagramLoginResult setStatus(String status) {
        this.status = status;
        return this;
    }

    public Map<String, Object> getLogged_in_user() {
        return logged_in_user;
    }

    public InstagramLoginResult setLogged_in_user(Map<String, Object> logged_in_user) {
        this.logged_in_user = logged_in_user;
        return this;
    }
}
