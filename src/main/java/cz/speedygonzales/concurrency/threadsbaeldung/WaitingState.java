package cz.speedygonzales.concurrency.threadsbaeldung;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WaitingState implements Runnable {

    private static final Logger Log = LoggerFactory.getLogger(WaitingState.class);

    public static Thread t1;

    public static void main(String[] args) {
        t1 = new Thread(new WaitingState());
        t1.start();
    }

    public void run() {
        Thread t2 = new Thread(new DemoThreadWS());
        t2.start();

        try {
            t2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            Log.error("Thread interrupted", e);
        }
    }
}

class DemoThreadWS implements Runnable {

    private static final Logger Log = LoggerFactory.getLogger(DemoThreadWS.class);

    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            Log.error("Thread interrupted", e);
        }

        Log.info(WaitingState.t1.getState().toString());
    }
}
