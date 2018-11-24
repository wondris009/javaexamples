package cz.speedygonzales.concurrency.threadsbaeldung;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TerminatedState implements Runnable {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new TerminatedState());
        t1.start();
        // The following sleep method will give enough time for
        // thread t1 to complete
        Thread.sleep(1000);
        log.info(t1.getState().toString());
    }

    @Override
    public void run() {
        // No processing in this block
    }
}