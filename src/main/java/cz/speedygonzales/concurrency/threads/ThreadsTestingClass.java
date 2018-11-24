package cz.speedygonzales.concurrency.threads;

/**
 * Created by: vondracek - 25.2.14 13:49
 */
public class ThreadsTestingClass {

    public static class MyRunnable implements Runnable {

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

        Thread thread1 = new Thread(sharedRunnableInstance);
        Thread thread2 = new Thread(sharedRunnableInstance);

        thread1.start();
        thread2.start();

        thread1.join(); //wait for thread 1 to terminate
        thread2.join(); //wait for thread 2 to terminate
    }


}
