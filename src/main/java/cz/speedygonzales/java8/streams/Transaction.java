package cz.speedygonzales.java8.streams;

/**
 * @author vondracek
 * @since 17.10.2016 17:42
 */
public class Transaction {

    private final Trader trader;

    private int year;

    private double value;

    public Transaction(Trader trader, int year, double value) {

        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    public Trader getTrader() {

        return trader;
    }

    public int getYear() {

        return year;
    }

    public double getValue() {

        return value;
    }

    @Override
    public String toString() {

        return "Transaction{" + "trader=" + trader + ", year=" + year + ", value=" + value + '}';
    }
}
