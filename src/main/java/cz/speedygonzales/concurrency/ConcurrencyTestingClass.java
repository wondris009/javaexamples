package cz.speedygonzales.concurrency;

import static cz.speedygonzales.utils.TimeUtils.printActualTime;

public class ConcurrencyTestingClass {


    public static void main(String[] args) throws InterruptedException {


        System.out.println("starting");

        printActualTime();

        Thread t1 = new ThreadJoining();
        Thread t2 = new ThreadJoining();
        Thread t3 = new ThreadJoining();

        // thread t1 starts
        t1.start();

        // starts second thread after when
        // first thread t1 has died.
        try {
            System.out.println("x Thread: "
                    + Thread.currentThread().getName());
            t1.join();
        } catch (Exception ex) {
            System.out.println("Exception has " +
                    "been caught" + ex);
        }

        // t2 starts
        t2.start();

        // starts t3 after when thread t2 has died.
        try {
            System.out.println("x Thread: "
                    + Thread.currentThread().getName());
            t2.join();
        } catch (Exception ex) {
            System.out.println("Exception has been" +
                    " caught" + ex);
        }

        t3.start();

        printActualTime();


    }

    static class ThreadJoining extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 2; i++) {
                try {
                    Thread.sleep(500);
                    System.out.println("Current Thread: "
                            + this.getName());
                } catch (Exception ex) {
                    System.out.println("Exception has" +
                            " been caught" + ex);
                }
                System.out.println(i);
            }
        }
    }


}
