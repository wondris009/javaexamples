package cz.speedygonzales.java8.datetime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateTimeDemoJava8 {

    private static final Logger LOG = LoggerFactory.getLogger(DateTimeDemoJava8.class);

    public static void main(String[] args) {

        DateTimeDemoJava8 demo = new DateTimeDemoJava8();
        demo.printNow();
        demo.printNowWithTimeZone("America/New_York");
        demo.printPredefinedDateAndTime(2016, 11, 20);
        demo.formatDateTime("dd.MM.yyyy HH:mm");
        demo.printUseful();
        demo.printSystemTimezone();
        demo.parseDateFromString("11.11.2000");


    }

    private void printNow() {

        LocalDateTime now = LocalDateTime.now();
        LOG.info("Now in current timezone {}", now);
    }

    private void printNowWithTimeZone(String timeZone) {

        LocalDateTime now = LocalDateTime.now(ZoneId.of(timeZone));
        LOG.info("Now in {} {}", timeZone, now);
    }

    private void printPredefinedDateAndTime(int year, int month, int day) {

        LocalDate date = LocalDate.of(year, month, day);
        LOG.info("Date created by year {}, month {}, day {} is {}", year, month, day, date);
    }

    private void formatDateTime(String format) {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(format);
        LocalDateTime now = LocalDateTime.now();
        LOG.info("Formatted datetime by pattern '{}' {}", format, now.format(dateTimeFormatter));
    }

    private void printUseful() {

        logNewRow();
        LOG.info("-------- USEFUL ---------");

        LocalDateTime now = LocalDateTime.now();

        LOG.info("LocalDateTime.now().toLocalDate() .. {}", now.toLocalDate());
        LOG.info("LocalDateTime.now().getYear() .. {}", now.getYear());
        LOG.info("LocalDateTime.now().getDayOfMonth() .. {}", now.getDayOfMonth());
        LOG.info("LocalDateTime.now().getDayOfYear() .. {}", now.getDayOfYear());
    }

    private void printSystemTimezone() {

        LOG.info("System timezone is {}", ZoneId.systemDefault().toString());
    }

    private void parseDateFromString(String date) {

        LOG.info("Parsed datetime {} is {} ", date, LocalDate.parse(date));
    }

    private void logNewRow() {
        LOG.info("\n");
    }


}
