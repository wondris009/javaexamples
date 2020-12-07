package cz.speedygonzales.concurrency.synchronised;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class SimplePojo {

    private int sum = 0;

    public void update() {
        synchronized (this) {
            setSum(getSum() + 1);
        }
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public static void main(String[] args) throws InterruptedException {

        ExecutorService service = Executors.newFixedThreadPool(3);
        SimplePojo summation = new SimplePojo();

        IntStream
                .range(0, 1000)
                .forEach(count -> service.submit(summation::update));

        service.shutdown();
        service.awaitTermination(1000, TimeUnit.MILLISECONDS);

        System.out.println(summation.getSum());
        System.out.println(1000 == summation.getSum());
        assert summation.getSum() == 1000;
    }
}
