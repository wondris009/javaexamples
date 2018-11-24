package cz.speedygonzales.generics;

import java.util.Arrays;
import java.util.List;

public class FooTest {

    public static void main(String[] args) {

        List<Foo> foos = Arrays.asList(new Foo(), new Foo());
        List<FooChild> fooChildren = Arrays.asList(new FooChild(), new FooChild());

        process(foos);
        process(fooChildren);
    }

    static void process(List<? extends Foo> list) {

        for (Foo foo : list) {
            System.out.println(foo.toString());
        }
    }


    private static class Foo {
    }

    private static class FooChild extends Foo {
    }

}
