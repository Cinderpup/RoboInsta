package eu.deswaef.cinderpup.roboinsta.instagram.io.tagfeeds;

import java.util.List;

public class InstagramFeedResult {

    public InstagramFeedResult() {
    }

    private boolean auto_load_more_enabled;
    private int num_results;
    private String next_max_id;
    private String status;

    private List<InstagramFeedItem> items;
    private List<InstagramFeedItem> ranked_items;

    private boolean more_available;

}
