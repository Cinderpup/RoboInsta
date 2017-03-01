package eu.deswaef.cinderpup.roboinsta.instagram.io.tags;

public class InstagramSearchTagsResultTag {

    public InstagramSearchTagsResultTag() {
    }

    public String name;
    public long id;
    public int media_count;

    public String getName() {
        return name;
    }

    public InstagramSearchTagsResultTag setName(String name) {
        this.name = name;
        return this;
    }

    public long getId() {
        return id;
    }

    public InstagramSearchTagsResultTag setId(long id) {
        this.id = id;
        return this;
    }

    public int getMedia_count() {
        return media_count;
    }

    public InstagramSearchTagsResultTag setMedia_count(int media_count) {
        this.media_count = media_count;
        return this;
    }
}
