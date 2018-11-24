package cz.speedygonzales.java8.strings;

import lombok.extern.slf4j.Slf4j;

/**
 * @author vondracek
 * @since 28.6.2016 10:46
 */
@Slf4j
public class StringTester {

    public static void main(String[] args) {

        StringTester stringTester = new StringTester();
        stringTester.howToJoin();
    }

    private void howToJoin() {

        String join = String.join("---", "joseph", "charles");
        log.info(join);
    }


}
