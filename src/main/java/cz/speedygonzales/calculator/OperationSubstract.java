package cz.speedygonzales.calculator;

/**
 */
public class OperationSubstract implements Operation {
    @Override
    public double calculate(double operand1, double operand2) {
        return operand1 - operand2;
    }
}
