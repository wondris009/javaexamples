package cz.speedygonzales.iterator;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FailFastIteratorExample {

    public static void main(String[] args) {

        Map<String, String> testedMap = new HashMap<>();
        testedMap.put("Samsung", "S5");
        testedMap.put("Huawei", "P7");
        testedMap.put("Nokia", "3310");

        Iterator<String> iterator = testedMap.keySet().iterator();
        while (iterator.hasNext()) {

            System.out.println(testedMap.get(iterator.next()));
            testedMap.put("Apple", "S7");
        }
    }
}
