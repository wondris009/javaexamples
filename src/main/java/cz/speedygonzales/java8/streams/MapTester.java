package cz.speedygonzales.java8.streams;

import java.util.Arrays;
import java.util.List;

/**
 * @author vondracek
 * @since 28.6.2016 19:20
 */
public class MapTester {


    public static void main(String[] args) {

        List<String> words = Arrays.asList("Java8", "Lambdas", "In", "Action");
        words.stream()
                .map(String::length)
                .forEach(System.out::println);


    }

}
