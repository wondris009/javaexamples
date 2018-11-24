package cz.speedygonzales.generics;

/**
 * @author vondracek
 * @since 27.9.2016 0:28
 */
public class NumberBox<T extends Integer> {

    private T attribute;

    public T getAttribute() {

        return attribute;
    }

    public void setAttribute(T attribute) {

        this.attribute = attribute;
    }
}
