package cz.speedygonzales.concurrency;

/**
 * Created by: vondracek - 24.2.15 18:49
 */
public class Worker extends Thread {

    public void run() {

        System.out.println("worker execution");
    }
}
