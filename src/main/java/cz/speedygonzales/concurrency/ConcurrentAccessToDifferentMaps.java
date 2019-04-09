package cz.speedygonzales.concurrency;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConcurrentAccessToDifferentMaps {


    private final static int THREAD_POOL_SIZE = 5;

    private static Map<String, Integer> crunchifyHashTableObject = null;
    private static Map<String, Integer> crunchifySynchronizedMapObject = null;
    private static Map<String, Integer> crunchifyConcurrentHashMapObject = null;

    public static void main(String[] args) throws InterruptedException {

        // Test with Hashtable Object
        crunchifyHashTableObject = new Hashtable<>();
        crunchifyPerformTest(crunchifyHashTableObject);

        // Test with synchronizedMap Object
        crunchifySynchronizedMapObject = Collections.synchronizedMap(new HashMap<>());
        crunchifyPerformTest(crunchifySynchronizedMapObject);

        // Test with ConcurrentHashMap Object
        crunchifyConcurrentHashMapObject = new ConcurrentHashMap<>();
        crunchifyPerformTest(crunchifyConcurrentHashMapObject);
    }

    private static void crunchifyPerformTest(final Map<String, Integer> crunchifyThreads) throws InterruptedException {

        System.out.println("Test started for: " + crunchifyThreads.getClass());
        long averageTime = 0;
        for (int i = 0; i < 5; i++) {

            long startTime = System.nanoTime();
            ExecutorService crunchifyExServer = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

            for (int j = 0; j < THREAD_POOL_SIZE; j++) {
                crunchifyExServer.execute(new Runnable() {
                    @SuppressWarnings("unused")
                    @Override
                    public void run() {

                        for (int i = 0; i < 500000; i++) {
                            Integer crunchifyRandomNumber = (int) Math.ceil(Math.random() * 550000);

                            // Put value
                            crunchifyThreads.put(String.valueOf(crunchifyRandomNumber), crunchifyRandomNumber);

                            // Retrieve value. We are not using it anywhere
                            crunchifyThreads.get(String.valueOf(crunchifyRandomNumber));
                        }
                    }
                });
            }

            // Initiates an orderly shutdown in which previously submitted tasks are executed, but no new tasks will be accepted. Invocation
            // has no additional effect if already shut down.
            // This method does not wait for previously submitted tasks to complete execution. Use awaitTermination to do that.
            crunchifyExServer.shutdown();

            // Blocks until all tasks have completed execution after a shutdown request, or the timeout occurs, or the current thread is
            // interrupted, whichever happens first.
            crunchifyExServer.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);

            long entTime = System.nanoTime();
            long totalTime = (entTime - startTime) / 1000000L;
            averageTime += totalTime;
            System.out.println("500K entried added/retrieved in " + totalTime + " ms");
        }
        System.out.println("For " + crunchifyThreads.getClass() + " the average time is " + averageTime / 5 + " ms\n");
    }
}