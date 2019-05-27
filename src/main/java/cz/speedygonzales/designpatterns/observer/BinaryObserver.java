package cz.speedygonzales.designpatterns.observer;

class BinaryObserver extends Observer {

    BinaryObserver(Monitor monitor) {
        this.monitor = monitor;
        monitor.attach(this);
    }

    @Override
    void update() {
        System.out.println("Binary string " + Integer.toBinaryString(monitor.getState()));
    }
}
