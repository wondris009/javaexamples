package cz.speedygonzales.concurrency.scheduling;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by: vondracek - 27.2.15 10:20
 */
public class TelephonyApp {

    private static final int NUMBER_OF_THREADS = 1;

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        List<Record> records = new ArrayList<Record>();
        records.add(new Record());
        records.add(new Record());
        records.add(new Record());

        ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

        Callable<Boolean> periodicChecker = new PeriodicChecker();

        boolean outputMissing = true;
        do {

            Future<Boolean> submit = executorService.submit(periodicChecker);
            Boolean outputExists = submit.get();

            Processor processor = new Processor(records);
            records = processor.doProcess();

            System.out.println("Cekam na dalsi kolecko");
            Thread.sleep(1000);

            outputMissing = (records.size() == 0);

        } while (!outputMissing);

        executorService.shutdown();
    }
}
