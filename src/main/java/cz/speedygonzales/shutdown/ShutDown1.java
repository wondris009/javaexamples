package cz.speedygonzales.shutdown;

public class ShutDown1 {

    public static void main(String[] args) {

        for (int i = 1; i < 6; i++) {

            try {

                if (i == 4) {
                    System.out.println("Inside condition i == 4");
                    System.exit(0);
                }

            } finally {
                System.out.println("Finally i = " + i);

            }
        }
    }
}
