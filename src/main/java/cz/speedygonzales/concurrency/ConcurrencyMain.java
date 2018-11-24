package cz.speedygonzales.concurrency;

import javax.xml.datatype.DatatypeConfigurationException;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA.
 * User: vondracek
 * Date: 11.7.13
 * Time: 8:36
 * To change this template use File | Settings | File Templates.
 */
public class ConcurrencyMain {


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, DatatypeConfigurationException, ParseException, ExecutionException, InterruptedException {

        ConcurrencyMain main = new ConcurrencyMain();
//        main.execution1();
//        main.execution2();
//        main.execution3();
        main.execution4();
//        main.execution5();

    }

    void execution1() {

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        executorService.execute(new Runnable() {
            @Override
            public void run() {

                System.out.println("executing!!");
            }
        });

        Thread worker = new Worker();
        executorService.execute(worker);

        executorService.shutdown();
    }

    void execution2() throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Future future = executorService.submit(new Runnable() {
            public void run() {

                System.out.println("Asynchronous task");
            }
        });

        Object o = future.get();
        System.out.println("future.get() = " + (o == null ? "Runnable ends successfully" : "Runnable doesnt end successfully"));

        executorService.shutdown();
    }

    void execution3() throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Future future = executorService.submit(new Callable() {
            public Object call() throws Exception {

                System.out.println("Asynchronous Callable");
                return "Callable Result";
            }
        });

        System.out.println("future.get() = " + future.get());

        executorService.shutdown();
    }

    void execution4() throws InterruptedException, ExecutionException {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Set<Callable<String>> callables = new HashSet<Callable<String>>();

        callables.add(new Callable<String>() {
            public String call() throws Exception {

                return "Task 1";
            }
        });
        callables.add(new Callable<String>() {
            public String call() throws Exception {

                return "Task 2";
            }
        });
        callables.add(new Callable<String>() {
            public String call() throws Exception {

                return "Task 3";
            }
        });

        String result = executorService.invokeAny(callables);

        System.out.println("result = " + result);

        executorService.shutdown();
    }

    void execution5() throws InterruptedException, ExecutionException {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Set<Callable<String>> callables = new HashSet<Callable<String>>();

        callables.add(new Callable<String>() {
            public String call() throws Exception {

                return "Task 1";
            }
        });
        callables.add(new Callable<String>() {
            public String call() throws Exception {

                return "Task 2";
            }
        });
        callables.add(new Callable<String>() {
            public String call() throws Exception {

                return "Task 3";
            }
        });

        List<Future<String>> futures = executorService.invokeAll(callables);

        for (Future<String> future : futures) {
            System.out.println("future.get = " + future.get());
        }

        executorService.shutdown();
    }


}
