package eu.deswaef.cinderpup.roboinsta.instagram.context;

public class InstagramContextHolder {

    private static InstagramContext context;

    public static InstagramContext getContext() {
        if (context == null) {
            context = new InstagramContext();
        }
        return context;
    }

    public static void setContext(InstagramContext newContext) {
        context = newContext;
    }
}
