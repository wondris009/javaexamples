package cz.speedygonzales.threshold;

import java.time.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class ThresholdDemo {


    private static final int THREAD_POOL_SIZE = 5;
    private static final long THRESHOLD_IN_SECONDS = 10;
    private static final long MAXIMUM_EMAILS = 20;

    static List<LocalDateTime> events = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {

        ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        for (int j = 0; j < 300; j++) {

            int rate = ThreadLocalRandom.current().nextInt(150, 200);
            threadPool.execute(new Worker(rate));
            events.add(LocalDateTime.now());
            checkThreshold();
            Thread.sleep(rate);
        }

        threadPool.shutdown();
        threadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);

        System.out.println("\n");

        events.stream().forEach(System.out::println);
    }

    private static void checkThreshold() {

        if (events.size() < 2) {
            return;
        }

        LocalDateTime firstEvent = events.get(0);
        LocalDateTime lastEvent = events.get(events.size() - 1);

        long seconds = Duration.between(firstEvent.toInstant(ZoneOffset.UTC), lastEvent.toInstant(ZoneOffset.UTC)).getSeconds();

        if ((
                (seconds > THRESHOLD_IN_SECONDS && events.size() > MAXIMUM_EMAILS))
                || (false)) {

            System.out.println(String.format("Too much emails %d sent in period %d", events.size(), THRESHOLD_IN_SECONDS));
            System.out.println("Sending info about that");
            System.exit(0);


        }

    }

}

