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

    private static final int NUMBER_OF_ROWS = 100;

    public static void main(String[] args) {
        for (int j = 0; j < NUMBER_OF_ROWS; j++) {
            System.out.println(generateSportkaNumbers());
        }
    }

    private static String generateSportkaNumbers() {
        List<Integer> sportkaNumbers = IntStream.range(1, 6).mapToObj(i -> RandomUtils.generateRandomNumber(1, 50)).collect(Collectors.toList());
        return sportkaNumbers.stream().map(Object::toString).collect(Collectors.joining(", "));
    }
}
