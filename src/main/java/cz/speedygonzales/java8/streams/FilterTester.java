package cz.speedygonzales.java8.streams;

import cz.speedygonzales.utils.StringUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author vondracek
 * @since 28.6.2016 19:20
 */
public class FilterTester {

    private static final int INVENTORY_COUNT = 20_000_000;
    private static final StringUtils utils = StringUtils.getInstance();
    private final SimpleDateFormat sfd = new SimpleDateFormat("HH:mm:ss.SSS");

    public static void main(String[] args) {


        FilterTester filterTester = new FilterTester();
        filterTester.filterSequential();
        filterTester.filterParallel();


    }

    private void filterParallel() {

        utils.logMessage("parallel");

        List<Apple> inventory = createInventory();

        utils.logMessage("started: " + sfd.format(new Date()));

        List<Apple> halfSizeAppleList = inventory.parallelStream().filter((Apple a) -> a.getWeight() % 2 == 0).collect(toList());

        utils.logMessage(String.valueOf(halfSizeAppleList.size()));

        utils.logMessage("ended: " + sfd.format(new Date()));

    }

    private void filterSequential() {

        utils.logMessage("sequential");

        List<Apple> inventory = createInventory();

        utils.logMessage("started: " + sfd.format(new Date()));

        List<Apple> halfSizeAppleList = inventory.stream().filter((Apple a) -> a.getWeight() % 2 == 0).collect(toList());

        utils.logMessage(String.valueOf(halfSizeAppleList.size()));

        utils.logMessage("ended: " + sfd.format(new Date()));

    }

    private List<Apple> createInventory() {

        List<Apple> inventory = new ArrayList<>(INVENTORY_COUNT);

        for (int i = 0; i < INVENTORY_COUNT; i++) {

            inventory.add(new Apple(i));

        }

        return inventory;

    }

    class Apple {

        int weight = 0;

        public Apple(int weight) {

            this.weight = weight;
        }

        public int getWeight() {

            return weight;
        }
    }
}
