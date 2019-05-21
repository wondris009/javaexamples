package cz.speedygonzales.designpatterns.observer;

abstract class Observer {

    protected Subject subject;
    abstract void update();
}
