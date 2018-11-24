package cz.speedygonzales.testing;


import java.util.ArrayList;
import java.util.List;

public class TestingClass {

    public static void main(String[] args) {


        List<Integer> myList = new ArrayList<>(6);
        myList.add(new Integer(1));
        myList.add(null);
        myList.add(new Integer(1));
        myList.add(null);
        myList.add(new Integer(1));
        myList.add(new Integer(1));

        int sum = 0;
        for (Integer integer : myList) {
            sum += integer;
        }
        System.out.println(sum);


    }
}

