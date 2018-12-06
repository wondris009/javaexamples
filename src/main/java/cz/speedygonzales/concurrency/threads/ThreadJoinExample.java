package cz.speedygonzales.concurrency.threads;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by: vondracek - 25.2.14 13:49
 */
@Slf4j
public class ThreadJoinExample {

    public static class MyRunnable extends Thread {

        private ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> (int) (Math.random() * 100d));

        @Override
        public void run() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }

            System.out.println(threadLocal.get());
        }
    }


    public static void main(String[] args) throws InterruptedException {
        MyRunnable sharedRunnableInstance = new MyRunnable();

        Thread thread1 = new Thread(sharedRunnableInstance,"t1");
        Thread thread2 = new Thread(sharedRunnableInstance, "t2");

        thread1.start();
        thread2.start();

        thread1.join(); //wait for thread 1 to terminate
        thread2.join(); //wait for thread 2 to terminate
    }


}
