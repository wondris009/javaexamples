package com.speedygonzales.codility;

import cz.speedygonzales.codility.StringCalculator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author vondracek
 * @since 20.4.15 16:38
 */
public class StringCalculatorTest {

    private StringCalculator stringCalculator;

    private String INPUT = "13+";
    private String INPUT2 = "13+6*";
    private String INPUT3 = "539*+";
    private String INPUT4 = "48*8+9+";
    private String INVALID_INPUT1 = "13+6*+";
    private String INVALID_INPUT2 = "13";
    private String INVALID_INPUT3 = "+++";


    @Before
    public void setUp() throws Exception {
        stringCalculator = new StringCalculator();
    }

    @Test
    public void test1() {
        int calculate = stringCalculator.calculate(INPUT);
        Assert.assertEquals(4, calculate);
    }

    @Test
    public void test2() {
        int calculate = stringCalculator.calculate(INPUT2);
        Assert.assertEquals(24, calculate);
    }

    @Test
    public void test3() {
        int calculate = stringCalculator.calculate(INPUT3);
        Assert.assertEquals(24, calculate);
    }

    @Test
    public void test4() {
        int calculate = stringCalculator.calculate(INPUT4);
        Assert.assertEquals(49, calculate);
    }

    @Test
    public void testInvalid1() {
        int calculate = stringCalculator.calculate(INVALID_INPUT1);
        Assert.assertEquals(-1, calculate);
    }

    @Test
    public void testInvalid2() {
        int calculate = stringCalculator.calculate(INVALID_INPUT2);
        Assert.assertEquals(-1, calculate);
    }

    @Test
    public void testInvalid3() {
        int calculate = stringCalculator.calculate(INVALID_INPUT3);
        Assert.assertEquals(-1, calculate);
    }

    @Test
    public void testNull() {
        int calculate = stringCalculator.calculate(null);
        Assert.assertEquals(-1, calculate);
    }

    @Test
    public void testEmpty() {
        int calculate = stringCalculator.calculate("");
        Assert.assertEquals(-1, calculate);
    }

    @Test
    public void testMissing() {
        int calculate = stringCalculator.calculate("   ");
        Assert.assertEquals(-1, calculate);
    }
}

