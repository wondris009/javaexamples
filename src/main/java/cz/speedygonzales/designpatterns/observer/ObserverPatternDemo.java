package cz.speedygonzales.designpatterns.observer;

import java.util.stream.IntStream;

public class ObserverPatternDemo {

    public static void main(String[] args) {

        Monitor monitor = new Monitor();

        new HexObserver(monitor);
        new BinaryObserver(monitor);

        IntStream.iterate(0, i-> i + 5).limit(20).forEach(ranger -> {
            System.out.println("First state change: " + ranger);
            monitor.setState(ranger);
            System.out.println("");
        });
    }
}
