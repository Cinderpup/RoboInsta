package eu.deswaef.cinderpup.roboinsta.instagram.io.likes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InstagramLikeResult {

    public InstagramLikeResult() {
    }

    private String status;
    private boolean spam;
    private String feedback_ignore_label;
    private String feedback_title;
    private String message;
    private String feedback_message;
    private String feedback_url;
    private String feedback_action;
    private String feedback_appeal_label;

    public String getStatus() {
        return status;
    }

    public InstagramLikeResult setStatus(String status) {
        this.status = status;
        return this;
    }

    public boolean isSpam() {
        return spam;
    }

    public InstagramLikeResult setSpam(boolean spam) {
        this.spam = spam;
        return this;
    }

    public String getFeedback_ignore_label() {
        return feedback_ignore_label;
    }

    public InstagramLikeResult setFeedback_ignore_label(String feedback_ignore_label) {
        this.feedback_ignore_label = feedback_ignore_label;
        return this;
    }

    public String getFeedback_title() {
        return feedback_title;
    }

    public InstagramLikeResult setFeedback_title(String feedback_title) {
        this.feedback_title = feedback_title;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public InstagramLikeResult setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getFeedback_message() {
        return feedback_message;
    }

    public InstagramLikeResult setFeedback_message(String feedback_message) {
        this.feedback_message = feedback_message;
        return this;
    }

    public String getFeedback_url() {
        return feedback_url;
    }

    public InstagramLikeResult setFeedback_url(String feedback_url) {
        this.feedback_url = feedback_url;
        return this;
    }

    public String getFeedback_action() {
        return feedback_action;
    }

    public InstagramLikeResult setFeedback_action(String feedback_action) {
        this.feedback_action = feedback_action;
        return this;
    }

    public String getFeedback_appeal_label() {
        return feedback_appeal_label;
    }

    public InstagramLikeResult setFeedback_appeal_label(String feedback_appeal_label) {
        this.feedback_appeal_label = feedback_appeal_label;
        return this;
    }
}
