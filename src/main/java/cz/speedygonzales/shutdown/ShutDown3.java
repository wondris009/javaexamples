package cz.speedygonzales.shutdown;

public class ShutDown3 {

    public static boolean running = true;

    public static void main(String[] args) {

        System.out.println("+++ JavaStopTest started +++");

        Runtime.getRuntime().addShutdownHook(new MyShutdownHook());

        int i = 0;
        while (running) {
            System.out.println("count=" + i);
            i++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i == 100) {
// emergency exit
                running = false;
            }
        }

        System.out.println("--- JavaStopTest ended ---");
    }

}

class MyShutdownHook extends Thread {

    @Override
    public void run() {
        System.out.println("=== my shutdown hook activated");

// stop running threads
// store data to DB
// close connection to DB
// disconnect...
// release other resources...

        ShutDown3.running = false;

    }

}