package cz.speedygonzales.random;

import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    private RandomUtils() {
        throw new AssertionError("Do not create RandomUtils instance within this class");
    }

    /**
     * Generates integers between range.
     *
     * @param min - inclusive
     * @param max - exclusive
     * @return
     */
    public static int generateRandomNumber(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max);
    }
}
