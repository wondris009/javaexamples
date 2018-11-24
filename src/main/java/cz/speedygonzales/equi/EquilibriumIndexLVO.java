package cz.speedygonzales.equi;

/**
 * @author vondracek
 * @since 13.4.15 21:31
 */
public class EquilibriumIndexLVO {

    static int[] inArray = {-1, 3, -4, 5, 1, -6, 2, 1};

    public static void main(String[] args) {

        for (int i = 0; i < inArray.length; i++) {
            System.out.println(getEquilibrium(i, inArray));
        }


    }

    public static String getEquilibrium(int index, int[] inputArray) {

        if (inputArray.length == 0) {
            return "empty array";
        }

        long leftSum = 0;
        long rightSum = 0;

        for (int i = 0; i < index; i++) {
            leftSum += inputArray[i];
        }

        for (int i = index + 1; i < inputArray.length; i++) {
            rightSum += inputArray[i];
        }

        StringBuilder sb = new StringBuilder();
        sb.append("index:").append(index);
        if (leftSum == rightSum) {
            sb.append(" IS equilibrium index");
        } else {
            sb.append(" IS NOT equilibrium index");

        }

        return sb.toString();
    }
}
