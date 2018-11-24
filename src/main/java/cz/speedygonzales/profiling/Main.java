package cz.speedygonzales.profiling;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class Main {

    static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 1000_000_000; i++) {


            list.add(new String("string_" + i));

        }


    }
}


