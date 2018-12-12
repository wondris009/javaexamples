package cz.speedygonzales.crypting;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256Demo {

    public static void main(String[] args) throws NoSuchAlgorithmException {

        String text = "hello world!";

        MessageDigest digest = MessageDigest.getInstance("SHA-256"); //hashes the text to 256bit long string, which is 32bytes
        byte[] hash = digest.digest(text.getBytes(StandardCharsets.UTF_8));

        assert hash.length == 32;
        System.out.printf(String.valueOf(hash.length));
    }
}
