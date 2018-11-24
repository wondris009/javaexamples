package cz.speedygonzales.map;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class MapDemo {

    public static void main(String[] args) throws IOException {

        TestMap myMap = new TestMap();
        myMap.setInnerMap(new HashMap<>());
        myMap.getInnerMap().put("xx", "yy");

        myMap.setInnerAttribute("aaa");

        ObjectMapper mapper = new ObjectMapper();
//        mapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);
        mapper.writeValue(new File("/Users/vondracek/tmp/map.json"), myMap);

        //Object to JSON in String
        String jsonInString = mapper.writeValueAsString(myMap);

        System.out.println(jsonInString);
    }
}
