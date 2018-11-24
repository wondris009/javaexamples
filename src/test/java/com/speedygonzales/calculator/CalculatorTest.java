package com.speedygonzales.calculator;

import cz.speedygonzales.calculator.Calculator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CalculatorTest {

    Calculator calc = new Calculator();

    @Test
    public void getSecondOperand() throws Exception {

        assertEquals(new Double(calc.getSecondOperand("ADD 5")), new Double(5));
        assertEquals(new Double(calc.getSecondOperand("ADD     5")), new Double(5));
        assertEquals(new Double(calc.getSecondOperand("ADD5")), new Double(5));
    }

    @Test
    public void unableToGetSecondOperand() throws Exception {
        try {
            assertEquals(new Double(calc.getSecondOperand("ADD")), new Double(5));
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    @Test
    public void getOperation() throws Exception {
    }

}