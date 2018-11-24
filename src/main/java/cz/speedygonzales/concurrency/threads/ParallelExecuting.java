package cz.speedygonzales.concurrency.threads;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author vondracek
 * @since 15.6.2016 15:36
 */
public class ParallelExecuting {


    public static void main(String[] args) throws InterruptedException {

        System.out.println("start app");

        File allDirectories = new File("c:/tmp/dir/");

        File[] directories = allDirectories.listFiles();

        ExecutorService threadPool = Executors.newFixedThreadPool(120);

        for (File inputDir : directories) {


            for (File inputFile : inputDir.listFiles()) {
                Runnable t = new MyThread(inputFile);
                threadPool.execute(t);
                //            try {
                ////                Thread.sleep(1000);
                //            } catch (InterruptedException ex) {
                ////                                    Logger.getLogger(MyClass.class.getName()).log(Level.SEVERE, null, ex);
                //            }
            }


        }
        threadPool.shutdown();

        threadPool.awaitTermination(0, TimeUnit.SECONDS);

        System.out.println("main is ending");

    }


    static class MyThread extends Thread {

        private File inputFile;

        public MyThread(File inputFile) {

            this.inputFile = inputFile;
        }

        public void run() {

            System.out.println("i am thread " + this.getName() + " and i am processing file " + inputFile.getAbsolutePath());

//            try {
//
//
////                long initialTime = System.currentTimeMillis();
////
////                long five = 5 * 1000;
////
////                long changing = 0;
////                while (changing < initialTime) {
////                    changing = System.currentTimeMillis() - (System.currentTimeMillis() - five);
////
////                    System.out.println(System.currentTimeMillis());
////                }
//
//
//
////                Thread.sleep(500);
//            } catch (InterruptedException e) {
//            }

            System.out.println(getName() + " ended");
//
        }


    }


}
