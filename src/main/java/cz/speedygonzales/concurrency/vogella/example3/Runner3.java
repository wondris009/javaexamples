package cz.speedygonzales.concurrency.vogella.example3;

import cz.speedygonzales.concurrency.vogella.MyCallable2;

import javax.xml.datatype.DatatypeConfigurationException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by: vondracek - 26.2.15 15:57
 */
public class Runner3 {

    private static final int NUMBER_OF_THREADS = 10;

    public static void main(String[] args) throws IOException, DatatypeConfigurationException, ParseException, ExecutionException, InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        List<Future<Long>> list = new ArrayList<Future<Long>>();
        for (int i = 0; i < 100; i++) {
            Callable<Long> worker = new MyCallable2();
            Future<Long> submit = executor.submit(worker);
            list.add(submit);
        }
        long sum = 0;
        System.out.println(list.size());
        // now retrieve the result
        for (Future<Long> future : list) {
            try {
                sum += future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println(sum);
        executor.shutdown();
    }
}
