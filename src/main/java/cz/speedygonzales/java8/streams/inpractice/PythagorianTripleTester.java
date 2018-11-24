package cz.speedygonzales.java8.streams.inpractice;

import java.util.stream.IntStream;

/**
 * @author vondracek
 * @since 24.10.2016 20:28
 */
public class PythagorianTripleTester {


    public static void main(String[] args) {


        IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a ->
                        IntStream.rangeClosed(a, 100)
                                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                                .mapToObj(b ->
                                        new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
                ).forEach(t -> System.out.println(t[0] + "," + t[1] + "," + t[2]));


    }


}
