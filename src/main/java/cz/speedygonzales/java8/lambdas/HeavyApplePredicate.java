package cz.speedygonzales.java8.lambdas;

/**
 * @author vondracek
 * @since 12.7.2016 8:53
 */
public class HeavyApplePredicate implements ApplePredicate {

    @Override
    public boolean test(Apple apple) {

        return apple.getWeight() > 150;
    }
}
