package cz.speedygonzales.sportka;

import cz.speedygonzales.random.RandomUtils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created with IntelliJ IDEA.
 * User: vondracek
 * Date: 10.9.13
 * Time: 9:24
 * To change this template use File | Settings | File Templates.
 */
public class SportkaGenerator {

    public static void main(String[] args) {
        for (int j = 0; j < 100; j++) {
            System.out.println(generateSportkaNumbers());
        }
    }

    private static String generateSportkaNumbers() {

        List<Integer> sportkaNumbers = IntStream.range(1, 6).mapToObj(i -> RandomUtils.generateRandomNumber(1, 49)).collect(Collectors.toList());
        return sportkaNumbers.stream().map(number -> number.toString()).collect(Collectors.joining(", "));
    }
}
