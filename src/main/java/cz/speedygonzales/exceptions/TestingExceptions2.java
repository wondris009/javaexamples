package cz.speedygonzales.exceptions;

/**
 * Created with IntelliJ IDEA.
 * User: vondracek
 * Date: 11.7.13
 * Time: 8:36
 * To change this template use File | Settings | File Templates.
 */
public class TestingExceptions2 {


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {

            outerMethod();

        } catch (Exception e) {
            p("inside catch block");
        } finally {
            p("inside finally block");
        }

        p("after all");
    }

    private static void p(String s) {

        System.out.println(s);
    }

    private static void methodThrowsException() {

        throw new IllegalStateException("Problem happened.");
    }

    private static void outerMethod() throws Exception {

        methodThrowsException();


    }

}
