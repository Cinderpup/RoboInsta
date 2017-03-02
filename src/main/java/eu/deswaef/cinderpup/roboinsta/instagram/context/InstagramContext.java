package eu.deswaef.cinderpup.roboinsta.instagram.context;

public class InstagramContext {

    private InstagramAuthentication authentication;

    public InstagramAuthentication getAuthentication() {
        return authentication;
    }

    public InstagramContext setAuthentication(InstagramAuthentication authentication) {
        this.authentication = authentication;
        return this;
    }
}
