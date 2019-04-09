package cz.speedygonzales.threshold;

import java.util.TimerTask;

public class Worker extends TimerTask {

    private int delay;

    Worker(int delay) {
        this.delay = delay;
    }

    @Override
    public void run() {
        System.out.println(String.format("I am sending email after %d ms", delay));
    }
}
