package cz.speedygonzales.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

/**
 * Writes text content to file using {@link java.io.FileWriter}.
 *
 * @author vondracek
 * @since 15.10.2015 15:42
 */
public class FileWriter {

    private static final Logger LOG = LoggerFactory.getLogger(FileWriter.class);

    public static void main(String[] args) {

        generateContent(args[0]);
    }

    private static void generateContent(String outputFilePath) {

        java.io.FileWriter writer = null;
        try {

            File file = new File(outputFilePath);
            if (!file.exists()) {
                file.createNewFile();
            }

            writer = new java.io.FileWriter(outputFilePath);

            writer.append("DisplayName");
            writer.append(',');
            writer.append("Age");
            writer.append('\n');

            writer.append("MKYONG");
            writer.append(',');
            writer.append("26");
            writer.append('\n');

            writer.append("YOUR NAME");
            writer.append(',');
            writer.append("29");
            writer.append('\n');

            writer.flush();
        } catch (IOException e) {

            LOG.error("Unable to locate file with path {}", outputFilePath);

        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    LOG.error("Unable to close FileWriter");
                }
            }
        }


    }


}
