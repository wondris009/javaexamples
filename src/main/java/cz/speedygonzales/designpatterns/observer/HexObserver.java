package cz.speedygonzales.designpatterns.observer;

class HexObserver extends Observer {

    HexObserver(Subject subject) {
        this.subject = subject;
        subject.attach(this);
    }

    @Override
    void update() {
        System.out.println("Hex string " + Integer.toHexString(subject.getState()));
    }
}
