package cz.speedygonzales.utils;

import javax.xml.datatype.DatatypeConfigurationException;
import java.io.IOException;
import java.text.ParseException;

/**
 * Created with IntelliJ IDEA.
 * User: vondracek
 * Date: 11.7.13
 * Time: 8:36
 * To change this template use File | Settings | File Templates.
 */
public class EnumerationCreator {

    private static final String IN = "Vorname|Nachname|StrHnr|PLZ|Ort|Bearbeitungszeichen";


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, DatatypeConfigurationException, ParseException {

        for (String s : IN.split("\\|")) {
            System.out.println(s.toUpperCase() + "(\"" + s + "\"),");
        }


    }


}
