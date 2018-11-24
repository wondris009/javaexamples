package cz.speedygonzales.iterator;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class FailSafeIteratorExample {

    public static void main(String[] args) {

        ConcurrentHashMap<String, String> testedMap = new ConcurrentHashMap<>();
        testedMap.put("Samsung", "S5");
        testedMap.put("Huawei", "P7");
        testedMap.put("Nokia", "3310");

        System.out.println("pocet elementu pred vytvorenim FailSafe iteratoru = " + testedMap.size());

        Iterator<String> iterator = testedMap.keySet().iterator();
        while (iterator.hasNext()) {

            System.out.println(testedMap.get(iterator.next()));
            testedMap.put("Apple", "S7");
        }

        System.out.println("pocet elementu po vytvorenim FailSafe iteratoru = " + testedMap.size());
    }
}
