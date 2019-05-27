package cz.speedygonzales.designpatterns.observer;

abstract class Observer {

    protected Monitor monitor;
    abstract void update();
}
