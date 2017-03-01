package eu.deswaef.cinderpup.roboinsta.instagram.io.login;

public class InstagramLoginPayload {
    private String username;
    private String phone_id;
    private String _csrftoken;
    private String guid;
    private String device_id;
    private String password;
    private int login_attempt_account = 0;

    public String getUsername() {
        return username;
    }

    public InstagramLoginPayload setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPhone_id() {
        return phone_id;
    }

    public InstagramLoginPayload setPhone_id(String phone_id) {
        this.phone_id = phone_id;
        return this;
    }

    public String get_csrftoken() {
        return _csrftoken;
    }

    public InstagramLoginPayload set_csrftoken(String _csrftoken) {
        this._csrftoken = _csrftoken;
        return this;
    }

    public String getGuid() {
        return guid;
    }

    public InstagramLoginPayload setGuid(String guid) {
        this.guid = guid;
        return this;
    }

    public String getDevice_id() {
        return device_id;
    }

    public InstagramLoginPayload setDevice_id(String device_id) {
        this.device_id = device_id;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public InstagramLoginPayload setPassword(String password) {
        this.password = password;
        return this;
    }

    public int getLogin_attempt_account() {
        return login_attempt_account;
    }

    public InstagramLoginPayload setLogin_attempt_account(int login_attempt_account) {
        this.login_attempt_account = login_attempt_account;
        return this;
    }
}
