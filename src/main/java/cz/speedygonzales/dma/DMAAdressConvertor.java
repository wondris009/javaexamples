package cz.speedygonzales.dma;

import javax.xml.datatype.DatatypeConfigurationException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vondracek
 * Date: 11.7.13
 * Time: 8:36
 * To change this template use File | Settings | File Templates.
 */
public class DMAAdressConvertor {

    private static List<String> output;


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, DatatypeConfigurationException, ParseException {


        getInputValues("c:\\tmp\\dma\\ccc\\20150219_error_R121502185_3.TXT");

        writeOutput("c:\\tmp\\dma\\out.TXT");


    }

    private static void getInputValues(String fileName) throws IOException {

        output = new ArrayList<String>();

        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        int counter = 0;
        while ((line = br.readLine()) != null) {

            String part1 = line.substring(0, 60);

            String part2 = line.substring(185);

            // process the line.
            output.add(part1 + getName() + part2);

        }
        br.close();
    }

    private static void writeOutput(String outputFile) throws IOException {

        FileWriter fw = new FileWriter(outputFile);

        for (String line : output) {
            fw.write(line + "\n");
        }
        fw.close();
    }

    private static String getName() {

        return "Hellersbergstr. 12                                D  41460Neuss                                                              ";
    }

}
