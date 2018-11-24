package cz.speedygonzales.java8.lambdas;

/**
 * @author vondracek
 * @since 12.7.2016 8:52
 */
@FunctionalInterface
public interface ApplePredicate {

    boolean test(Apple apple);
}
