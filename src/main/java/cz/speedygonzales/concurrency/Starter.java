package cz.speedygonzales.concurrency;

/**
 * @author vondracek
 * @since 9.1.2017 12:07
 */
public class Starter extends Thread {
    private int x = 2;

    public static void main(String[] args) throws Exception {
        new Starter().makeItSo();
    }

    public Starter() {
        x = 5;
        start();
    }

    public void makeItSo() throws Exception {
        join();
        x = x - 1;
        System.out.println(x);
    }

    public void run() {
        x *= 2;
    }
}
