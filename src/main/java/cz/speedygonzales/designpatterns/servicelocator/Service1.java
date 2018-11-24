package cz.speedygonzales.designpatterns.servicelocator;

/**
 */
public class Service1 implements Service {

    @Override
    public String getName() {
        return getClass().getSimpleName();
    }

    @Override
    public void execute() {
        System.out.println("executing logic: " + getClass().getSimpleName());
    }
}
