package cz.speedygonzales.sportka;

import cz.speedygonzales.random.RandomUtils;

/**
 * Created with IntelliJ IDEA.
 * User: vondracek
 * Date: 10.9.13
 * Time: 9:24
 * To change this template use File | Settings | File Templates.
 */
public class SportkaGenerator {

    public static void main(String[] args) {

        RandomUtils ru = new RandomUtils();

        for (int j = 0; j < 10; j++) {
            generateSportkaNumbers(ru);
        }


    }

    private static void generateSportkaNumbers(RandomUtils ru) {
        for (int i = 1; i < 7; i++) {
            System.out.print(ru.generateRandomNumber(false, 48) + " ");
        }
        System.out.println("\n");
    }
}
