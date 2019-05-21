package cz.speedygonzales.designpatterns.observer;

import java.util.stream.IntStream;

public class ObserverPatternDemo {

    public static void main(String[] args) {

        Subject subject = new Subject();

        new HexObserver(subject);
        new BinaryObserver(subject);

        IntStream.iterate(0, i-> i + 5).limit(20).forEach(ranger -> {
            System.out.println("First state change: " + ranger);
            subject.setState(ranger);
            System.out.println("");
        });
    }
}
