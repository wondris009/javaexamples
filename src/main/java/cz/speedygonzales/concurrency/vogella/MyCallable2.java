package cz.speedygonzales.concurrency.vogella;

import java.util.concurrent.Callable;

/**
 * Created by: vondracek - 27.2.15 10:08
 */
public class MyCallable2 implements Callable<Long> {

    @Override
    public Long call() throws Exception {

        long sum = 0;
        int counter = 10;
        for (int i = 0; i < counter; i++) {
            sum += i;
        }

        System.out.println(counter + "x scitam, sum = " + sum);

        return sum;

    }
}
