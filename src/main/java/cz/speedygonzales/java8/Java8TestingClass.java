package cz.speedygonzales.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author vondracek
 * @since 14.6.2016 9:55
 */
public class Java8TestingClass {

    static List<String> names = Arrays.asList("honza", "pepa", "lojza");

    public static void main(String[] args) {

        oldStyle();
        System.out.println("------------");

        newStyle1();
        System.out.println("------------");

        newStyle2();
        System.out.println("------------");

        newStyle3();
        System.out.println("------------");
    }

    private static void oldStyle() {

        Collections.sort(names, new Comparator<String>() {
            public int compare(String o1, String o2) {

                return o2.compareTo(o1);
            }
        });

        for (String name : names) {
            System.out.println(name);
        }
    }

    private static void newStyle1() {

        Collections.sort(names, (String a, String b) -> {
            return b.compareTo(a);
        });

        for (String name : names) {
            System.out.println(name);
        }
    }

    private static void newStyle2() {

        Collections.sort(names, (String a, String b) -> b.compareTo(a));

        for (String name : names) {
            System.out.println(name);
        }
    }

    private static void newStyle3() {

        Collections.sort(names, (a, b) -> b.compareTo(a));

        for (String name : names) {
            System.out.println(name);
        }
    }
}
