package cz.speedygonzales.java8.datetime;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Slf4j
public class DateTimeDemoJava8 {

    public static void main(String[] args) {

        DateTimeDemoJava8 demo = new DateTimeDemoJava8();
        demo.printNow();
        demo.printNowWithTimeZone("America/New_York");
        demo.printPredefinedDateAndTime(2016, 11, 20);
        demo.formatDateTime("dd.MM.yyyy HH:mm");
        demo.printUseful();
        demo.printSystemTimezone();
//        demo.parseDateFromString("11.11.2000");


    }

    private void printNow() {

        LocalDateTime now = LocalDateTime.now();
        log.info("Now in current timezone {}", now);
    }

    private void printNowWithTimeZone(String timeZone) {

        LocalDateTime now = LocalDateTime.now(ZoneId.of(timeZone));
        log.info("Now in {} {}", timeZone, now);
    }

    private void printPredefinedDateAndTime(int year, int month, int day) {

        LocalDate date = LocalDate.of(year, month, day);
        log.info("Date created by year {}, month {}, day {} is {}", year, month, day, date);
    }

    private void formatDateTime(String format) {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(format);
        LocalDateTime now = LocalDateTime.now();
        log.info("Formatted datetime by pattern '{}' {}", format, now.format(dateTimeFormatter));
    }

    private void printUseful() {

        logNewRow();
        log.info("-------- USEFUL ---------");

        LocalDateTime now = LocalDateTime.now();

        log.info("LocalDateTime.now().toLocalDate() .. {}", now.toLocalDate());
        log.info("LocalDateTime.now().getYear() .. {}", now.getYear());
        log.info("LocalDateTime.now().getDayOfMonth() .. {}", now.getDayOfMonth());
        log.info("LocalDateTime.now().getDayOfYear() .. {}", now.getDayOfYear());
    }

    private void printSystemTimezone() {

        log.info("System timezone is {}", ZoneId.systemDefault().toString());
    }

    private void parseDateFromString(String date) {

        log.info("Parsed datetime {} is {} ", date, LocalDate.parse(date));
    }

    private void logNewRow() {
        log.info("\n");
    }


}
