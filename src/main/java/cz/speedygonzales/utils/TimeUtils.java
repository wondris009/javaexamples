package cz.speedygonzales.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeUtils {

    private TimeUtils() {
        throw new AssertionError("Do not instantiate this class");
    }

    public static String getActualTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss.SSS"));
    }

    public static void printActualTime() {
        System.out.println(getActualTime());
    }
}
