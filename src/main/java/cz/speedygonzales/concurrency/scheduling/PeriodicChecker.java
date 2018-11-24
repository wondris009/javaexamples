package cz.speedygonzales.concurrency.scheduling;

import java.io.File;
import java.util.concurrent.Callable;

/**
 * Created by: vondracek - 27.2.15 10:21
 */
public class PeriodicChecker implements Callable<Boolean> {

    @Override
    public Boolean call() throws Exception {

        File file = new File("c:\\workk\\DMA\\workingDirectory\\data\\IBW\\OA1\\in\\in.txt");
        return file.exists();

    }
}
