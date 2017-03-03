package eu.deswaef.cinderpup.roboinsta.instagram.device;

import eu.deswaef.cinderpup.roboinsta.instagram.utils.InstagramHashing;

import java.util.UUID;

public class Device {
    private String deviceId;
    private String phoneId;
    private String guid;

    public static Device generateDevice(final String username, final String password) {
        return new Device()
            .setDeviceId(InstagramHashing.generateDeviceId(username, password))
            .setGuid(randomUUID())
            .setPhoneId(randomUUID());
    }

    public String getDeviceId() {
        return deviceId;
    }

    public Device setDeviceId(String deviceId) {
        this.deviceId = deviceId;
        return this;
    }

    public String getPhoneId() {
        return phoneId;
    }

    public Device setPhoneId(String phoneId) {
        this.phoneId = phoneId;
        return this;
    }

    public String getGuid() {
        return guid;
    }

    public Device setGuid(String guid) {
        this.guid = guid;
        return this;
    }

    public static String randomUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
