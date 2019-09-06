package cz.speedygonzales.random;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: vondracek
 * Date: 10.9.13
 * Time: 9:24
 * To change this template use File | Settings | File Templates.
 */
public class RandomUtils {

    /**
     * If fromZero is set then it selects numbers from range 0 - highestNumber
     * <p>
     * otherwise
     * <p>
     * 1 - highestNumber+1
     *
     * @param fromZero
     * @param highestNumber
     * @return
     */
    public int generateRandomNumber(boolean fromZero, int highestNumber) {

        Random r = new Random();

        return (fromZero ? r.nextInt(highestNumber) : (r.nextInt(highestNumber) + 1));
    }
}
