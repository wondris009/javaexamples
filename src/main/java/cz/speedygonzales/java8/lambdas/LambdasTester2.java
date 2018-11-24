package cz.speedygonzales.java8.lambdas;

/**
 * @author vondracek
 * @since 28.6.2016 18:38
 */
public class LambdasTester2 {

    public static void main(String[] args) {

        new Thread(() -> System.out.println("hi")).start();


    }


}
