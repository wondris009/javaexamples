package cz.speedygonzales.concurrency.scheduling;

import java.io.File;
import java.util.concurrent.*;

/**
 * Created by: vondracek - 26.2.15 9:30
 */
public class AlarmClock {

    /**
     * If invocations might overlap, you can specify more than a single thread.
     */
    private static final int NUM_THREADS = 1;
    private static final boolean DONT_INTERRUPT_IF_RUNNING = false;

    // PRIVATE
    private final ScheduledExecutorService scheduler;
    private final long initialDelay;
    private final long delayBetweenRuns;
    private final long shutdownAfter;

    AlarmClock(long aInitialDelay, long aDelayBetweenBeeps, long aStopAfter) {

        initialDelay = aInitialDelay;
        delayBetweenRuns = aDelayBetweenBeeps;
        shutdownAfter = aStopAfter;

        scheduler = Executors.newScheduledThreadPool(NUM_THREADS);
    }

    /**
     * Run the example.
     */
    public static void main(String... aArgs) throws InterruptedException {

        log("Main started.");

        AlarmClock alarmClock = new AlarmClock(0, 1, 10);
        alarmClock.activateAlarmThenStop();

        /*
        To start the alarm at a specific date in the future, the initial delay
        needs to be calculated relative to the current time, as in :
        Date futureDate = ...
        long startTime = futureDate.getTime() - System.currentTimeMillis();
        AlarmClock alarm = new AlarmClock(startTime, 1, 20);
        This works only if the system clock isn't reset.
        */

        log("Main ended.");
    }

    private static void log(String aMsg) {

        System.out.println(aMsg);
    }

    /**
     * Sound the alarm for a few seconds, then stop.
     */
    void activateAlarmThenStop() {

        Runnable soundAlarmTask = new PeriodicCheckerTask(scheduler);                                // 0               1
        ScheduledFuture<?> soundAlarmFuture = scheduler.scheduleWithFixedDelay(soundAlarmTask, initialDelay, delayBetweenRuns, TimeUnit.SECONDS);
        Runnable stopAlarm = new StopCheckerTask(soundAlarmFuture);

        scheduler.schedule(stopAlarm, shutdownAfter, TimeUnit.SECONDS);
    }

    void activateAlarmThenStopWithCallable() {

        Runnable soundAlarmTask = new PeriodicCheckerTask(scheduler);                                // 0               1

        ScheduledFuture<Object> schedule = scheduler.schedule(new Callable<Object>() {
            @Override
            public Object call() throws Exception {

                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }
        }, 1, TimeUnit.SECONDS);


        ScheduledFuture<?> soundAlarmFuture = scheduler.scheduleWithFixedDelay(soundAlarmTask, initialDelay, delayBetweenRuns, TimeUnit.SECONDS);
        Runnable stopAlarm = new StopCheckerTask(soundAlarmFuture);

        scheduler.schedule(stopAlarm, shutdownAfter, TimeUnit.SECONDS);
    }

    private static final class PeriodicCheckerTask implements Runnable {

        private int fCount;

        private ScheduledExecutorService scheduler;

        public PeriodicCheckerTask(ScheduledExecutorService scheduler) {

            this.scheduler = scheduler;
        }

        @Override
        public void run() {

            StringBuilder sb = new StringBuilder();
            sb.append("running thread - ");

            boolean existsOutput = checkOutput();
            if (!existsOutput) {
                sb.append("checking output");
            } else {
                sb.append("processing");
                doProcess();
                stopCounting();
            }
            ++fCount;

            log(sb.toString());
        }

        private boolean checkOutput() {

            File file = new File("c:\\workk\\DMA\\workingDirectory\\data\\IBW\\OA1\\in\\in.txt");
            return file.exists();
        }

        private void doProcess() {

        }

        private void stopCounting() {

            scheduler.shutdown();
        }
    }


    private static final class TestCallable implements Callable {

        @Override
        public Object call() throws Exception {

            return null;
        }
    }


    private static final class CallableSoundAlarmTask implements Callable {

        private int fCount;

        @Override
        public Object call() throws Exception {

            log("Calling");
            return null;  //To change body of implemented methods use File | Settings | File Templates.
        }
    }


    private final class StopCheckerTask implements Runnable {

        private ScheduledFuture<?> fSchedFuture;

        StopCheckerTask(ScheduledFuture<?> aSchedFuture) {

            fSchedFuture = aSchedFuture;
        }

        @Override
        public void run() {

            log("Stopping alarm.");
            fSchedFuture.cancel(DONT_INTERRUPT_IF_RUNNING);

              /*
               Note that this Task also performs cleanup, by asking the
               scheduler to shutdown gracefully.
              */

            scheduler.shutdown();
        }
    }
}