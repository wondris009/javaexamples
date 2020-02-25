package cz.speedygonzales.effectivejava.item79;

public interface SetObserver<E> {

    // Invoked when an element is added to the observable set
    void added(ObservableSet<E> set, E element);
}