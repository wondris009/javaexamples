package cz.speedygonzales.generics;

/**
 * @author vondracek
 * @since 20.10.2015 21:00
 */
public class Box<T> {

    private T t;

    public T getT() {

        return t;
    }

    public void setT(T t) {

        this.t = t;
    }
}
