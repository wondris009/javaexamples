package cz.speedygonzales.java8.streams;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author vondracek
 * @since 28.6.2016 19:20
 */
public class FilterTester2 {


    public static void main(String[] args) {

        Arrays.asList(1, 2, 1, 2, 4, 47, 1, 2, 4, 1, 2, 2, 4, 3, 7, 5, 1, 2, 2, 2, 2, 1, 2, 2, 2, 4, 48).stream().filter(i -> i % 2 == 0).distinct().forEach(System.out::println);


        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);

    }

}
