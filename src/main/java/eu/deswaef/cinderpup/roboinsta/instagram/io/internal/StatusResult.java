package eu.deswaef.cinderpup.roboinsta.instagram.io.internal;

public class StatusResult {

    public StatusResult() {
    }

    private String status;
    private String message;

    public StatusResult(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public StatusResult setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public StatusResult setMessage(String message) {
        this.message = message;
        return this;
    }
}
