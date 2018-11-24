package cz.speedygonzales.io;

import java.io.File;
import java.io.IOException;

/**
 * TODO add description
 *
 * @author: vondracek   5.11.13
 */
public class ListDirUtils {

    private static final String PATH = "c:/workspaces/PRADA//pradaUITests/src/speedygonzales/java/cz/cngroup/prada/uitests/speedygonzales/users";

    public static void main(String[] args) throws IOException {

        File dir = new File(PATH);

        File[] files = dir.listFiles();

        for (File file : files) {

            String fileName = file.getName();

            //limits to files with length > 5
            if (fileName.length() > 5) {
                fileName = fileName.substring(0, fileName.length() - 5);
                System.out.println(fileName);
            } else {
                continue;
            }

        }

    }

}
