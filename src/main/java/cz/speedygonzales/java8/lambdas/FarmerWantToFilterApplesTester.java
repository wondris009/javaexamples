package cz.speedygonzales.java8.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This example shows evolution how to create behaviour parameterizing methods.
 *
 * @author vondracek
 * @since 12.7.2016 8:34
 */
public class FarmerWantToFilterApplesTester {


    public static void main(String[] args) {

        List<Apple> appleList = Arrays.asList(new Apple("green", 80), new Apple("red", 150), new Apple("yellow", 120));

        FarmerWantToFilterApplesTester tester = new FarmerWantToFilterApplesTester();


        //this is usage with anonymous class
        tester.filterApples(appleList, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {

                return apple.getWeight() > 150;
            }
        });


    }

    /**
     * STEP 4 - Next time farmer wants to combine to filter by multiple attributes. Here only two, so there is flat to determine which one to use for filtering.
     * But if if there will be more attributes to filter then the code will not follow DRY principle.
     * <p>
     * SO NEVER DO THIS!!!!!
     *
     * @param inventory
     * @param color
     * @param weight
     * @param flag
     * @return
     */
    private static List<Apple> filterApples(List<Apple> inventory, String color, int weight, boolean flag) {

        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if ((flag && apple.getColor().equals(color)) || (!flag && apple.getWeight() > weight)) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * STEP 1 - requirement is to filter green apples.
     *
     * @param apples
     * @return
     */
    private List<Apple> filterGreenApples(List<Apple> apples) {

        List<Apple> greenApples = new ArrayList<>();

        for (Apple apple : apples) {

            if (apple.getColor().equals("green")) {
                greenApples.add(apple);
            }
        }

        return greenApples;
    }

    /**
     * STEP 2 - Later on farmer wants also to filter by red color after that by yellow color. Good approach is to create paramter of color.
     *
     * @param apples
     * @param color
     * @return
     */
    private List<Apple> filterApplesByColor(List<Apple> apples, String color) {

        List<Apple> coloredApples = new ArrayList<>();

        for (Apple apple : apples) {

            if (apple.getColor().equals(color)) {
                coloredApples.add(apple);
            }
        }

        return coloredApples;
    }

    /**
     * STEP 3 - Next time farmer want to distinguish between light and heavy apples.
     *
     * @param apples
     * @param weight
     * @return
     */
    private List<Apple> filterApplesByWeight(List<Apple> apples, int weight) {

        List<Apple> heavyApples = new ArrayList<>();

        for (Apple apple : apples) {

            if (apple.getWeight() > weight) {
                heavyApples.add(apple);
            }
        }

        return heavyApples;
    }

    /**
     * STEP 5 - For the changing filtering we can do more abstraction. We are always testing some apples filtering conditions. It is always something
     * which evaluates apple attributes as TRUE / FALSE. We can use predicates (function which returns boolean).
     */
    private List<Apple> filterApples(List<Apple> apples, ApplePredicate p) {

        List<Apple> result = new ArrayList<>();

        for (Apple apple : apples) {
            if (p.test(apple)) {

                result.add(apple);
            }
        }

        return result;
    }

    /**
     * STEP 6 - Functionality is in predicate like in step 5 and it uses anonymous creation of ApplePredicate interface.
     *
     * @param apples
     * @return
     */
    private List<Apple> filterApplesUsingPredicateAndAnonymousClass(List<Apple> apples) {

        return filterApples(apples, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {

                return apple.getWeight() > 150;
            }
        });
    }


    /**
     * STEP 7 - Using lambdas.
     *
     * @param inventory
     * @return
     */
    private List<Apple> filterApplesUsingLambda(List<Apple> inventory) {

        return filterApples(inventory, (Apple a) -> a.getColor().equals("red"));
    }
}
