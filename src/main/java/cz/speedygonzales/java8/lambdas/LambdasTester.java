package cz.speedygonzales.java8.lambdas;

import lombok.extern.slf4j.Slf4j;

import java.io.File;

/**
 * @author vondracek
 * @since 28.6.2016 18:38
 */
@Slf4j
public class LambdasTester {

    public static void main(String[] args) {

        LambdasTester lambdasTester = new LambdasTester();

        lambdasTester.howToLambdas1();
        log.info("--------------------");
        lambdasTester.howToLambdas2();
    }


    public void howToLambdas1() {

        File[] textFile = new File("c:/tmp/lambdas/").listFiles(MyFile::isText);

        for (File file : textFile) {
            log.info(file.getAbsolutePath());
        }
    }

    public void howToLambdas2() {

        File[] textFile = new File("c:/tmp/lambdas/").listFiles((File f) -> f.getName().endsWith("csv"));

        for (File file : textFile) {
            log.info(file.getAbsolutePath());
        }
    }


}
