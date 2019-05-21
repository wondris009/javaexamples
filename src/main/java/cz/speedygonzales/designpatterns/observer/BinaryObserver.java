package cz.speedygonzales.designpatterns.observer;

class BinaryObserver extends Observer {

    BinaryObserver(Subject subject) {
        this.subject = subject;
        subject.attach(this);
    }

    @Override
    void update() {
        System.out.println("Binary string " + Integer.toBinaryString(subject.getState()));
    }
}
