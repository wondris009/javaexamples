package cz.speedygonzales.java8.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author vondracek
 * @since 17.10.2016 17:42
 */
public class Java8_Section_5_5_Practice {

    Trader raoul = new Trader("Raoul", "Cambridge");
    Trader mario = new Trader("Mario", "Milan");
    Trader alan = new Trader("Alan", "Cambridge");
    Trader brian = new Trader("Brian", "Cambridge");
    List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
    );

    public static void main(String[] args) {

        Java8_Section_5_5_Practice tester = new Java8_Section_5_5_Practice();
//        tester.task1();
//        tester.task2();
//        tester.task3();
//        tester.task4();
//        tester.task4_alternative();
//        tester.task5();
//        tester.task6();
//        tester.task7();
//        tester.task8();
        tester.task8_alternative();
    }


    /**
     * Find all transactions in the year 2011 and sort them by value (small to high).
     */
    public void task1() {

        transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .forEach((t) -> System.out.println(t.toString()));
    }

    /**
     * What are all the unique cities where the traders work?
     */
    public void task2() {

        transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .forEach(t -> System.out.println(t.toString()));
    }

    /**
     * Find all traders from Cambridge and sort them by name.
     */
    public void task3() {

        transactions.stream()
                .map(t -> t.getTrader())
                .distinct()
                .filter(tr -> tr.getCity().equalsIgnoreCase("cambridge"))
                .sorted(Comparator.comparing(Trader::getName))
                .forEach(t -> System.out.println(t.toString()));
    }


    /**
     * Return a string of all traders’ names sorted alphabetically.
     */
    public void task4() {

        transactions.stream()
                .map(t -> t.getTrader())
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .forEach(tr -> System.out.print(tr.getName()));
    }

    public void task4_alternative() {

        String traderStr =
                transactions.stream()
                        .map(transaction -> transaction.getTrader().getName())
                        .distinct()
                        .sorted()
                        .reduce("", (n1, n2) -> n1 + n2);
        System.out.println(traderStr);

    }

    /**
     * Are any traders based in Milan?
     */
    public void task5() {

        boolean milan = transactions.stream().map(trans -> trans.getTrader()).anyMatch(tr -> tr.getCity().equalsIgnoreCase("milan"));
        System.out.println(milan);
    }

    /**
     * Print all transactions’ values from the traders living in Cambridge.
     */
    public void task6() {

        List<Double> cambridge = transactions.stream().filter(tr -> tr.getTrader().getCity().equalsIgnoreCase("cambridge")).map(Transaction::getValue).collect(Collectors.toList());
        cambridge.stream().forEach(System.out::println);
    }

    /**
     * What’s the highest value of all the transactions?
     */
    public void task7() {

        Optional<Double> reduce = transactions.stream().map(Transaction::getValue).reduce(Double::max);
        System.out.println(reduce.get());
    }


    /**
     * Find the transaction with the smallest value
     */
    public void task8() {

        Optional<Transaction> reduce = transactions.stream().reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2);
        System.out.println(reduce.get().getValue());
    }


    public void task8_alternative() {

        Optional<Transaction> min = transactions.stream().min(Comparator.comparing(Transaction::getValue));
        System.out.println(min.get().getValue());
    }
}
