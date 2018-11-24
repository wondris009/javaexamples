package cz.speedygonzales.strings;

import lombok.extern.slf4j.Slf4j;

/**
 * @author vondracek
 * @since 25.10.2015 14:42
 */
@Slf4j
public class ShowBytes {

    public static void main(String[] args) {

        String input = "Ahoj Renatko, jak se mas?????";

        byte[] bytes = input.getBytes();

        for (byte b : bytes) {

            log.info(String.valueOf(b));

        }


    }


}
