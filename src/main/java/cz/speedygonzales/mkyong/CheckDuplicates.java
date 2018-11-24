package cz.speedygonzales.mkyong;

import cz.speedygonzales.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

/**
 * Checks duplicates in array.
 * <p>
 * Created by: vondracek - 14.3.15 19:51
 */
@Slf4j
public class CheckDuplicates {

    static String[] inputArray1 = new String[]{"a", "b", "c", "d"};
    static String[] inputArray2 = new String[]{"a", "b", "c", "a"};
    static String[][] all = new String[][]{inputArray1, inputArray2};

    public static void main(String[] args) {

        for (String[] stringArray : all) {

            log.info(StringUtils.getInstance().printArrayValues(stringArray));

            if (checkDuplicateNormal(stringArray)) {
                log.info("Normal duplication method: Values in array are duplicated.");
            }

            if (checkDuplicationWithSet(stringArray)) {
                log.info("Set duplication method: Values in array are duplicated.");
            }
        }
    }

    private static boolean checkDuplicationWithSet(String[] stringArray) {

        Set<String> sValueSet = new HashSet<String>();

        for (String value : stringArray) {

            if (sValueSet.contains(value)) return true;

            else if (!value.equals("")) sValueSet.add(value);
        }

        return false;
    }

    private static boolean checkDuplicateNormal(String[] stringArray) {

        for (int i = 0; i < stringArray.length; i++) {

            String sValueToCheck = stringArray[i];

            if (sValueToCheck == null || sValueToCheck.equals("")) continue; //empty ignore

            for (int j = 0; j < stringArray.length; j++) {

                if (i == j) continue; //same line ignore

                String sValueToCompare = stringArray[j];

                if (sValueToCheck.equals(sValueToCompare)) {
                    return true;
                }
            }

        }

        return false;
    }


}
