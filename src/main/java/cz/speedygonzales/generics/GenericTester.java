package cz.speedygonzales.generics;

/**
 * @author vondracek
 * @since 27.9.2016 0:29
 */
public class GenericTester {

    public static void main(String[] args) {

        AnotherBox<Integer> anotherBox = new AnotherBox<>();

        anotherBox.setAttribute(3);

        System.out.println(anotherBox.getAttribute());

        NumberBox<Integer> numberBox = new NumberBox<>();


    }
}
