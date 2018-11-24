package cz.speedygonzales.equi;

/**
 * @author vondracek
 * @since 13.4.15 21:31
 */
public class EquilibriumIndex {

    static int[] inArray = {-1, 3, -4, 5, 1, -6, 2, 1};

    public static void main(String[] args) {

        System.out.println(getEquilibrium(inArray));
        System.out.println(equi(inArray));


    }

    public static int getEquilibrium(int[] inputArray) {

        if (inputArray.length == 0) {
            return -1;
        }

        long sum = 0;
        long leftSum = 0;

        for (int i = 0; i < inputArray.length; i++) {
            leftSum += inputArray[i];
        }

        for (int i = 0; i < inputArray.length; i++) {
            if (sum == leftSum - inputArray[i]) return i;

            sum += inputArray[i];

            leftSum -= inputArray[i];
        }

        return -1;
    }

    static int equi(int[] A) {

        long sum = 0, leftsum = 0;
        int i, l = A.length;
        for (i = 0; i < l; i++) {
            sum += A[i];
        }
        for (i = 0; i < l; i++) {
            sum -= A[i];
            if (leftsum == sum) {
                return i;
            }
            leftsum += A[i];
        }
        return -1;
    }

}
