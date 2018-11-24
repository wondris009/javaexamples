package cz.speedygonzales.json;

import lombok.extern.slf4j.Slf4j;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author vondracek
 * @since 25.10.2015 14:52
 */
@Slf4j
public class JsonConverterDemo {

    private static final String FILE_PATH = "/Users/vondracek/tmp/renca.json";

    public static void main(String[] args) throws IOException {

        JsonConverterDemo app = new JsonConverterDemo();

        //write to file system
        app.writeToJSON();

        //read from file system and create POJO
        User user = app.readFromJSON();

        log.info(user.toString());

    }

    private User readFromJSON() throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(FILE_PATH), User.class);
    }

    private void writeToJSON() throws IOException {

        User renca = new User();

        renca.setName("Renata Santorova-Vondrackova");
        renca.setAge(23);

        String[] messages = {"deti", "svatba", "prdel", "zlobim Lukase", "jsem zlobiva holka", "jdu do mesta sama"};

        renca.setMessages(Arrays.asList(messages));

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(FILE_PATH), renca);
    }
}
