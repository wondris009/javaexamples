package cz.speedygonzales.io;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author vondracek
 * @since 25.10.2015 11:05
 */
@Slf4j
public class FileReader {

    public static void main(String[] args) throws IOException {

        String path = "c:/workspaces/JavaExamples/data/content_for_read.txt";

        BufferedReader reader = new BufferedReader(new java.io.FileReader(path));

        String actualLine = null;

        while ((actualLine = reader.readLine()) != null) {
            log.info(actualLine);
        }
    }


}
