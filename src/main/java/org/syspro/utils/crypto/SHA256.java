package org.syspro.utils.crypto;

import org.apache.tomcat.util.buf.HexUtils;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class SHA256 {
    private final MessageDigest messageDigest;

    public SHA256() throws NoSuchAlgorithmException {
        this.messageDigest = MessageDigest.getInstance("SHA-256");
    }

    public String encode(String source) {
        byte[] encodedBytes = messageDigest.digest(source.getBytes(StandardCharsets.UTF_8));
        return HexUtils.toHexString(encodedBytes);
    }
}
