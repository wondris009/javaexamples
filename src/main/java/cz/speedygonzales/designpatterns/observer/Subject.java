package cz.speedygonzales.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

class Subject {

    private List<Observer> observers = new ArrayList<>();

    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyObservers();
    }

    void attach(Observer observer) {
        this.observers.add(observer);
    }

    private void notifyObservers() {
        observers.forEach(Observer::update);
    }
}
