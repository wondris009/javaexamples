package cz.speedygonzales.random;

import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    private RandomUtils() {
    }

    public static int generateRandomNumber(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max);
    }
}
