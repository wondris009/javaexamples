package cz.speedygonzales.java8.lambdas;

import java.io.File;

/**
 * @author vondracek
 * @since 28.6.2016 18:52
 */
public class MyFile extends File {

    /**
     * Creates a new <code>File</code> instance by converting the given
     * pathname string into an abstract pathname.  If the given string is
     * the empty string, then the result is the empty abstract pathname.
     *
     * @param pathname A pathname string
     * @throws NullPointerException If the <code>pathname</code> argument is <code>null</code>
     */
    public MyFile(String pathname) {

        super(pathname);
    }

    public static boolean isText(File f) {

        return f.getName().endsWith("txt");
    }

}