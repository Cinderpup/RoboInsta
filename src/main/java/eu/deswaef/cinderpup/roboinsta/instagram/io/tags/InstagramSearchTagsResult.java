package eu.deswaef.cinderpup.roboinsta.instagram.io.tags;

import java.util.List;

public class InstagramSearchTagsResult {

    public InstagramSearchTagsResult() {
    }

    private List<InstagramSearchTagsResultTag> results;
    private String status;
    private boolean has_more;
    private int num_results;

    public List<InstagramSearchTagsResultTag> getResults() {
        return results;
    }

    public InstagramSearchTagsResult setResults(List<InstagramSearchTagsResultTag> results) {
        this.results = results;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public InstagramSearchTagsResult setStatus(String status) {
        this.status = status;
        return this;
    }

    public boolean isHas_more() {
        return has_more;
    }

    public InstagramSearchTagsResult setHas_more(boolean has_more) {
        this.has_more = has_more;
        return this;
    }

    public int getNum_results() {
        return num_results;
    }

    public InstagramSearchTagsResult setNum_results(int num_results) {
        this.num_results = num_results;
        return this;
    }
}
