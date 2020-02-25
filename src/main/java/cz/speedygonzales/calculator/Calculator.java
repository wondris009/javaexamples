package cz.speedygonzales.calculator;

import java.util.List;

public class Calculator {

    private List<Operator> operators;

    public Calculator(List<Operator> operators) {
        this.operators = operators;
    }

    protected double doCalculate() {
        double sum = 0;
        for (Operator operator : operators) {
            sum = calculate(operator.getOperation(), sum, operator.getOperand());
        }
        return sum;
    }

    private double calculate(Operation operation, double a, double b) {
        return operation.calculate(a, b);
    }
}
