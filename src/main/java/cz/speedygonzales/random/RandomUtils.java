package cz.speedygonzales.random;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created with IntelliJ IDEA.
 * User: vondracek
 * Date: 10.9.13
 * Time: 9:24
 * To change this template use File | Settings | File Templates.
 */
public class RandomUtils {

    private RandomUtils() {
    }

    /**
     * If fromZero is set then it selects numbers from range 0 - highestNumber
     * <p>
     * otherwise
     * <p>
     * 1 - highestNumber+1
     * @return
     */
    public static int generateRandomNumber(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max);
    }
}
