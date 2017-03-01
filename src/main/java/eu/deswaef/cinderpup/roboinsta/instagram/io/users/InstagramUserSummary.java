package eu.deswaef.cinderpup.roboinsta.instagram.io.users;

public class InstagramUserSummary {

    public InstagramUserSummary() {
    }

    public boolean is_verified;
    public String profile_pic_id;
    public boolean is_favorite;
    public boolean is_private;
    public String username;
    public long pk;
    public String profile_pic_url;
    public boolean has_anonymous_profile_picture;
    public String full_name;

    public boolean isIs_verified() {
        return is_verified;
    }

    public InstagramUserSummary setIs_verified(boolean is_verified) {
        this.is_verified = is_verified;
        return this;
    }

    public String getProfile_pic_id() {
        return profile_pic_id;
    }

    public InstagramUserSummary setProfile_pic_id(String profile_pic_id) {
        this.profile_pic_id = profile_pic_id;
        return this;
    }

    public boolean isIs_favorite() {
        return is_favorite;
    }

    public InstagramUserSummary setIs_favorite(boolean is_favorite) {
        this.is_favorite = is_favorite;
        return this;
    }

    public boolean isIs_private() {
        return is_private;
    }

    public InstagramUserSummary setIs_private(boolean is_private) {
        this.is_private = is_private;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public InstagramUserSummary setUsername(String username) {
        this.username = username;
        return this;
    }

    public long getPk() {
        return pk;
    }

    public InstagramUserSummary setPk(long pk) {
        this.pk = pk;
        return this;
    }

    public String getProfile_pic_url() {
        return profile_pic_url;
    }

    public InstagramUserSummary setProfile_pic_url(String profile_pic_url) {
        this.profile_pic_url = profile_pic_url;
        return this;
    }

    public boolean isHas_anonymous_profile_picture() {
        return has_anonymous_profile_picture;
    }

    public InstagramUserSummary setHas_anonymous_profile_picture(boolean has_anonymous_profile_picture) {
        this.has_anonymous_profile_picture = has_anonymous_profile_picture;
        return this;
    }

    public String getFull_name() {
        return full_name;
    }

    public InstagramUserSummary setFull_name(String full_name) {
        this.full_name = full_name;
        return this;
    }
}
