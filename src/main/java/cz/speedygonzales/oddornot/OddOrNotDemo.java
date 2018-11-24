package cz.speedygonzales.oddornot;

public class OddOrNotDemo {

    public static void main(String[] args) {

        int[] myNumbers = {-5, -4, -3, -2, -1, 1, 2, 3, 4, 5};

        for (int i = 0; i < myNumbers.length; i++) {
            System.out.println(i + (oddOrNot1(myNumbers[i]) ? " is" : " is not") + " even");
            System.out.println(i + (oddOrNot2(myNumbers[i]) ? " is" : " is not") + " even");
        }
    }

    static boolean oddOrNot1(int num) {
        return num % 2 == 0;
    }

    static boolean oddOrNot2(int num) {
        return (num & 1) != 0;
    }

    static void printResult(int iteration, boolean oddResult) {
        System.out.println(iteration + (oddResult ? " is" : "is not") + " even");
    }
}
