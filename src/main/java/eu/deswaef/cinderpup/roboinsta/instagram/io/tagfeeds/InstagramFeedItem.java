package eu.deswaef.cinderpup.roboinsta.instagram.io.tagfeeds;

import eu.deswaef.cinderpup.roboinsta.instagram.io.users.InstagramUser;
import eu.deswaef.cinderpup.roboinsta.instagram.io.users.InstagramUserSummary;

import java.util.List;
import java.util.Map;

public class InstagramFeedItem {

    public InstagramFeedItem() {
    }

    public long taken_at;
    public long pk;
    public String id;
    public long device_timestamp;
    public int media_type;
    public String code;
    public String client_cache_key;
    public int filter_type;
    public boolean has_audio;
    public double video_duration;
    public Map<String, Object> attribution;
    public List<Object> video_versions;
    public Map<String, Object> image_versions2;
    public Map<String, Object> usertags;
    public Map<String, Object> location;
    public float lng;
    public float lat;
    public int original_width;
    public int original_height;
    public int view_count;
    public InstagramUser user;

    public String organic_tracking_token;
    public int like_count;
    public List<String> top_likers;
    public List<InstagramUserSummary> likers;
    public boolean has_liked;
    public boolean comment_likes_enabled;
    public boolean has_more_comments;
    public long next_max_id;
    public int max_num_visible_preview_comments;
    public List<Object> preview_comments;
    public List<Object> comments;
    public boolean comment_count;
    public Map<String, Object> caption;

    public boolean caption_is_edited;
    public boolean photo_of_you;
    public boolean comments_disabled;

    public long getTaken_at() {
        return taken_at;
    }

    public InstagramFeedItem setTaken_at(long taken_at) {
        this.taken_at = taken_at;
        return this;
    }

    public long getPk() {
        return pk;
    }

    public InstagramFeedItem setPk(long pk) {
        this.pk = pk;
        return this;
    }

    public String getId() {
        return id;
    }

    public InstagramFeedItem setId(String id) {
        this.id = id;
        return this;
    }

    public long getDevice_timestamp() {
        return device_timestamp;
    }

    public InstagramFeedItem setDevice_timestamp(long device_timestamp) {
        this.device_timestamp = device_timestamp;
        return this;
    }

    public int getMedia_type() {
        return media_type;
    }

    public InstagramFeedItem setMedia_type(int media_type) {
        this.media_type = media_type;
        return this;
    }

    public String getCode() {
        return code;
    }

    public InstagramFeedItem setCode(String code) {
        this.code = code;
        return this;
    }

    public String getClient_cache_key() {
        return client_cache_key;
    }

    public InstagramFeedItem setClient_cache_key(String client_cache_key) {
        this.client_cache_key = client_cache_key;
        return this;
    }

    public int getFilter_type() {
        return filter_type;
    }

    public InstagramFeedItem setFilter_type(int filter_type) {
        this.filter_type = filter_type;
        return this;
    }

    public boolean isHas_audio() {
        return has_audio;
    }

    public InstagramFeedItem setHas_audio(boolean has_audio) {
        this.has_audio = has_audio;
        return this;
    }

    public double getVideo_duration() {
        return video_duration;
    }

    public InstagramFeedItem setVideo_duration(double video_duration) {
        this.video_duration = video_duration;
        return this;
    }

    public Map<String, Object> getAttribution() {
        return attribution;
    }

    public InstagramFeedItem setAttribution(Map<String, Object> attribution) {
        this.attribution = attribution;
        return this;
    }

    public List<Object> getVideo_versions() {
        return video_versions;
    }

    public InstagramFeedItem setVideo_versions(List<Object> video_versions) {
        this.video_versions = video_versions;
        return this;
    }

    public Map<String, Object> getImage_versions2() {
        return image_versions2;
    }

    public InstagramFeedItem setImage_versions2(Map<String, Object> image_versions2) {
        this.image_versions2 = image_versions2;
        return this;
    }

    public Map<String, Object> getUsertags() {
        return usertags;
    }

    public InstagramFeedItem setUsertags(Map<String, Object> usertags) {
        this.usertags = usertags;
        return this;
    }

    public Map<String, Object> getLocation() {
        return location;
    }

    public InstagramFeedItem setLocation(Map<String, Object> location) {
        this.location = location;
        return this;
    }

    public float getLng() {
        return lng;
    }

    public InstagramFeedItem setLng(float lng) {
        this.lng = lng;
        return this;
    }

    public float getLat() {
        return lat;
    }

    public InstagramFeedItem setLat(float lat) {
        this.lat = lat;
        return this;
    }

    public int getOriginal_width() {
        return original_width;
    }

    public InstagramFeedItem setOriginal_width(int original_width) {
        this.original_width = original_width;
        return this;
    }

    public int getOriginal_height() {
        return original_height;
    }

    public InstagramFeedItem setOriginal_height(int original_height) {
        this.original_height = original_height;
        return this;
    }

    public int getView_count() {
        return view_count;
    }

    public InstagramFeedItem setView_count(int view_count) {
        this.view_count = view_count;
        return this;
    }

    public InstagramUser getUser() {
        return user;
    }

    public InstagramFeedItem setUser(InstagramUser user) {
        this.user = user;
        return this;
    }

    public String getOrganic_tracking_token() {
        return organic_tracking_token;
    }

    public InstagramFeedItem setOrganic_tracking_token(String organic_tracking_token) {
        this.organic_tracking_token = organic_tracking_token;
        return this;
    }

    public int getLike_count() {
        return like_count;
    }

    public InstagramFeedItem setLike_count(int like_count) {
        this.like_count = like_count;
        return this;
    }

    public List<String> getTop_likers() {
        return top_likers;
    }

    public InstagramFeedItem setTop_likers(List<String> top_likers) {
        this.top_likers = top_likers;
        return this;
    }

    public List<InstagramUserSummary> getLikers() {
        return likers;
    }

    public InstagramFeedItem setLikers(List<InstagramUserSummary> likers) {
        this.likers = likers;
        return this;
    }

    public boolean isHas_liked() {
        return has_liked;
    }

    public InstagramFeedItem setHas_liked(boolean has_liked) {
        this.has_liked = has_liked;
        return this;
    }

    public boolean isComment_likes_enabled() {
        return comment_likes_enabled;
    }

    public InstagramFeedItem setComment_likes_enabled(boolean comment_likes_enabled) {
        this.comment_likes_enabled = comment_likes_enabled;
        return this;
    }

    public boolean isHas_more_comments() {
        return has_more_comments;
    }

    public InstagramFeedItem setHas_more_comments(boolean has_more_comments) {
        this.has_more_comments = has_more_comments;
        return this;
    }

    public long getNext_max_id() {
        return next_max_id;
    }

    public InstagramFeedItem setNext_max_id(long next_max_id) {
        this.next_max_id = next_max_id;
        return this;
    }

    public int getMax_num_visible_preview_comments() {
        return max_num_visible_preview_comments;
    }

    public InstagramFeedItem setMax_num_visible_preview_comments(int max_num_visible_preview_comments) {
        this.max_num_visible_preview_comments = max_num_visible_preview_comments;
        return this;
    }

    public List<Object> getPreview_comments() {
        return preview_comments;
    }

    public InstagramFeedItem setPreview_comments(List<Object> preview_comments) {
        this.preview_comments = preview_comments;
        return this;
    }

    public List<Object> getComments() {
        return comments;
    }

    public InstagramFeedItem setComments(List<Object> comments) {
        this.comments = comments;
        return this;
    }

    public boolean isComment_count() {
        return comment_count;
    }

    public InstagramFeedItem setComment_count(boolean comment_count) {
        this.comment_count = comment_count;
        return this;
    }

    public Map<String, Object> getCaption() {
        return caption;
    }

    public InstagramFeedItem setCaption(Map<String, Object> caption) {
        this.caption = caption;
        return this;
    }

    public boolean isCaption_is_edited() {
        return caption_is_edited;
    }

    public InstagramFeedItem setCaption_is_edited(boolean caption_is_edited) {
        this.caption_is_edited = caption_is_edited;
        return this;
    }

    public boolean isPhoto_of_you() {
        return photo_of_you;
    }

    public InstagramFeedItem setPhoto_of_you(boolean photo_of_you) {
        this.photo_of_you = photo_of_you;
        return this;
    }

    public boolean isComments_disabled() {
        return comments_disabled;
    }

    public InstagramFeedItem setComments_disabled(boolean comments_disabled) {
        this.comments_disabled = comments_disabled;
        return this;
    }
}
