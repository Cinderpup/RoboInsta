package eu.deswaef.cinderpup.roboinsta.instagram.io.login;

import com.fasterxml.jackson.databind.ObjectMapper;
import eu.deswaef.cinderpup.roboinsta.instagram.io.InstagramPostRequest;

public class InstagramLoginRequest extends InstagramPostRequest<InstagramLoginResult> {

    private InstagramLoginPayload payload;

    public InstagramLoginRequest(InstagramLoginPayload payload) {
        this.payload = payload;
    }

    @Override
    public String getUrl() {
        return "accounts/login/";
    }

    @Override
    public String getPayload() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(payload);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public InstagramLoginResult parseResult(int statusCode, String content) {
        return parseJson(content, InstagramLoginResult.class);
    }

    @Override
    public boolean requiresLogin() {
        return false;
    }

}
