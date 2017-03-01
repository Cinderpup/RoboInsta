package eu.deswaef.cinderpup.roboinsta.instagram;

import org.apache.commons.codec.binary.Hex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class InstagramHashing {

    @Autowired
    private InstagramConstants instagramConstants;

    public static final String CHARSET = "0123456789abcdef";

    protected static String digest(String codec, String source) {
        try {
            MessageDigest digest = MessageDigest.getInstance(codec);
            byte[] digestBytes = digest.digest(source.getBytes(Charset.forName("UTF-8")));
            return hexlate(digestBytes, digestBytes.length);
        } catch (NoSuchAlgorithmException nsae) {
            throw new RuntimeException(codec + " codec not available");
        }
    }

    public static String md5hex(String source) {
        return digest("MD5", source);
    }

    /**
     * Convert the byte array to a hexadecimal presentation (String)
     *
     * @param bytes        byte array
     * @param initialCount count (length) of the input
     * @return
     */
    protected static String hexlate(byte[] bytes, int initialCount) {
        if (bytes == null) {
            return "";
        }

        int count = Math.min(initialCount, bytes.length);
        char[] chars = new char[count * 2];

        for (int i = 0; i < count; ++i) {
            int val = bytes[i];
            if (val < 0) {
                val += 256;
            }
            chars[(2 * i)] = CHARSET.charAt(val / 16);
            chars[(2 * i + 1)] = CHARSET.charAt(val % 16);
        }

        return new String(chars);
    }

    public static String generateDeviceId(String username, String password) {
        String seed = md5hex(username + password);
        String volatileSeed = "12345";

        return "android-" + md5hex(seed + volatileSeed).substring(0, 16);
    }

    public static String generateHash(String key, String string) {
        SecretKeySpec object = new SecretKeySpec(key.getBytes(), "HmacSHA256");
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init((Key) object);
            byte[] byteArray = mac.doFinal(string.getBytes("UTF-8"));
            return new String(new Hex().encode(byteArray), "ISO-8859-1");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String generateSignature(String payload) {
        try {
            String parsedData = URLEncoder.encode(payload, "UTF-8");

            String signedBody = generateHash(InstagramConstants.apiKey, payload);

            return "ig_sig_key_version=" + InstagramConstants.apiKeyVersion + "&signed_body=" + signedBody + '.'
                + parsedData;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
