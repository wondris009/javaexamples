package cz.speedygonzales.io;

import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author vondracek
 * @since 17.11.2015 19:22
 */
public class Consoler {

    public static void main(String[] args) {

        InputStreamReader cin = null;

        try {
            cin = new InputStreamReader(System.in);
            System.out.println("Enter characters, 'q' to quit.");
            char c = 0;
            while (c != 'q') {
                c = (char) cin.read();
                if (c != 'q') {
                    System.out.print(c);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (cin != null) {
                try {
                    cin.close();
                } catch (IOException e) {


                }
            }
        }
    }
}
