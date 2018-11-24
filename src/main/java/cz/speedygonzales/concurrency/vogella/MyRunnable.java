package cz.speedygonzales.concurrency.vogella;

/**
 * Created by: vondracek - 26.2.15 15:55
 */
public class MyRunnable implements Runnable {

    private final long countUntil;

    public MyRunnable(long countUntil) {

        this.countUntil = countUntil;
    }

    public void run() {

        long sum = 0;
        for (int i = 0; i < this.countUntil; i++) {
            sum += i;
        }

        System.out.println("sum = " + sum);
    }


}
