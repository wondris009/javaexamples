package cz.speedygonzales.designpatterns.servicelocator;

/**
 */
public class ServiceLocatorDemo {

    public static void main(String[] args) {

        Service s = ServiceLocator.getService("service1");
        s.execute();

        s = ServiceLocator.getService("service2");
        s.execute();

        s = ServiceLocator.getService("service1");
        s.execute();

        s = ServiceLocator.getService("service2");
        s.execute();
    }
}
