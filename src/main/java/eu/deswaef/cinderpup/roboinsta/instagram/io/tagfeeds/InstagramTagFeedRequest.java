package eu.deswaef.cinderpup.roboinsta.instagram.io.tagfeeds;

import eu.deswaef.cinderpup.roboinsta.instagram.io.InstagramGetRequest;

public class InstagramTagFeedRequest extends InstagramGetRequest<InstagramFeedResult> {

    private String tag;

    @Override
    public String getUrl() {
        return "feed/tag/" + tag + "/?rank_token=" + api.getRankToken() + "&ranked_content=true&";
    }

    @Override
    public InstagramFeedResult parseResult(int statusCode, String content) {
        return parseJson(content, InstagramFeedResult.class);
    }

}
