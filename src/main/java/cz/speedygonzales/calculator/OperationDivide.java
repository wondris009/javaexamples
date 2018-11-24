package cz.speedygonzales.calculator;

/**
 */
public class OperationDivide implements Operation {
    @Override
    public double calculate(double operand1, double operand2) {
        return operand1 / operand2;
    }
}
