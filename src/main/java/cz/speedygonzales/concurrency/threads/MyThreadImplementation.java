package cz.speedygonzales.concurrency.threads;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by: vondracek - 25.2.14 13:46
 */
public class MyThreadImplementation extends Thread {

    public MyThreadImplementation(String name) {

        super(name);
    }

    public void run() {

        Date now = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss:SSS dd.MM.yyyy");
        String formatted = formatter.format(now);

        System.out.println("[" + formatted + "] Thread: " + this.getName());

        yield();
    }
//    public void run() {
//        for(int i = 0; i < 5; i++) {
//
//            Date now = new Date();
//
//            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss:SSS dd.MM.yyyy");
//
//            String formatted = formatter.format(now);
//
//
//            System.out.println("[" + formatted + "] Thread: " + this.getName());
//
//            try {
//                Thread.sleep(1000);
//            } catch(InterruptedException e) {
//                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
//            }
//
//            yield();
//        }
//    }
}
