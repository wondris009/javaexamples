package cz.speedygonzales.calculator;

import lombok.Getter;

@Getter
public class Operator {

    private double operand;

    private Operation operation;

    public Operator(double operand, Operation operation) {
        this.operand = operand;
        this.operation = operation;
    }
}
