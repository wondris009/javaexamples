package cz.speedygonzales.calculator;

public class CalculatorDemo {

    public static void main(String[] args) throws ValidationException, OperatorException {

        CalculatorDemo app = new CalculatorDemo();
        app.calculate(args[0]);
    }

    protected double calculate(String path) throws OperatorException, ValidationException {

        Validator validator = new Validator(path);

        OperatorReader operatorReader = new OperatorReader(validator.getData());

        return new Calculator(operatorReader.extractOperators()).doCalculate();

    }
}
