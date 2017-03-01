package eu.deswaef.cinderpup.roboinsta.instagram.io.internal;

import eu.deswaef.cinderpup.roboinsta.instagram.io.InstagramGetRequest;

import java.util.UUID;

public class InstagramFetchHeadersRequest extends InstagramGetRequest<StatusResult> {

    @Override
    public String getUrl() {
        return "si/fetch_headers/?challenge_type=signup&guid=" + UUID.randomUUID().toString();
    }

    @Override
    public String getPayload() {
        return null;
    }

    @Override
    public boolean requiresLogin() {
        return false;
    }

    @Override
    public StatusResult parseResult(int statusCode, String content) {
        return parseJson(content, StatusResult.class);
    }

}
