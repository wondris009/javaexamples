package cz.speedygonzales.searching;

import java.util.Arrays;

/**
 */
public class BinarySearchTest {

    public static void main(String[] args) {

        int[] myArray = new int[]{1, 3, 5, 7, 9, 11, 13, 14, 16};

        int i = Arrays.binarySearch(myArray, 11);

        System.out.println(i);

        System.out.println(doBinarySearch(myArray, 11));
        System.out.println(doBinarySearchRecursive(myArray, 11, 0, myArray.length - 1));


    }

    static int doBinarySearch(int[] array, int number) {

        int low = 0;
        int high = array.length - 1;

        while (low <= high) {

            int mid = (low + high) >>> 1;
            int midVal = array[mid];

            if (number < midVal) {
                high = mid - 1;
            } else if (number > midVal) {
                low = mid + 1;
            } else {
                return mid;
            }
        }

        return -(low + 1);
    }

    static int doBinarySearchRecursive(int[] array, int number, int low, int high) {


        int mid = low + high >>> 1;
        int midValue = array[mid];

        if (midValue == number) {
            return mid;
        }

        if (number < midValue) {
            return doBinarySearchRecursive(array, number, low, mid - 1);
        } else {
            return doBinarySearchRecursive(array, number, mid + 1, high);
        }
    }
}
