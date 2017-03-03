package eu.deswaef.cinderpup.roboinsta.instagram;

import eu.deswaef.cinderpup.roboinsta.instagram.context.InstagramContextHolder;
import eu.deswaef.cinderpup.roboinsta.instagram.device.Device;
import eu.deswaef.cinderpup.roboinsta.instagram.io.login.LoginOperations;
import eu.deswaef.cinderpup.roboinsta.instagram.io.tags.TagOperations;

import java.util.UUID;

public class Instagram {

    public Instagram() {
    }

    public LoginOperations login(final String username, final String password) {
        constructDevice(username, password);
        return new LoginOperations()
            .withCredentials(username, password);
    }

    public TagOperations tags() {
        return new TagOperations();
    }


    public String randomUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    //TODO: devices/context per user
    public Device constructDevice(final String username, final String password) {
        if (InstagramContextHolder.getContext().getDevice() == null) {
            InstagramContextHolder.getContext().setDevice(Device.generateDevice(username, password));
        }
        return InstagramContextHolder.getContext().getDevice();
    }
}
