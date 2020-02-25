package cz.speedygonzales.effectivejava.item81;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

//NECHAPU JAK FUNGUJE
public class Item81 {

    public static void main(String[] args) throws InterruptedException {

        Runnable r = new Thread(() -> System.out.println("hi"));

        Executor e = Executors.newFixedThreadPool(100);

        time(e, 5, r);

    }

    public static long time(Executor executor, int concurrency, Runnable action) throws InterruptedException {

        CountDownLatch ready = new CountDownLatch(concurrency);
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch done = new CountDownLatch(concurrency);

        for (int i = 0; i < concurrency; i++) {
            executor.execute(() -> {
                ready.countDown(); // Tell timer we're ready
                try {
                    start.await(); // Wait till peers are ready
                    action.run();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    done.countDown(); // Tell timer we're done
                }
            });
        }
        ready.await(); // Wait for all workers to be ready
        long startNanos = System.nanoTime();
        start.countDown(); // And they're off!
        done.await(); // Wait for all workers to finish
        return System.nanoTime() - startNanos;
    }

}
