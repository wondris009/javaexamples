package cz.speedygonzales.calculator;

/**
 */
public class OperationAdd implements Operation {
    @Override
    public double calculate(double operand1, double operand2) {
        return operand1 + operand2;
    }
}
