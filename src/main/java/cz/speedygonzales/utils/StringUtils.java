package cz.speedygonzales.utils;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by: vondracek - 15.3.15 10:24
 */
@Slf4j
public class StringUtils {

    private static StringUtils instance;

    private StringUtils() {

    }

    public static StringUtils getInstance() {

        if (instance == null) {
            instance = new StringUtils();
        }
        return instance;
    }

    /**
     * Serialize string array into comma seprated values.
     *
     * @param values
     * @return
     */
    public String printArrayValues(String[] values) {


        StringBuilder sb = new StringBuilder();

        int counter = 0;

        int arrayLength = values.length;


        for (String value : values) {

            if (counter < arrayLength - 1) {
                sb.append(value).append(",");
            } else {
                sb.append(value);
            }

            counter++;
        }

        return sb.toString();
    }

    public void logMessage(String msg, Object logLevel) {


        System.out.println(msg);
    }

    public void logMessage(String msg) {
        logMessage(msg, null);
    }


}
