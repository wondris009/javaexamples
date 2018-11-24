package cz.speedygonzales.exceptions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: vondracek
 * Date: 11.7.13
 * Time: 8:36
 * To change this template use File | Settings | File Templates.
 */
public class TestingExceptions {


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {

            p("inside try block");

//            Date date = parseDate("11/11/2001"); //date is null because problem during parsing

            methodThrowsException();

            p("after method which throws exception");

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

    private static void methodThrowsException() throws Exception {

//        throw new Exception("Problem happened.");
        throw new IllegalStateException("Problem happened.");
    }

    private static Date parseDate(String date) {


        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

        Date parseDate = null;

        try {
            parseDate = sdf.parse(date);
        } catch (ParseException e) {
            p("parse error");
        }

        p("after parse");

        return parseDate;

    }


}
