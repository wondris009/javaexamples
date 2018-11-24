package cz.speedygonzales.concurrency.threadsbaeldung;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimedWaitingState {
    public static void main(String[] args) throws InterruptedException {
        DemoThread obj1 = new DemoThread();
        Thread t1 = new Thread(obj1);
        t1.start();

        // The following sleep will give enough time for ThreadScheduler
        // to start processing of thread t1
        Thread.sleep(1000);
        log.info(t1.getState().toString());
    }
}

@Slf4j
class DemoThread implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.info("Thread interrupted");
        }
    }
}
