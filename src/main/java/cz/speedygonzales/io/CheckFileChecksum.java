package cz.speedygonzales.io;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author vondracek
 * @since 25.10.2015 15:47
 */
@Slf4j
public class CheckFileChecksum {

    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {

        MessageDigest md = MessageDigest.getInstance("SHA1");

        FileInputStream fis = new FileInputStream("c:/workspaces/JavaExamples/data/renca.json");

        byte[] buffer = new byte[1024];

        int nread = 0;

        while ((nread = fis.read(buffer)) != -1) {
            md.update(buffer, 0, nread);
        }

        byte[] mdDigest = md.digest();

        //convert the byte to hex format
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mdDigest.length; i++) {
            sb.append(Integer.toString((mdDigest[i] & 0xff) + 0x100, 16).substring(1));
        }

        log.info("Digest(in hex format):: " + sb.toString());
    }
}
