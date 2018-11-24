package cz.speedygonzales.concurrency.threads;

import java.time.LocalDate;
import java.time.chrono.IsoChronology;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.ResolverStyle;
import java.time.temporal.ChronoField;

public class ThreadTesting {

    public static void main(String[] args) throws InterruptedException {

        DateTimeFormatter FORMAT = new DateTimeFormatterBuilder()
                .appendPattern("dd.MM.yyyy")
                .parseDefaulting(ChronoField.ERA, 1 /* era is AD */)
                .toFormatter()
                .withChronology(IsoChronology.INSTANCE)
                .withResolverStyle(ResolverStyle.STRICT);

        LocalDate parse = LocalDate
                .parse("33.02.2015",
                        FORMAT);

        System.out.println(parse);


    }
}


