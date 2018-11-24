package cz.speedygonzales.generics;

/**
 * @author vondracek
 * @since 28.9.2016 10:13
 */
public class Box2<T> {

    private T t;

    public static void main(String[] args) {

        Box2<Integer> integerBox = new Box2<>();

        integerBox.setT(2);
        integerBox.inspect(235);
    }

    public void setT(T t) {

        this.t = t;
    }

    public <U extends Number> void inspect(U u) {

        System.out.println("T:" + t.getClass().getName());
        System.out.println("U:" + u.getClass().getName());
    }
}
