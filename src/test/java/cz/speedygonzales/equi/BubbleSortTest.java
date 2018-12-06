package cz.speedygonzales.equi;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Random;

/**

 *
 * @author vondracek
 * @since 20.4.15 16:38
 */
public class BubbleSortTest {

    private static final Logger LOG = LoggerFactory.getLogger(MergeSortTest.class);

    private int[] numbers;
    private int[] numbers_big;
    private final static int SIZE = 7;
    private final static int SIZE_BIG = 100000;
    private final static int MAX = 20;
    private final static int MAX_BIG = 20000;

    @Before
    public void setUp() throws Exception {
        numbers = new int[SIZE];
        Random generator = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = generator.nextInt(MAX);
        }

        numbers_big = new int[SIZE_BIG];
        for (int i = 0; i < numbers_big.length; i++) {
            numbers_big[i] = generator.nextInt(MAX_BIG);
        }
    }

    @Test
    public void testBubbleSort() {
        long startTime = System.currentTimeMillis();

        LOG.info("initial:" + Arrays.toString(numbers));

        BubbleSort sorter = new BubbleSort();
        sorter.bubbleSort(numbers);

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Bubblesort " + elapsedTime + "ms");

        LOG.info(Arrays.toString(numbers));
    }


    @Test
    public void testBubbleSortBig() {
        long startTime = System.currentTimeMillis();

//        LOG.info("initial:" + Arrays.toString(numbers_big));

        BubbleSort sorter = new BubbleSort();
        sorter.bubbleSort(numbers_big);

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Bubblesort " + elapsedTime + "ms");

        LOG.info(Arrays.toString(numbers_big));
    }
}
