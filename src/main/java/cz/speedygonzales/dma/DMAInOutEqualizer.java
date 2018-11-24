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
public class DMAInOutEqualizer {


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, DatatypeConfigurationException, ParseException {

        if (args != null && args.length != 2) {
            throw new IllegalStateException("Specify first parameter as input file and scond parameter as output file!");
        }

        DMAInOutEqualizer equalizer = new DMAInOutEqualizer();
        List<String> input = equalizer.readFile(args[0]);

        List<String> output = equalizer.readFile(args[1]);

        List<String> result = new ArrayList<String>();

        for (String inputLine : input) {
            if (!output.contains(inputLine)) {
                result.add(inputLine);
            }
        }

        equalizer.writeOutput(result);
    }

    private List<String> readFile(String fileName) throws IOException {

        List<String> result = new ArrayList<String>();

        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = br.readLine()) != null) {
            // process the line.
            result.add(line.substring(0, 277));
        }
        br.close();

        return result;
    }

    private void writeOutput(List<String> inputContent) throws IOException {

        FileWriter fw = new FileWriter("new_input.txt");

        for (String line : inputContent) {
            fw.write(line + "\n");
        }
        fw.close();
    }
}
