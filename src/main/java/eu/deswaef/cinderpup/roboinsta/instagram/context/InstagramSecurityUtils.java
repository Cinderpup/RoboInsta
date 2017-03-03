package eu.deswaef.cinderpup.roboinsta.instagram.context;

public class InstagramSecurityUtils {
    public static boolean isLoggedIn() {
        return InstagramContextHolder.getContext().getAuthentication() != null;
    }
}
