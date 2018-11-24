package cz.speedygonzales.java8.lambdas;

/**
 * @author vondracek
 * @since 12.7.2016 8:53
 */
public class GreenApplePredicate implements ApplePredicate {

    @Override
    public boolean test(Apple apple) {

        return apple.getColor().equals("green");


    }
}
