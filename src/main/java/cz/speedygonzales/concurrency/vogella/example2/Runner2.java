package cz.speedygonzales.concurrency.vogella.example2;

import cz.speedygonzales.concurrency.vogella.MyRunnable;

import javax.xml.datatype.DatatypeConfigurationException;
import java.io.IOException;
import java.text.ParseException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by: vondracek - 26.2.15 15:57
 */
public class Runner2 {

    private static final int NUMBER_OF_THREADS = 10;

    public static void main(String[] args) throws IOException, DatatypeConfigurationException, ParseException, ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

        for (int i = 0; i < 500; i++) {
            Runnable myThread = new MyRunnable(1000L + i);
            executorService.execute(myThread);
        }

        executorService.shutdown();

        executorService.awaitTermination(0, TimeUnit.SECONDS);

        System.out.println("All threads are finished");
    }
}
