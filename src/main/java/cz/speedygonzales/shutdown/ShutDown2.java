package cz.speedygonzales.shutdown;

public class ShutDown2 {

    public static void main(String[] args) {

        for (int i = 1; i < 6; i++) {

            final int final_i = i;

            try {
                Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                    if (final_i == 4) {
                        System.out.println("Inside try block");
                        System.exit(0);
                    }
                }));

            } finally {
                System.out.println("Finally i = " + i);
            }
        }

    }
}
