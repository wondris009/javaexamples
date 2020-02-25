package cz.speedygonzales.java8.completablefuture;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class CompletableFutureDemo {

    static ExecutorService executor = Executors.newFixedThreadPool(3, new ThreadFactory() {
        int count = 1;

        @Override
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "custom-executor-" + count++);
        }
    });

    public static void main(String[] args) throws Exception {

//        completedFutureExample();
//        returnAsyncExample();
//        thenApplyExample();
//        thenApplyAsyncExample();
//        thenApplyAsyncWithExecutorExample();
        thenAcceptAsyncExample();
    }

    private static void completedFutureExample() {

        CompletableFuture cf = CompletableFuture.completedFuture("message");

        assert cf.isDone();
        assert "message".equals(cf.getNow(null));
    }

    private static void returnAsyncExample() throws InterruptedException {

        CompletableFuture cf = CompletableFuture.runAsync(() -> {
            assert Thread.currentThread().isDaemon();
            try {
                randomSleep();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        assert !cf.isDone();
        sleepEnough();
        assert cf.isDone();
    }


    private static void thenApplyExample() {
        CompletableFuture cf = CompletableFuture.completedFuture("message").thenApply(s -> {
            assert !Thread.currentThread().isDaemon();
            return s.toUpperCase();
        });
        assert "MESSAGE".equals(cf.getNow(null));
    }

    private static void thenApplyAsyncExample() {
        CompletableFuture cf = CompletableFuture.completedFuture("message").thenApplyAsync(s -> {
            assert Thread.currentThread().isDaemon();
            try {
                randomSleep();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return s.toUpperCase();
        });
        assert cf.getNow(null) == null;
        assert "MESSAGE".equals(cf.join());
    }

    private static void thenApplyAsyncWithExecutorExample() {
        CompletableFuture cf = CompletableFuture.completedFuture("message").thenApplyAsync(s -> {
            assert Thread.currentThread().getName().startsWith("custom-executor-");
            assert !Thread.currentThread().isDaemon();
            try {
                randomSleep();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return s.toUpperCase();
        }, executor);

        assert cf.getNow(null) == null;
        assert "MESSAGE".equals(cf.join());
    }

    private static void thenAcceptAsyncExample() {
        StringBuilder result = new StringBuilder();
        CompletableFuture cf = CompletableFuture.completedFuture("thenAcceptAsync message")
                .thenAcceptAsync(s -> result.append(s.toUpperCase()));
        cf.join();
        System.out.println(result.toString());
        assert result.length() > 0;
    }


    private static void randomSleep() throws InterruptedException {
        Random r = new Random();
        Thread.sleep(r.nextInt(100));

    }

    private static void sleepEnough() throws InterruptedException {
        Thread.sleep(2000);
    }


}
