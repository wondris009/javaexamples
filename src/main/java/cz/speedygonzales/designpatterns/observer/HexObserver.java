package cz.speedygonzales.designpatterns.observer;

class HexObserver extends Observer {

    HexObserver(Monitor monitor) {
        this.monitor = monitor;
        monitor.attach(this);
    }

    @Override
    void update() {
        System.out.println("Hex string " + Integer.toHexString(monitor.getState()));
    }
}
