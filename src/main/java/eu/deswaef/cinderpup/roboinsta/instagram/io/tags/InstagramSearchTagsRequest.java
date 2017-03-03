package eu.deswaef.cinderpup.roboinsta.instagram.io.tags;

import eu.deswaef.cinderpup.roboinsta.instagram.context.InstagramContextHolder;
import eu.deswaef.cinderpup.roboinsta.instagram.io.InstagramGetRequest;

public class InstagramSearchTagsRequest extends InstagramGetRequest<InstagramSearchTagsResult> {

    private String query;

    public InstagramSearchTagsRequest(String query) {
        this.query = query;
    }

    @Override
    public String getUrl() {
        return "tags/search/?is_typeahead=true&q=" + query + "&rank_token=" + InstagramContextHolder.getContext().getRankToken();
    }

    @Override
    public String getPayload() {
        return null;
    }

    @Override
    public InstagramSearchTagsResult parseResult(int statusCode, String content) {
        return parseJson(content, InstagramSearchTagsResult.class);
    }

}
