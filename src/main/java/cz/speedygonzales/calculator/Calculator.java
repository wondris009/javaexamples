package cz.speedygonzales.calculator;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 */
public class Calculator {

    public static void main(String[] args) throws Exception {

        Calculator app = new Calculator();
        app.validate(args);

        List<String> instructions = Files.readAllLines(Paths.get(args[0]));

        System.out.println(app.doCalculate(instructions));
    }

    private void validate(String[] args) {

        if (args.length != 1) {
            doExit("Specify input data text file as program first parameter.");
        }

        String path = args[0];
        File inputFile = new File(path);

        if (!inputFile.exists()) {
            doExit("Resource does not exist '" + inputFile.getAbsolutePath() + "'.");

        }

        if (!inputFile.isFile()) {
            doExit("Specified path " + inputFile.getAbsolutePath() + "is not file.");
        }
    }

    private void doExit(String errorMsg) {
        System.out.println(errorMsg);
        System.exit(-1);
    }

    private double doCalculate(List<String> instructions) throws Exception {

        double sum = 0;

        for (String instruction : instructions) {
            double secondOperand = getSecondOperand(instruction);
            Operation operation1 = getOperation(instruction);
            sum = calculate(operation1, sum, secondOperand);

        }
        return sum;
    }

    double calculate(Operation operation, double a, double b) throws Exception {
        if (b == 0) {
            throw new Exception("Cant divide by " + b);
        }
        return operation.calculate(a, b);
    }

    public double getSecondOperand(String line) throws Exception {

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);

            if (Character.isDigit(c)) {
                return Double.valueOf(line.substring(i).trim());
            }
        }

        throw new Exception("Can't locate operand in instruction " + line);
    }

    Operation getOperation(String line) {

        String operationName = line.split(" ")[0].trim();

        Operation operation = null;

        switch (operationName) {
            case "ADD":
                operation = new OperationAdd();
                break;
            case "SUB":
                operation = new OperationSubstract();
                break;
            case "MUL":
                operation = new OperationMultiply();
                break;
            case "DIV":
                operation = new OperationDivide();
                break;
        }

        if (operation == null) {
            throw new IllegalStateException("Unable to identify operation by name " + operationName);
        }

        return operation;
    }
}
