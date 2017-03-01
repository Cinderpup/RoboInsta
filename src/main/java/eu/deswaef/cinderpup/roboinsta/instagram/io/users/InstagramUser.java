package eu.deswaef.cinderpup.roboinsta.instagram.io.users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InstagramUser {

    public InstagramUser() {
    }

    public boolean is_private;
    public boolean is_verified;
    public String username;
    public boolean has_chaining;
    public boolean is_business;
    public int media_count;
    public String profile_pic_id;
    public String external_url;
    public String full_name;
    public boolean has_biography_translation;
    public boolean has_anonymous_profile_picture;
    public boolean is_favorite;
    public String public_phone_country_code;
    public String public_phone_number;
    public String public_email;
    public long pk;
    public int geo_media_count;
    public int usertags_count;
    public String profile_pic_url;
    public String address_street;
    public String city_name;
    public String zip;
    public String direct_messaging;
    public String business_contact_method;
    public String biography;
    public int follower_count;
    public List<Map<String, Object>> hd_profile_pic_versions;
    public Map<String, Object> hd_profile_pic_url_info;
    public String external_lynx_url;
    public int following_count;
    public float latitude;
    public float longitude;

    public boolean isIs_private() {
        return is_private;
    }

    public InstagramUser setIs_private(boolean is_private) {
        this.is_private = is_private;
        return this;
    }

    public boolean isIs_verified() {
        return is_verified;
    }

    public InstagramUser setIs_verified(boolean is_verified) {
        this.is_verified = is_verified;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public InstagramUser setUsername(String username) {
        this.username = username;
        return this;
    }

    public boolean isHas_chaining() {
        return has_chaining;
    }

    public InstagramUser setHas_chaining(boolean has_chaining) {
        this.has_chaining = has_chaining;
        return this;
    }

    public boolean isIs_business() {
        return is_business;
    }

    public InstagramUser setIs_business(boolean is_business) {
        this.is_business = is_business;
        return this;
    }

    public int getMedia_count() {
        return media_count;
    }

    public InstagramUser setMedia_count(int media_count) {
        this.media_count = media_count;
        return this;
    }

    public String getProfile_pic_id() {
        return profile_pic_id;
    }

    public InstagramUser setProfile_pic_id(String profile_pic_id) {
        this.profile_pic_id = profile_pic_id;
        return this;
    }

    public String getExternal_url() {
        return external_url;
    }

    public InstagramUser setExternal_url(String external_url) {
        this.external_url = external_url;
        return this;
    }

    public String getFull_name() {
        return full_name;
    }

    public InstagramUser setFull_name(String full_name) {
        this.full_name = full_name;
        return this;
    }

    public boolean isHas_biography_translation() {
        return has_biography_translation;
    }

    public InstagramUser setHas_biography_translation(boolean has_biography_translation) {
        this.has_biography_translation = has_biography_translation;
        return this;
    }

    public boolean isHas_anonymous_profile_picture() {
        return has_anonymous_profile_picture;
    }

    public InstagramUser setHas_anonymous_profile_picture(boolean has_anonymous_profile_picture) {
        this.has_anonymous_profile_picture = has_anonymous_profile_picture;
        return this;
    }

    public boolean isIs_favorite() {
        return is_favorite;
    }

    public InstagramUser setIs_favorite(boolean is_favorite) {
        this.is_favorite = is_favorite;
        return this;
    }

    public String getPublic_phone_country_code() {
        return public_phone_country_code;
    }

    public InstagramUser setPublic_phone_country_code(String public_phone_country_code) {
        this.public_phone_country_code = public_phone_country_code;
        return this;
    }

    public String getPublic_phone_number() {
        return public_phone_number;
    }

    public InstagramUser setPublic_phone_number(String public_phone_number) {
        this.public_phone_number = public_phone_number;
        return this;
    }

    public String getPublic_email() {
        return public_email;
    }

    public InstagramUser setPublic_email(String public_email) {
        this.public_email = public_email;
        return this;
    }

    public long getPk() {
        return pk;
    }

    public InstagramUser setPk(long pk) {
        this.pk = pk;
        return this;
    }

    public int getGeo_media_count() {
        return geo_media_count;
    }

    public InstagramUser setGeo_media_count(int geo_media_count) {
        this.geo_media_count = geo_media_count;
        return this;
    }

    public int getUsertags_count() {
        return usertags_count;
    }

    public InstagramUser setUsertags_count(int usertags_count) {
        this.usertags_count = usertags_count;
        return this;
    }

    public String getProfile_pic_url() {
        return profile_pic_url;
    }

    public InstagramUser setProfile_pic_url(String profile_pic_url) {
        this.profile_pic_url = profile_pic_url;
        return this;
    }

    public String getAddress_street() {
        return address_street;
    }

    public InstagramUser setAddress_street(String address_street) {
        this.address_street = address_street;
        return this;
    }

    public String getCity_name() {
        return city_name;
    }

    public InstagramUser setCity_name(String city_name) {
        this.city_name = city_name;
        return this;
    }

    public String getZip() {
        return zip;
    }

    public InstagramUser setZip(String zip) {
        this.zip = zip;
        return this;
    }

    public String getDirect_messaging() {
        return direct_messaging;
    }

    public InstagramUser setDirect_messaging(String direct_messaging) {
        this.direct_messaging = direct_messaging;
        return this;
    }

    public String getBusiness_contact_method() {
        return business_contact_method;
    }

    public InstagramUser setBusiness_contact_method(String business_contact_method) {
        this.business_contact_method = business_contact_method;
        return this;
    }

    public String getBiography() {
        return biography;
    }

    public InstagramUser setBiography(String biography) {
        this.biography = biography;
        return this;
    }

    public int getFollower_count() {
        return follower_count;
    }

    public InstagramUser setFollower_count(int follower_count) {
        this.follower_count = follower_count;
        return this;
    }

    public List<Map<String, Object>> getHd_profile_pic_versions() {
        return hd_profile_pic_versions;
    }

    public InstagramUser setHd_profile_pic_versions(List<Map<String, Object>> hd_profile_pic_versions) {
        this.hd_profile_pic_versions = hd_profile_pic_versions;
        return this;
    }

    public Map<String, Object> getHd_profile_pic_url_info() {
        return hd_profile_pic_url_info;
    }

    public InstagramUser setHd_profile_pic_url_info(Map<String, Object> hd_profile_pic_url_info) {
        this.hd_profile_pic_url_info = hd_profile_pic_url_info;
        return this;
    }

    public String getExternal_lynx_url() {
        return external_lynx_url;
    }

    public InstagramUser setExternal_lynx_url(String external_lynx_url) {
        this.external_lynx_url = external_lynx_url;
        return this;
    }

    public int getFollowing_count() {
        return following_count;
    }

    public InstagramUser setFollowing_count(int following_count) {
        this.following_count = following_count;
        return this;
    }

    public float getLatitude() {
        return latitude;
    }

    public InstagramUser setLatitude(float latitude) {
        this.latitude = latitude;
        return this;
    }

    public float getLongitude() {
        return longitude;
    }

    public InstagramUser setLongitude(float longitude) {
        this.longitude = longitude;
        return this;
    }
}
