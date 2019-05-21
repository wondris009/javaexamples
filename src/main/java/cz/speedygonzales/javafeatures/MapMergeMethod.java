package cz.speedygonzales.javafeatures;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

import static cz.speedygonzales.javafeatures.MapMergeMethod.Category.C1;
import static cz.speedygonzales.javafeatures.MapMergeMethod.Category.C2;

@Slf4j
public class MapMergeMethod {

    public static void main(String[] args) {

        Map<Category, Integer> map = new HashMap<>();

        //pokud klic neni prida ho i s hodnotou, pokud je, pouzije na hodnotu funkci definovanou jako treti parametr
        map.merge(C1, 1, (v1, v2) -> v1 + v2);
        map.merge(C1, 1, (v1, v2) -> v1 + v2);
        map.merge(C2, 8, (v1, v2) -> v1 + v2);
        map.merge(C2, 8, (v1, v2) -> v1 + v2);
        map.merge(null, 8, (v1, v2) -> v1 + v2);

        log.info(map.toString()); //{null=8, C1=2, C2=16}
    }

    enum Category {
        C1, C2
    }
}
